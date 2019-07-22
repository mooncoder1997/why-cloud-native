package why.scaffold.common.auth;

import lombok.Getter;
import why.scaffold.common.api.ResultCode;

/**
 * @className: PermissionDeniedException
 * @description:
 * @version: v1.0
 * @date: 2019-07-23 00:17
 * @author: Wang, Haoyue
 */
public class PermissionDeniedException extends RuntimeException {

    @Getter
    private final ResultCode resultCode;

    public PermissionDeniedException(String message) {
        super(message);
        this.resultCode = ResultCode.UN_AUTHORIZED;
    }

    public PermissionDeniedException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
    }

    public PermissionDeniedException(ResultCode resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
