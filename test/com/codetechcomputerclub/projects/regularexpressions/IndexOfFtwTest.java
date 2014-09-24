package com.codetechcomputerclub.projects.regularexpressions;

import org.junit.Assert;
import org.junit.Test;

public class IndexOfFtwTest {

    @Test
    public void test() {
        Assert.assertFalse(IndexOfFtw.isEmail(""));
        Assert.assertFalse(IndexOfFtw.isEmail("abc"));
        Assert.assertFalse(IndexOfFtw.isEmail("abc@"));
        Assert.assertFalse(IndexOfFtw.isEmail("@abc"));
        Assert.assertFalse(IndexOfFtw.isEmail("@"));
        Assert.assertFalse(IndexOfFtw.isEmail("abc@abc"));
        Assert.assertFalse(IndexOfFtw.isEmail("abc@abc."));
        Assert.assertFalse(IndexOfFtw.isEmail("abc@abc.com."));
        Assert.assertFalse(IndexOfFtw.isEmail("abc@.abc")); // Harder.
        Assert.assertFalse(IndexOfFtw.isEmail("abc@.abc."));
        Assert.assertFalse(IndexOfFtw.isEmail("@abc."));
        Assert.assertFalse(IndexOfFtw.isEmail("@abc.com"));
        Assert.assertFalse(IndexOfFtw.isEmail("@."));
        Assert.assertFalse(IndexOfFtw.isEmail("@.."));

        Assert.assertTrue(IndexOfFtw.isEmail("abc@abc.com"));
        Assert.assertTrue(IndexOfFtw.isEmail("abc@abc.com.au")); // Holy grail.
    }

}
