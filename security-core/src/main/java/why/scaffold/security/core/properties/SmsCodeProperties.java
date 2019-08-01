package why.scaffold.security.core.properties;

import lombok.Data;

/**
 * @className: SmsCodeProperties
 * @description:
 * @version: v1.0
 * @date: 2019/8/1 10:45
 * @author: Wang, Haoyue
 */
@Data
public class SmsCodeProperties {

    private int length = 6;

    private int expireIn = 60;

    private String url;
}
