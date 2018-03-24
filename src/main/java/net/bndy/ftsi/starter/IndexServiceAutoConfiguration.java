package net.bndy.ftsi.starter;

import net.bndy.ftsi.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(IndexServiceAutoConfigurationProperties.class)
@ConditionalOnClass(IndexService.class)
@ConditionalOnProperty(prefix = "ftsi", value = "enabled", matchIfMissing = true)
public class IndexServiceAutoConfiguration {

    @Autowired
    private IndexServiceAutoConfigurationProperties properties;

    @Bean
    @ConditionalOnMissingBean(IndexService.class)
    public IndexService indexService() {
        IndexService service = new IndexService(properties.getDataPath(),
            properties.getHighlightPreTag(),
            properties.getHighlightPostTag(),
            properties.getHighlightFragmentSize());
        return service;
    }
}
