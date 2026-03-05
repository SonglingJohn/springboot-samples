package top.sljiang.hellosample.controller;






import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import top.sljiang.hellosample.pojo.Health;
import top.sljiang.hellosample.vo.ResultVO;

/**
 * 健康检查接口（修复版：无需@Value注入，直接获取环境）
 */
@RestController
@RequestMapping("api")
public class HealthController {

    // 注入Spring环境对象（替代@Value，100%生效）
    @Resource
    private Environment environment;

    @GetMapping("/health")
    public ResultVO<Health> health() {
        Health healthDTO = new Health();
        healthDTO.setStatus("UP");

        // 核心修复：获取当前激活的环境名称（dev/test/prod）
        String[] activeProfiles = environment.getActiveProfiles();
        String env = activeProfiles.length > 0 ? activeProfiles[0] : "dev"; // 默认dev
        healthDTO.setEnv(env);

        healthDTO.setTimestamp(System.currentTimeMillis());

        // 严格匹配规格文档的返回值
        return new ResultVO<>(200, "service is healthy", healthDTO);
    }
}