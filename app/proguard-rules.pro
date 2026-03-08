# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/prabeshshah/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools-proguard.html

# Add any project specific keep rules here:

# Keep Retrofit classes
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

# Keep Gson classes
-keep class com.google.gson.** { *; }
-keep class com.cafeagents.data.model.** { *; }
