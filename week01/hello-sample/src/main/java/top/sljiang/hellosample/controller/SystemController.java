package top.sljiang.hellosample.controller;



import org.springframework.boot.SpringBootVersion;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.sljiang.hellosample.HelloSampleApplication;
import top.sljiang.hellosample.pojo.SystemInfo;
import top.sljiang.hellosample.vo.ResultVO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("api/system")
public class SystemController {

    private final Environment env;

    // 注入 Spring 环境对象（替代 @Value，避免占位符解析问题）
    public SystemController(Environment env) {
        this.env = env;
    }

    @GetMapping("/info")
    public ResultVO<SystemInfo> getSystemInfo() {
        // 构建系统信息对象
        SystemInfo systemInfo = new SystemInfo();
        // 项目名称（写死，匹配 pom.xml 中的 artifactId）
        systemInfo.setProjectName("hello-sample");
        // 项目版本号（写死，匹配 pom.xml 中的 version）
        systemInfo.setVersion("0.0.1-SNAPSHOT");
        // 服务器当前时间（实时生成）
        systemInfo.setServerTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        // 运行状态
        systemInfo.setStatus("RUNNING");
        // JDK 版本
        systemInfo.setJavaVersion(System.getProperty("java.version"));
        // Spring Boot 版本
        systemInfo.setSpringBootVersion(SpringBootVersion.getVersion());
        // 运行环境（激活的 profile）
        String[] activeProfiles = env.getActiveProfiles();
        systemInfo.setEnvironment(activeProfiles.length > 0 ? activeProfiles[0] : "default");

        return new ResultVO<>(200, "success", systemInfo);
    }
}