package why.scaffold.security.core.controller;

import com.github.structlog4j.ILogger;
import com.github.structlog4j.SLoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import why.scaffold.common.constants.SecurityConstants;
import why.scaffold.common.support.SimpleResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: BrowserSecurityController
 * @description:
 * @version: v1.0
 * @date: 2019/8/1 14:04
 * @author: Wang, Haoyue
 */
@RestController
public class SecurityController {

    private static final ILogger logger = SLoggerFactory.getLogger(SecurityController.class);

    private RequestCache requestCache = new HttpSessionRequestCache();

    @RequestMapping(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            logger.info("[BrowserSecurityController] requireAuthentication 引发跳转的请求是: " + targetUrl);
        }
        return new SimpleResponse(500, "用户未登陆");
    }
}
