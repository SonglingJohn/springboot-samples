package top.sljiang.week04_3.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author mqxu
 * @date 2026/3/26
 * @description Spring MVC 配置类：自定义消息转换器
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 自定义 Jackson 消息转换器
     * 解决：LocalDateTime 日期格式统一、Long 类型转字符串避免前端精度丢失
     */
    @Bean
    public MappingJackson2HttpMessageConverter customJacksonConverter() {
        // 定义日期格式化规则
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 构建 ObjectMapper，配置序列化规则
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .modules(new JavaTimeModule().addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter)),
                        new SimpleModule().addSerializer(Long.class, ToStringSerializer.instance))
                .build();
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("upload/**")
                .addResourceLocations("classpath:/static/upload");
    }
}