package why.scaffold.common.constants;

/**
 * @className: SecurityConstants
 * @description: 安全配置常量池
 * @version: v1.0
 * @date: 2019/8/1 10:41
 * @author: Wang, Haoyue
 */
public class SecurityConstants {

    /** 默认登陆页面 */
    public static final String DEFAULT_LOGIN_PAGE_URL = "/why-signIn.html";

    /** 当请求需要身份验证时，默认跳转的url */
    public static final String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";

    /** 默认的表单用户名密码登陆请求处理url */
    public static final String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/form";

    /** 默认的Rest用户名密码登陆请求处理url */
    public static final String DEFAULT_LOGIN_PROCESSING_URL_REST = "/authentication/rest";
}
