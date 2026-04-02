package top.sljiang.week042.exception;

import lombok.Getter;

/**
 * @author Administrator
 */
@Getter
public class BusinessException extends RuntimeException{

    private final int code;

    public BusinessException(String message) {
        super(message);
        this.code = 401;
    }
    public BusinessException(String message,int code) {
        super(message);
        this.code = code;
    }
}
