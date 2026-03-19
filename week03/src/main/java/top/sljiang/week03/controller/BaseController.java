package top.sljiang.week03.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sljiang.week03.config.appcConfig;

@Controller
@RestController
@RequestMapping("/config")
@Slf4j
public class BaseController {
    @Value("${server.port}")
    private Integer port;
    @Autowired
    private appcConfig config;


    @GetMapping("/info")
    public String getInfo(){
        log.info("app.name = {}", config.getName());
        log.info("app.description = {}", config.getDescription());
          return """
                当前配置为：%s %s %s %s
                系统名称：%s
                版本号：%s
                项目描述：%s
                版本更新时间：%s
                """.formatted(
                  config.getName(),
                  config.getVersion(),
                  config.getDescription(),
                  config.getVersionDate(),
                  config.getName(),
                  config.getVersion(),
                  config.getDescription(),
                  config.getVersionDate());
    }




}
