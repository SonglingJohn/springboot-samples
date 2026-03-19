package top.sljiang.week03.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class BaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getInfo() throws Exception {
        // 模拟发送 GET 请求到 /config/getInfo
        mockMvc.perform(MockMvcRequestBuilders.get("/config/info")
                        // 关键：指定编码为 UTF-8（解决中文乱码问题）
                        )
                // 期望：响应状态码是 200（成功）
                .andExpect(MockMvcResultMatchers.status().isOk())
                // 可选：打印出返回的内容，方便你在后台看中文是不是正常
                .andDo(result -> System.out.println("接口返回内容：\n" + result.getResponse().getContentAsString()));
    }
}