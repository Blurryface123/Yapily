package com.Andres.Yapily.entity;

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
        "total",
        "unique"
})
public class Response {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("unique")
    private Integer unique;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8470560039762845251L;


    /**
     *
     * @param total
     * @param unique
     */
    public Response(Integer total, Integer unique) {
        super();
        this.total = total;
        this.unique = unique;
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Response() {
    }


    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("unique")
    public Integer getUnique() {
        return unique;
    }

    @JsonProperty("unique")
    public void setUnique(Integer unique) {
        this.unique = unique;
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
        return new ToStringBuilder(this).append("total", total).append("unique", unique).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(total).append(additionalProperties).append(unique).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Response) == false) {
            return false;
        }
        Response rhs = ((Response) other);
        return new EqualsBuilder().append(total, rhs.total).append(additionalProperties, rhs.additionalProperties).append(unique, rhs.unique).isEquals();
    }
}
