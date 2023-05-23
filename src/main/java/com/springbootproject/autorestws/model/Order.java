
package com.springbootproject.autorestws.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "order_id",
    "product",
    "price",
    "date"
})
@Generated("jsonschema2pojo")
public class Order {

    @JsonProperty("order_id")
    private Integer orderId;
    @JsonProperty("product")
    private String product;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("date")
    private String date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("order_id")
    public Integer getOrderId() {
        return orderId;
    }

    @JsonProperty("order_id")
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Order withOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    @JsonProperty("product")
    public String getProduct() {
        return product;
    }

    @JsonProperty("product")
    public void setProduct(String product) {
        this.product = product;
    }

    public Order withProduct(String product) {
        this.product = product;
        return this;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    public Order withPrice(Double price) {
        this.price = price;
        return this;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    public Order withDate(String date) {
        this.date = date;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Order withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Order.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("orderId");
        sb.append('=');
        sb.append(((this.orderId == null)?"<null>":this.orderId));
        sb.append(',');
        sb.append("product");
        sb.append('=');
        sb.append(((this.product == null)?"<null>":this.product));
        sb.append(',');
        sb.append("price");
        sb.append('=');
        sb.append(((this.price == null)?"<null>":this.price));
        sb.append(',');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null)?"<null>":this.date));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.date == null)? 0 :this.date.hashCode()));
        result = ((result* 31)+((this.product == null)? 0 :this.product.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.orderId == null)? 0 :this.orderId.hashCode()));
        result = ((result* 31)+((this.price == null)? 0 :this.price.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Order) == false) {
            return false;
        }
        Order rhs = ((Order) other);
        return ((((((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date)))&&((this.product == rhs.product)||((this.product!= null)&&this.product.equals(rhs.product))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.orderId == rhs.orderId)||((this.orderId!= null)&&this.orderId.equals(rhs.orderId))))&&((this.price == rhs.price)||((this.price!= null)&&this.price.equals(rhs.price))));
    }

}
