package com.sales.market.model;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity
public class Item extends ModelBase {
    private String name;
    private String code;
    private String brand;
    private String description;
    @Lob
    private Byte[] image;
    @OneToOne(targetEntity = SubCategory.class)//redundante el targetEntity
    private SubCategory subCategory;

    @OneToMany
    private Set<FeatureInstance> featureInstanceSet;

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

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}
