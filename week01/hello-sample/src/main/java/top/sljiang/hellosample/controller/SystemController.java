package top.sljiang.hellosample.controller;





import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.sljiang.hellosample.pojo.SystemInfo;
import top.sljiang.hellosample.vo.ResultVO;


/**
 * 系统信息接口（严格匹配 /api/system/info 规格）
 */
@RestController
@RequestMapping("api/system")
public class SystemController {

    /** 注入服务运行端口 */
    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/info")
    public ResultVO<SystemInfo> getSystemInfo() {
        // 构建系统信息数据（通过JDK/Actuator采集真实值）
        SystemInfo systemInfoDTO = new SystemInfo();
        systemInfoDTO.setJavaVersion(System.getProperty("java.version")); // JDK版本
        systemInfoDTO.setSpringBootVersion(SpringBootVersion.getVersion()); // Spring Boot版本
        systemInfoDTO.setOsName(System.getProperty("os.name")); // 操作系统名称
        systemInfoDTO.setOsArch(System.getProperty("os.arch")); // 操作系统架构
        systemInfoDTO.setServerPort(serverPort); // 服务端口

        // 按规格返回：code=200，msg="system info query success"
        return new ResultVO<>(200, "system info query success", systemInfoDTO);
    }
}