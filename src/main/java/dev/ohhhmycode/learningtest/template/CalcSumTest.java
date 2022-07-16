package dev.ohhhmycode.learningtest.template;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalcSumTest {

    private Calculator calculator;
    private String filePath;

    @Before
    public void setUp() {
        calculator = new Calculator();
        filePath = getClass().getResource("/numbers.txt").getPath();
    }

    @Test
    public void sumOfNumbers() throws IOException {
        int sum = calculator.calcCum(filePath);
        assertThat(sum, is(10));
    }

    @Test
    public void multiplyOfNumbers() throws IOException {
        assertThat(calculator.calcMultiply(this.filePath), is(24));
    }

    @Test
    public void concatenate() throws IOException {
        assertThat(calculator.concatenate(filePath), is("1234"));
    }

}
