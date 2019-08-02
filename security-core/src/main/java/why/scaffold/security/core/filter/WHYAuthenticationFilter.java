package why.scaffold.security.core.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import why.scaffold.security.core.entity.AuthenticationBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @className: WHYAuthenticationFilter
 * @description: 自定义Rest登陆过滤器
 * @version: v1.0
 * @date: 2019-08-01 21:10
 * @author: Wang, Haoyue
 */
public class WHYAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (MediaType.APPLICATION_JSON_UTF8_VALUE.equals(request.getContentType())
                || MediaType.APPLICATION_JSON_VALUE.equals(request.getContentType())) {
            UsernamePasswordAuthenticationToken authenticationToken = null;
            try (InputStream inputStream = request.getInputStream()) {
                AuthenticationBean authenticationBean = objectMapper.readValue(inputStream, AuthenticationBean.class);
                authenticationToken = new UsernamePasswordAuthenticationToken(authenticationBean.getUsername(), authenticationBean.getPassword());
            } catch (IOException e) {
                e.printStackTrace();
                authenticationToken = new UsernamePasswordAuthenticationToken("", "");
            } finally {
                setDetails(request, authenticationToken);
                return this.getAuthenticationManager().authenticate(authenticationToken);
            }
        } else {
            return super.attemptAuthentication(request, response);
        }
    }
}
