package net.bndy.ftsi.starter;

import net.bndy.ftsi.IndexService;
import net.bndy.lib.StringHelper;
import org.apache.lucene.analysis.Analyzer;
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
@ConditionalOnProperty(prefix = "spring.ftsi", name = "enabled", matchIfMissing = true)
public class IndexServiceAutoConfiguration {

    @Autowired
    private IndexServiceAutoConfigurationProperties properties;

    @Bean
    @ConditionalOnMissingBean(IndexService.class)
    public IndexService indexService() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Analyzer analyzer = null;
        if (!StringHelper.isNullOrWhiteSpace(properties.getAnalyzer())) {
            Class clazz = Class.forName(properties.getAnalyzer());
            analyzer = (Analyzer) clazz.newInstance();
        }
        IndexService service = new IndexService(properties.getDataPath(),
            analyzer,
            properties.getHighlightPreTag(),
            properties.getHighlightPostTag(),
            properties.getHighlightFragmentSize());
        return service;
    }
}
