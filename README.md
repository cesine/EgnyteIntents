# EgnyteIntents
Intents library for Egnyte integration


Egnyte has a ReadOnlyFileProvider Content Provider which is available by other applications.

```
Name: "com.egnyte.mobile.versions.preview.ReadOnlyFileProvider"
Authority: "com.egnyte.mobile.ReadOnlyFileProvider"
```

Egnyte has a few services which can be invoked by specifying their exact class name. These are mostly for sync, encryption and security.

```xml
<service android:name="com.egnyte.mobile.offlinesync.OfflineSyncService" />
<service android:name="com.egnyte.mobile.sync.SyncService" />
```

Egnyte replies to nearly all basic Android intent actions involving files, usually the result will be to upload them into your Egnyte.

```xml
<action android:name="android.intent.action.GET_CONTENT" />
<action android:name="android.intent.action.MAIN" />
<action android:name="android.intent.action.PICK" />
<action android:name="android.intent.action.SEARCH" />
<action android:name="android.intent.action.SEND" />
<action android:name="android.intent.action.SEND_MULTIPLE" />
<action android:name="android.intent.action.VIEW" />
<action android:name="org.openintents.action.PICK_FILE" />
```

Egnyte can also reply to any File Picker intent

```xml
FilePickerProxy
    <action android:name="android.intent.action.PICK" />
    <action android:name="org.openintents.action.PICK_FILE" />
    <category android:name="android.intent.category.DEFAULT" />
    <category android:name="android.intent.category.BROWSABLE" />
    <data android:scheme="file" />
    <data android:scheme="folder" />
    <data android:scheme="directory" />

    <action android:name="android.intent.action.GET_CONTENT" />
    <category android:name="android.intent.category.DEFAULT" />
    <category android:name="android.intent.category.OPENABLE" />
    <data android:mimeType="*/*" />
```
    
Egnyte can upload nearly any file type via any `android.intent.action.VIEW` file intent

```xml
UploadViewController
    <action android:name="android.intent.action.VIEW" />
    <data android:scheme="content" />
    <data android:scheme="file" />
    <data android:mimeType="image/*" />
    <data android:mimeType="video/*" />
    <data android:mimeType="audio/*" />
    <data android:mimeType="text/*" />
    <data android:mimeType="application/vnd.sun.xml.draw" />
    <data android:mimeType="application/vnd.ms-excel.sheet.macroenabled.12" />
    <data android:mimeType="application/javascript" />
    <data android:mimeType="application/vnd.oasis.opendocument.presentation" />
    <data android:mimeType="application/vnd.sun.xml.writer" />
    <data android:mimeType="application/x-stuffit" />
    <data android:mimeType="application/vnd.stardivision.draw" />
    <data android:mimeType="application/vnd.google-apps.drawing" />
    <data android:mimeType="application/vnd.oasis.opendocument.text " />
    <data android:mimeType="application/vnd.ms-powerpoint.addin.macroenabled.12" />
    <data android:mimeType="application/x-tar" />
    <data android:mimeType="application/vnd.openxmlformats-officedocument.presentationml.presentation" />
    <data android:mimeType="application/dwf" />
    <data android:mimeType="application/vnd.oasis.opendocument.image" />
    <data android:mimeType="application/x-xz" />
    <data android:mimeType="application/vnd.stardivision.writer" />
    <data android:mimeType="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" />
    <data android:mimeType="application/x-gtar" />
    <data android:mimeType="application/sldworks" />
    <data android:mimeType="application/vnd.oasis.opendocument.text-template" />
    <data android:mimeType="application/vnd.openxmlformats-officedocument.presentationml.template" />
    <data android:mimeType="application/vnd.ms-powerpoint.template.macroenabled.12" />
    <data android:mimeType="application/msword" />
    <data android:mimeType="application/vnd.ms-excel.sheet.binary.macroenabled.12" />
    <data android:mimeType="application/postscript" />
    <data android:mimeType="application/vnd.openxmlformats-officedocument.spreadsheetml.template" />
    <data android:mimeType="application/vnd.ms-word.template.macroenabled.12" />
    <data android:mimeType="application/octet-stream" />
    <data android:mimeType="application/vnd.openxmlformats-officedocument.presentationml.slideshow" />
    <data android:mimeType="application/vnd.ms-excel.template.macroenabled.12" />
    <data android:mimeType="application/rtf" />
    <data android:mimeType="application/pdf" />
    <data android:mimeType="application/vnd.stardivision.writer-global" />
    <data android:mimeType="application/vnd.ms-excel" />
    <data android:mimeType="application/vnd.sun.xml.calc" />
    <data android:mimeType="application/zip" />
    <data android:mimeType="application/vnd.oasis.opendocument.presentation-template" />
    <data android:mimeType="application/x-7z-compressed" />
    <data android:mimeType="application/vnd.stardivision.impress" />
    <data android:mimeType="application/x-photoshop" />
    <data android:mimeType="application/vnd.sun.xml.writer.global" />
    <data android:mimeType="application/vnd.ms-excel.addin.macroenabled.12" />
    <data android:mimeType="application/vnd.openxmlformats-officedocument.wordprocessingml.template" />
    <data android:mimeType="application/vnd.google-apps.presentation" />
    <data android:mimeType="application/vnd.ms-powerpoint" />
    <data android:mimeType="application/vnd.oasis.opendocument.text-web" />
    <data android:mimeType="application/vnd.oasis.opendocument.graphics" />
    <data android:mimeType="application/vnd.stardivision.calc" />
    <data android:mimeType="application/vnd.oasis.opendocument.spreadsheet-template" />
    <data android:mimeType="application/vnd.sun.xml.draw.template" />
    <data android:mimeType="application/vnd.sun.xml.calc.template" />
    <data android:mimeType="application/vnd.oasis.opendocument.graphics-template" />
    <data android:mimeType="application/x-compress" />
    <data android:mimeType="application/x-ace-compressed" />
    <data android:mimeType="application/x-bzip2" />
    <data android:mimeType="application/vnd.ms-works" />
    <data android:mimeType="application/vnd.sun.xml.writer.template" />
    <data android:mimeType="application/vnd.oasis.opendocument.spreadsheet" />
    <data android:mimeType="application/vnd.ms-outlook" />
    <data android:mimeType="application/vnd.sun.xml.impress.template" />
    <data android:mimeType="application/vnd.lotus-1-2-3" />
    <data android:mimeType="application/x-gzip" />
    <data android:mimeType="application/vnd.openxmlformats-officedocument.wordprocessingml.document" />
    <data android:mimeType="application/illustrator" />
    <data android:mimeType="application/vnd.google-apps.spreadsheet" />
    <data android:mimeType="application/vnd.ms-powerpoint.slideshow.macroenabled.12" />
    <data android:mimeType="application/vnd.ms-powerpoint.presentation.macroenabled.12" />
    <data android:mimeType="application/vnd.android.package-archive" />
    <data android:mimeType="application/vnd.ms-project" />
    <data android:mimeType="application/vnd.visio" />
    <data android:mimeType="application/vnd.google-apps.document" />
    <data android:mimeType="application/vnd.ms-word.document.macroenabled.12" />
    <data android:mimeType="application/vnd.stardivision.impress-packed" />
    <data android:mimeType="application/dwg" />
    <data android:mimeType="application/x-rar-compressed" />
    <data android:mimeType="application/vnd.sun.xml.impress" />
    <data android:mimeType="application/vnd.oasis.opendocument.text-master" />

    <action android:name="android.intent.action.SEND_MULTIPLE" />
    <category android:name="android.intent.category.DEFAULT" />
    <data android:mimeType="image/*" />
    <data android:mimeType="video/*" />
    <data android:mimeType="audio/*" />
    <data android:mimeType="text/*" />
    <data android:mimeType="application/*" />

    <action android:name="android.intent.action.SEND" />
    <category android:name="android.intent.category.DEFAULT" />
    <data android:mimeType="image/*" />
    <data android:mimeType="video/*" />
    <data android:mimeType="audio/*" />
    <data android:mimeType="text/*" />
    <data android:mimeType="application/*" />
```

Egnyte can open any web url where the host is egnyte.com


```xml
MainViewController
    <action android:name="android.intent.action.VIEW" />
    <data
        android:host="*.egnyte.com"
        android:pathPrefix="openFolder"
        android:scheme="egnyte" />

    <action android:name="android.intent.action.VIEW" />
    <data android:scheme="egnyte" />
```

Egnyte makes it so you can search in your Egnyte files the [search widget](http://developer.android.com/guide/topics/search/search-dialog.html#TheBasics). 


```xml
MasterViewController
    <action android:name="android.intent.action.SEARCH" />
    <meta-data
        android:name="android.app.searchable"
        android:resource="@xml/searchable" />

FileActionsViewController
    <meta-data
        android:name="android.app.default_searchable"
        android:includeInGlobalSearch="true"
        android:searchSettingsDescription="Egnyte Cloud Solution"
        android:value=".MasterViewController"
        android:voiceSearchMode="showVoiceSearchButton" />
```
