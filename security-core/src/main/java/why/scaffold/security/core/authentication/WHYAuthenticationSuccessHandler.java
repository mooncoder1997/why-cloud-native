package why.scaffold.security.core.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.structlog4j.ILogger;
import com.github.structlog4j.SLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import why.scaffold.security.core.properties.LoginType;
import why.scaffold.security.core.properties.SecurityProperties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: WHYAuthenticationSuccessHandler
 * @description: 自定义认证成功处理器
 * @version: v1.0
 * @date: 2019/8/1 10:59
 * @author: Wang, Haoyue
 */
@Component("whyAuthenticationSuccessHandler")
public class WHYAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    static final ILogger logger = SLoggerFactory.getLogger(WHYAuthenticationSuccessHandler.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        logger.info("[WHYAuthenticationSuccessHandler] onAuthenticationSuccess 登录成功");
        // 如果配置登录跳转类型为JSON （默认配置为JSON）
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            // 设置HTTP响应体为JSON
            response.setContentType("application/json;charset=UTF-8");
            // 将认证成功用户消息写入响应
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
