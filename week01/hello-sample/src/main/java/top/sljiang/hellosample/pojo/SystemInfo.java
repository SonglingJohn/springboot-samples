package top.sljiang.hellosample.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemInfo {
    private String projectName;
    private String version;
    private String serverTime;
    private String status;
    private String javaVersion;
    private String springBootVersion;
    private String environment;
}