package com.Andres.Yapily.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
        "code",
        "lang",
        "text"
})
public class Translation implements Serializable
{

    @JsonProperty("code")
    private Long code;
    @JsonProperty("lang")
    private String lang;
    @JsonProperty("text")
    private List<String> text = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3667377024175876374L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Translation() {
    }

    /**
     *
     * @param code
     * @param text
     * @param lang
     */
    public Translation(Long code, String lang, List<String> text) {
        super();
        this.code = code;
        this.lang = lang;
        this.text = text;
    }

    @JsonProperty("code")
    public Long getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(Long code) {
        this.code = code;
    }

    @JsonProperty("lang")
    public String getLang() {
        return lang;
    }

    @JsonProperty("lang")
    public void setLang(String lang) {
        this.lang = lang;
    }

    @JsonProperty("text")
    public List<String> getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(List<String> text) {
        this.text = text;
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
        return new ToStringBuilder(this).append("code", code).append("lang", lang).append("text", text).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(code).append(text).append(additionalProperties).append(lang).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Translation) == false) {
            return false;
        }
        Translation rhs = ((Translation) other);
        return new EqualsBuilder().append(code, rhs.code).append(text, rhs.text).append(additionalProperties, rhs.additionalProperties).append(lang, rhs.lang).isEquals();
    }

}