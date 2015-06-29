package api.intent.android.egnyte.com.egnyteintents.test;

import android.test.InstrumentationTestCase;

/**
 * http://rexstjohn.com/unit-testing-with-android-studio/
 */
public class EgnyteIntentTest extends InstrumentationTestCase {

    public void test() throws Exception {
        final int expected = 1;
        final int reality = 5;
        assertEquals(expected, reality);
    }

}
