package why.scaffold.security.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import why.scaffold.common.constants.SecurityConstants;
import why.scaffold.security.core.filter.WHYAuthenticationFilter;

/**
 * @className: SecurityConfig
 * @description:
 * @version: v1.0
 * @date: 2019/8/1 11:07
 * @author: Wang, Haoyue
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler whyAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler whyAuthenticationFailureHandler;

    @Autowired
    private UserDetailsService whyUserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(whyAuthenticationSuccessHandler)
                .failureHandler(whyAuthenticationFailureHandler)
                .and()
                .userDetailsService(whyUserDetailService)
                .authorizeRequests()
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_REST)
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();

        http.addFilterAt(whyAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 注入Rest自定义账户名密码过滤器
    @Bean
    WHYAuthenticationFilter whyAuthenticationFilter() throws Exception {
        WHYAuthenticationFilter filter = new WHYAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(whyAuthenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(whyAuthenticationFailureHandler);
        filter.setFilterProcessesUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_REST);
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }
}
