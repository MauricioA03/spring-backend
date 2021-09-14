package com.sales.market.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class SubCategory extends ModelBase {
    private String name;
    private String code;
    @ManyToOne
    private Category category;

    private Long cateId;  /// DTO

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
