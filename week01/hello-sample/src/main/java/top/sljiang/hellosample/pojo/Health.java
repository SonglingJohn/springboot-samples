package top.sljiang.hellosample.pojo;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Health {
    private String projectName;
    private String version;
    private String serverTime;
    private String status;

    // 接收真实配置值，动态生成时间和状态
    public Health(String projectName, String version) {
        this.projectName = projectName;
        this.version = version;
        // 实时获取服务器当前时间（每次调用接口都刷新）
        this.serverTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        // 真实运行状态（可扩展检查数据库/Redis等依赖）
        this.status = "RUNNING";
    }
}