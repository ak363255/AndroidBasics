#include <jni.h>

JNIEXPORT jstring

JNICALL
java_com_example_androidinterview_MainActivity_getFacebookApiKey(JNIEnv *env, jobject instance) {
    return (*env)->NewStringUTF(env, "TmF0aXZlNWVjcmV0UEBzc3cwcmQx");
}

JNIEXPORT jstring

JNICALL
java_com_example_androidinterview_MainActivity_getBaseApi(JNIEnv *env, jobject instance) {
    return (*env)->NewStringUTF(env, "TmF0aXZlNWVjcmV0UEBzc3cwcmQy");
}