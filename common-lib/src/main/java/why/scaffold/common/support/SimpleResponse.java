package why.scaffold.common.support;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @className: SimpleResponse
 * @description:
 * @version: v1.0
 * @date: 2019/8/1 10:56
 * @author: Wang, Haoyue
 */
@Data
@AllArgsConstructor
public class SimpleResponse {

    private Integer code;

    private Object content;
}
