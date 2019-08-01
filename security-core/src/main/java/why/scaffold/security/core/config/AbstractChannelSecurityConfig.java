package why.scaffold.security.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import why.scaffold.common.constants.SecurityConstants;

/**
 * @className: AbstractChannelSecurityConfig
 * @description: 用户名密码登录安全配置
 * @version: v1.0
 * @date: 2019/8/1 11:09
 * @author: Wang, Haoyue
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler whyAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler whyAuthenticationFailureHandler;

    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(whyAuthenticationSuccessHandler)
                .failureHandler(whyAuthenticationFailureHandler);
    }
}
