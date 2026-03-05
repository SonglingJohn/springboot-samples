package top.sljiang.hellosample.controller;

/**
 * @author Administrator
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sljiang.hellosample.vo.ResultVO;

@RestController
public class HelloController {
    @RequestMapping("/api")

    @GetMapping("/hello")
    public ResultVO<String> hello() {

        String message = "Hello Spring Boot";

        return ResultVO.success(message);
    }

}