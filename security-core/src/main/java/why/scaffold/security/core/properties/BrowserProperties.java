package why.scaffold.security.core.properties;

import lombok.Data;
import why.scaffold.common.constants.SecurityConstants;

/**
 * @className: BrowserProperties
 * @description: 浏览器安全配置
 * @version: v1.0
 * @date: 2019/8/1 10:39
 * @author: Wang, Haoyue
 */
@Data
public class BrowserProperties {

    private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

    private LoginType loginType = LoginType.JSON;

    private int rememberMeSeconds = 3600;
}
