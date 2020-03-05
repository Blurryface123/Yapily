package com.Andres.Yapily.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "text",
        "source",
        "source_url",
        "language",
        "permalink"
})
public class Fact implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("text")
    private String text;
    @JsonProperty("source")
    private String source;
    @JsonProperty("source_url")
    private String sourceUrl;
    @JsonProperty("language")
    private String language;
    @JsonProperty("permalink")
    private String permalink;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8512010985026647280L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Fact() {
    }

    /**
     *
     * @param sourceUrl
     * @param language
     * @param id
     * @param text
     * @param source
     * @param permalink
     */
    public Fact(String id, String text, String source, String sourceUrl, String language, String permalink) {
        super();
        this.id = id;
        this.text = text;
        this.source = source;
        this.sourceUrl = sourceUrl;
        this.language = language;
        this.permalink = permalink;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("source_url")
    public String getSourceUrl() {
        return sourceUrl;
    }

    @JsonProperty("source_url")
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("permalink")
    public String getPermalink() {
        return permalink;
    }

    @JsonProperty("permalink")
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("text", text).append("source", source).append("sourceUrl", sourceUrl).append("language", language).append("permalink", permalink).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sourceUrl).append(language).append(id).append(text).append(source).append(additionalProperties).append(permalink).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Fact) == false) {
            return false;
        }
        Fact rhs = ((Fact) other);
        return new EqualsBuilder().append(sourceUrl, rhs.sourceUrl).append(language, rhs.language).append(id, rhs.id).append(text, rhs.text).append(source, rhs.source).append(additionalProperties, rhs.additionalProperties).append(permalink, rhs.permalink).isEquals();
    }

}