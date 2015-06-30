package com.egnyte.intent.test;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.webkit.MimeTypeMap;

import com.egnyte.intent.LoginActivity;

import java.util.List;

/**
 * http://rexstjohn.com/unit-testing-with-android-studio/
 */
public class EgnyteIntentTest extends ActivityInstrumentationTestCase2<LoginActivity> {
    static String TAG = "EgnyteIntentTest";

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

    public void testIsViewerAvailable() throws Exception {
        Intent intent = isViewerAvailable(getActivity(), "/sdcard/Download/sample.pdf");
        assertNotNull(intent);

        intent = isViewerAvailable(getActivity(), "file:///android_asset/sample.pdf");
        assertNotNull(intent);
    }

    public void testIsEgnyteSchemaAvailable() throws Exception {
        boolean isEgnyteSchemaAvailable = isIntentAvailable(getActivity(), Intent.ACTION_VIEW, "egnyte:///openFolder/?path=/Shared/Documents/");
        assertEquals(isEgnyteSchemaAvailable, true);
    }

    public void testCanEgnyteReplyToOpenIntentsPickFile() throws Exception {
        Intent intent = new Intent("org.openintents.action.PICK_FILE");
        intent.setDataAndType(Uri.parse("file:///android_asset/sample.pdf"), "application/pdf");

        PackageManager packageManager = getActivity().getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        assertEquals(2, list.size());
    }

    public boolean isIntentAvailable(Context context, String action, String uri) {
        Intent intent = new Intent(action, Uri.parse(uri));

        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

    public static Intent isViewerAvailable(Context context, String uri) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        String fileType = MimeTypeMap.getFileExtensionFromUrl(uri);
        if (fileType == null || "".equals(fileType)) {
            fileType = uri.substring(uri.lastIndexOf(".") + 1);
        }
        String mimeType = mimeTypeMap.getMimeTypeFromExtension(fileType);

        if (uri.indexOf("sdcard") > 5) {
            intent.setDataAndType(Uri.parse(uri), mimeType);
        } else {
            //enables webbrowser to open as before
            intent.setData(Uri.parse(uri));
        }

        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, 0);
        if (list.size() > 0) {
            Log.d(TAG, "Found " + list.size() + " activities which can handle this mime type " + mimeType);
            return intent;
        } else {
            return null;
        }
    }
}
