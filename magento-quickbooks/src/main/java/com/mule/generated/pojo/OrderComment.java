
package com.mule.generated.pojo;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class OrderComment {

    @SerializedName("is_customer_notified")
    @Expose
    private String isCustomerNotified;
    @SerializedName("is_visible_on_front")
    @Expose
    private String isVisibleOnFront;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    /**
     * 
     * @return
     *     The isCustomerNotified
     */
    public String getIsCustomerNotified() {
        return isCustomerNotified;
    }

    /**
     * 
     * @param isCustomerNotified
     *     The is_customer_notified
     */
    public void setIsCustomerNotified(String isCustomerNotified) {
        this.isCustomerNotified = isCustomerNotified;
    }

    public OrderComment withIsCustomerNotified(String isCustomerNotified) {
        this.isCustomerNotified = isCustomerNotified;
        return this;
    }

    /**
     * 
     * @return
     *     The isVisibleOnFront
     */
    public String getIsVisibleOnFront() {
        return isVisibleOnFront;
    }

    /**
     * 
     * @param isVisibleOnFront
     *     The is_visible_on_front
     */
    public void setIsVisibleOnFront(String isVisibleOnFront) {
        this.isVisibleOnFront = isVisibleOnFront;
    }

    public OrderComment withIsVisibleOnFront(String isVisibleOnFront) {
        this.isVisibleOnFront = isVisibleOnFront;
        return this;
    }

    /**
     * 
     * @return
     *     The comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * 
     * @param comment
     *     The comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    public OrderComment withComment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public OrderComment withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * 
     * @return
     *     The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public OrderComment withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
