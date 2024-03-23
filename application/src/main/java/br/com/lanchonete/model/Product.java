package br.com.lanchonete.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Product {

    private UUID id;
    private Date createdAt;
    private Date updatedAt;
    private String name;
    private String description;
    private String image;
    private BigDecimal unitPrice;
    private Category category;
    private StatusActiveType status = StatusActiveType.ACTIVE;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public StatusActiveType getStatus() {
        return status;
    }

    public void setStatus(StatusActiveType status) {
        this.status = status;
    }

}
