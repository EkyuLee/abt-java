package com.jtre;

import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
@NoArgsConstructor
public class ClusterConfigurationProperties {
    List<String> nodes;

    public ClusterConfigurationProperties(List<String> nodes) {
        this.nodes = nodes;
    }
}
