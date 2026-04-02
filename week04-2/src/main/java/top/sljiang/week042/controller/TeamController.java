package top.sljiang.week042.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sljiang.week042.common.Result;
import top.sljiang.week042.exception.BusinessException;
import top.sljiang.week042.pojo.Team;

import java.net.http.HttpRequest;

@Slf4j
@RestController
@RequestMapping("/api/team")
public class TeamController {
    @PostMapping
    public Result<?> createTeam(@Valid @RequestBody Team team , HttpServletRequest request) {
        log.info("创建团队");
        String token =request.getHeader("token");
        if(token == null || token.isEmpty()){
            throw new BusinessException("请先登录",401);        }
        if(!"admin".equals(token)){
            throw new BusinessException("没有权限",403);
        }
        return Result.success("添加成功");
    }
}
