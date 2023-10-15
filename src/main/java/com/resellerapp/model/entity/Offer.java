package com.resellerapp.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{

    @NotNull
    @Length(min = 2, max = 50)
    private String description;

    @NotNull
    @Min(value = 0)
    private BigDecimal price;

    @NotNull
    @ManyToOne
    private Condition condition;

    @ManyToOne
    @NotNull
    private User createBy;

    @ManyToOne
    private User boughtBy;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}