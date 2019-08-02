package why.scaffold.security.core.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.structlog4j.ILogger;
import com.github.structlog4j.SLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import why.scaffold.common.support.SimpleResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: WHYAuthenticationFailHandler
 * @description: 自定义Rest认证失败处理逻辑
 * @version: v1.0
 * @date: 2019/8/1 10:50
 * @author: Wang, Haoyue
 */
@Component("whyAuthenticationFailureHandler")
public class WHYAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final ILogger logger = SLoggerFactory.getLogger(WHYAuthenticationFailHandler.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("[WHYAuthenticationFailHandler] onAuthenticationFailure 登录失败");
        // 设置HTTP响应码为500
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        // 设置HTTP响应体为JSON
        response.setContentType("application/json;charset=UTF-8");
        // 将认证失败错误消息写入响应
        response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(500, exception.getMessage())));
    }
}
