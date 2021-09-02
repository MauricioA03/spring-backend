package com.sales.market.util;

import org.hibernate.cfg.NotYetImplementedException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NumericUtilsTest {

    private static final String ONE_ROMAN = "I";
    private static final String TWO_ROMAN = "I";

    @Test
    public void testToRoman() {
        NumericUtils numericUtils = new NumericUtils();
        String romano = numericUtils.toRoman(1);
        assertEquals(romano, ONE_ROMAN);
    }

    @Test
    public void givenNotCoveredScenarioWhenTestToRomanThenFail() {
        NumericUtils numericUtils = new NumericUtils();
        String romano = numericUtils.toRoman(2);
        assertEquals(romano, TWO_ROMAN);
    }

    @Test(expectedExceptions = NotYetImplementedException.class)
    public void testToArabic() {
        NumericUtils numericUtils = new NumericUtils();
        Integer arabic = numericUtils.toArabic("I");
        assertTrue(arabic == 1);
    }
}
