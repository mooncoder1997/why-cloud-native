package why.scaffold.security.core.properties;

import lombok.Data;

/**
 * @className: ValidateCodeProperties
 * @description: 验证码配置属性
 * @version: v1.0
 * @date: 2019/8/1 10:45
 * @author: Wang, Haoyue
 */
@Data
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();
}
