package com.egnyte.intent.test;

import android.test.InstrumentationTestCase;

/**
 * http://rexstjohn.com/unit-testing-with-android-studio/
 */
public class EgnyteIntentTest extends InstrumentationTestCase {

    public void test() throws Exception {
        final int expected = 1;
        final int reality = 4;
        assertEquals(expected, reality);
    }

}
