package top.sljiang.hellosample.controller;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sljiang.hellosample.pojo.Health;
import top.sljiang.hellosample.vo.ResultVO;


@RestController
@RequestMapping("api")
// 移除 @RequiredArgsConstructor，避免Lombok注入问题
public class HealthController {

    @Value("${app.name}")
    private String projectName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/health")
    public ResultVO<Health> health() {
        Health health = new Health(projectName, appVersion);
        return new ResultVO<>(200, "success", health);
    }
}