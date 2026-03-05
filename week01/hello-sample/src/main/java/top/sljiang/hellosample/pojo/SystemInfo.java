package top.sljiang.hellosample.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统信息接口返回数据实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemInfo {
    /** JDK版本 */
    private String javaVersion;
    /** Spring Boot版本 */
    private String springBootVersion;
    /** 操作系统名称 */
    private String osName;
    /** 操作系统架构 */
    private String osArch;
    /** 服务运行端口 */
    private Integer serverPort;
}