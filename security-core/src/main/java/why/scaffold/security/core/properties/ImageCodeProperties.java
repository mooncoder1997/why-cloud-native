package why.scaffold.security.core.properties;

import lombok.Data;

/**
 * @className: ImageCodeProperties
 * @description: 图片验证码配置属性
 * @version: v1.0
 * @date: 2019/8/1 10:45
 * @author: Wang, Haoyue
 */
@Data
public class ImageCodeProperties extends SmsCodeProperties {

    private int width = 67;

    private int height = 23;

    ImageCodeProperties() {
        setLength(4);
    }
}
