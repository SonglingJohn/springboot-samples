package top.sljiang.week03.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class appcConfig {
    private String name;
    private String version;
    private String description;
    private String versionDate;

}
