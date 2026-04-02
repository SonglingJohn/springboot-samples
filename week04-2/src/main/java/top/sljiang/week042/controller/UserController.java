package top.sljiang.week042.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sljiang.week042.common.Result;
import top.sljiang.week042.pojo.User;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/user")
public class UserController {

    /**
     * 获取用户信息，测试消息转换器
     */
    @GetMapping("/info")
    public Result<User> getUserInfo() {
        User user = new User();
        user.setId(1234567890123456789L);
        user.setName("springmvc-student");
        user.setCreateTime(LocalDateTime.now());
        return Result.success(user);
    }
}