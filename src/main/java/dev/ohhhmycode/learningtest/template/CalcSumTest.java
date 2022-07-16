package dev.ohhhmycode.learningtest.template;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalcSumTest {

    @Test
    public void sumOfNumbers() throws IOException {
        Calculator calculator = new Calculator();
        String filePath = getClass().getResource("/numbers.txt").getPath();
        int sum = calculator.calcCum(filePath);
        assertThat(sum, is(10));
    }

}
