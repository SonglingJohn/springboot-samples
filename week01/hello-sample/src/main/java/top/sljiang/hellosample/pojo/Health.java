package top.sljiang.hellosample.pojo;







import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 健康检查接口返回数据实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Health {
    /** 运行状态（固定UP） */
    private String status;
    /** 当前运行环境（dev/test/prod） */
    private String env;
    /** 响应时间戳（毫秒） */
    private Long timestamp;
}