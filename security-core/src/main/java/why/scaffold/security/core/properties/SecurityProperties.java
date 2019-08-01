package why.scaffold.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @className: SecurityProperties
 * @description: 安全配置属性
 * @version: v1.0
 * @date: 2019/8/1 10:29
 * @author: Wang, Haoyue
 */
@Data
@ConfigurationProperties(prefix = "why.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();
}
