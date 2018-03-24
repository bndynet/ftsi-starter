package net.bndy.ftsi.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ftsi")
public class IndexServiceAutoConfigurationProperties {

    private String dataPath;
    private String highlightPreTag;
    private String highlightPostTag;
    private int highlightFragmentSize;

    public String getDataPath() {
        return dataPath;
    }

    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }

    public String getHighlightPreTag() {
        return highlightPreTag;
    }

    public void setHighlightPreTag(String highlightPreTag) {
        this.highlightPreTag = highlightPreTag;
    }

    public String getHighlightPostTag() {
        return highlightPostTag;
    }

    public void setHighlightPostTag(String highlightPostTag) {
        this.highlightPostTag = highlightPostTag;
    }

    public int getHighlightFragmentSize() {
        return highlightFragmentSize;
    }

    public void setHighlightFragmentSize(int highlightFragmentSize) {
        this.highlightFragmentSize = highlightFragmentSize;
    }
}
