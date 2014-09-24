package com.codetechcomputerclub.projects.regularexpressions;

import org.junit.Assert;
import org.junit.Test;

public class IndexOfFtwTest {

    @Test
    public void basic() {
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

    @Test
    public void characters() {
        Assert.assertFalse(IndexOfFtw.isEmail("~@abc.com")); // Immediate
                                                             // failing point.
        Assert.assertFalse(IndexOfFtw.isEmail("abc@~"));

        Assert.assertFalse(IndexOfFtw.isEmail("abc@abc+def.com"));

        Assert.assertTrue(IndexOfFtw.isEmail("abc+def@abc.com"));
        Assert.assertTrue(IndexOfFtw.isEmail("abc@abc-def.com"));
    }
}
