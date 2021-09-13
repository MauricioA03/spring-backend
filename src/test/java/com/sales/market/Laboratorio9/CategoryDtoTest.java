package com.sales.market.Laboratorio9;

import com.sales.market.dto.CategoryDto;
import com.sales.market.exception.CheckedException;
import com.sales.market.exception.UncheckedException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CategoryDtoTest {

    @Test
    public void givenCategoryDTOWithCodeLengthLessThanMinimunSizeWhenCategoryDTO_validateThenCheckedErrorShouldBeCatchAndYouShouldRecoverWithTrailingXCharacters() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCode("ABC");
        try {
            categoryDto.validate();
        } catch (CheckedException e) {
            categoryDto.setCode("XXXABC");
            try {
                categoryDto.validate();
                categoryDto.setSanitizado(true);
            } catch (CheckedException checkedException) {
                checkedException.printStackTrace();
            }
        }
        assertTrue(categoryDto.isSanitizado());
        assertEquals(categoryDto.getCode(), "XXXABC");
    }

    @Test(expectedExceptions = UncheckedException.class)
    public void givenCategoryDTOWithCodeLengthLessThanMinimunSizeWhenCategoryDTO_validateUncheckedThenUncheckedErrorShouldBeThrown() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCode("ABC");
        categoryDto.validateUnchecked();
    }
}
