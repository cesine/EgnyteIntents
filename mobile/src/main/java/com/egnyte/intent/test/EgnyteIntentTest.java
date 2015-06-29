package com.egnyte.intent.test;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.test.ActivityInstrumentationTestCase2;

import com.egnyte.intent.LoginActivity;

import java.util.List;

/**
 * http://rexstjohn.com/unit-testing-with-android-studio/
 */
public class EgnyteIntentTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    public EgnyteIntentTest() {
        super(LoginActivity.class);
    }

    public void test() throws Exception {
        final int expected = 1;
        final int reality = 4;
        assertEquals(expected, reality);
    }

    public void testIsIntentAvailable() throws Exception {
        boolean intentWhichShouldNotWork = isIntentAvailable(getActivity(), Intent.ACTION_VIEW, "notanexistingschema:///do/something/with/this/");
        assertEquals(intentWhichShouldNotWork, false);
    }

    public void testIsEgnyteSchemaAvailable() throws Exception {
        boolean isEgnyteSchemaAvailable = isIntentAvailable(getActivity(), Intent.ACTION_VIEW, "egnyte:///openFolder/?path=/Shared/Documents/");
        assertEquals(isEgnyteSchemaAvailable, true);
    }

    public boolean isIntentAvailable(Context context, String action, String uri) {
        Intent intent = new Intent(action, Uri.parse(uri));

        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }
}
