package top.sljiang.week04_3.handler;


import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.sljiang.week04_3.common.Result;
import top.sljiang.week04_3.exception.BusinessException;


import java.lang.reflect.Field;
import java.util.StringJoiner;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理业务校验异常
     * @param
     * @return
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handleValidException(MethodArgumentNotValidException e) {
        StringJoiner sj = new StringJoiner(",");
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()){
            sj.add(fieldError.getField() + ":" + fieldError.getDefaultMessage());
        }
        return Result.fail(400,sj.toString());
    }

    /**
     * 处理业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result<?> handleBusinessException(BusinessException e) {
        return Result.fail(e.getCode(),e.getMessage());
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        return Result.fail(500,e.getMessage());
    }
}
