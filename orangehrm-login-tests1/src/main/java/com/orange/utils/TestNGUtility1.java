package com.orange.utils;

import org.testng.Assert;

public class TestNGUtility1 {

    //  Checks if actual contains expected — used for page headers, welcome text, etc.
    public static void assertTrue(String expected, String actual) {
        if (actual != null && actual.contains(expected)) {
            Assert.assertTrue(true);
        } else {
            System.out.println("Expected text \"" + expected + "\" not found in actual text \"" + actual + "\"");
            Assert.fail(expected + " not present in actual value: " + actual);
        }
    }

    //  Used to compare expected and actual integer values
    public static void assertEquals(int expected, int actual) {
        if (expected == actual) {
            Assert.assertEquals(actual, expected);
        } else {
            System.out.println(expected + " is not matched with " + actual);
            Assert.fail("Expected: " + expected + ", but got: " + actual);
        }
    }

    //  Generic fail with message
    public static void assertFail(String logMessage) {
        System.out.println("Test Failed: " + logMessage);
        Assert.fail(logMessage);
    }
}
