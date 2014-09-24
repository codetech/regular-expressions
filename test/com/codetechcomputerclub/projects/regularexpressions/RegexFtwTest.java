package com.codetechcomputerclub.projects.regularexpressions;

import org.junit.Assert;
import org.junit.Test;

public class RegexFtwTest {

    @Test
    public void test() {
        Assert.assertFalse(RegexFtw.isEmail(""));
        Assert.assertFalse(RegexFtw.isEmail("abc"));
        Assert.assertFalse(RegexFtw.isEmail("abc@"));
        Assert.assertFalse(RegexFtw.isEmail("@abc"));
        Assert.assertFalse(RegexFtw.isEmail("@"));
        Assert.assertFalse(RegexFtw.isEmail("abc@abc"));
        Assert.assertFalse(RegexFtw.isEmail("abc@abc."));
        Assert.assertFalse(RegexFtw.isEmail("abc@abc.com."));
        Assert.assertFalse(RegexFtw.isEmail("abc@.abc"));
        Assert.assertFalse(RegexFtw.isEmail("abc@.abc."));
        Assert.assertFalse(RegexFtw.isEmail("@abc."));
        Assert.assertFalse(RegexFtw.isEmail("@abc.com"));
        Assert.assertFalse(RegexFtw.isEmail("@."));
        Assert.assertFalse(RegexFtw.isEmail("@.."));

        Assert.assertTrue(RegexFtw.isEmail("abc@abc.com"));
        Assert.assertTrue(RegexFtw.isEmail("abc@abc.com.au")); // Holy grail.
    }

}
