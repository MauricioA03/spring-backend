package com.sales.market.dto;

import com.sales.market.exception.CheckedException;
import com.sales.market.exception.UncheckedException;
import com.sales.market.model.Category;

public class CategoryDto extends DtoBase<Category> {
    private boolean sanitizado;
    private String code;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDto() {
        this.sanitizado = false;
    }

    //IntelJ crea las getter de tipo boolean con isName
    public boolean isSanitizado() {
        return sanitizado;
    }

    public void setSanitizado(boolean sanitizado) {
        this.sanitizado = sanitizado;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean validate() throws CheckedException {
        if (this.code.length() < 5) throw new CheckedException();
        return true;
    }

    public boolean validateUnchecked() throws UncheckedException {
        if (this.code.length() < 5) throw new UncheckedException();
        return true;
    }
}
