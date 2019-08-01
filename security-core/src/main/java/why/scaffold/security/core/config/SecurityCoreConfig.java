package why.scaffold.security.core.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import why.scaffold.security.core.properties.SecurityProperties;

/**
 * @className: SecurityCoreConfig
 * @description: 开启安全配置属性
 * @version: v1.0
 * @date: 2019/8/1 10:38
 * @author: Wang, Haoyue
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
