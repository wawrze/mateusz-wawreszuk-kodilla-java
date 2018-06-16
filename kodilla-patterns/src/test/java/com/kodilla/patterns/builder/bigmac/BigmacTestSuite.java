package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testBigMacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .isBunWithSesame(true)
                .burgers(2)
                .sauce("standard")
                .ingredient("salad")
                .ingredient("bacon")
                .ingredient("chili peppers")
                .ingredient("shrimps")
                .build();
        //When
        String result = "" + bigmac;
        //Then
        Assert.assertEquals("Bigmac: bun with sesame, 2 burgers, standard sauce " +
                "and additional ingredients: salad, bacon, chili peppers, shrimps.", result);
    }

}