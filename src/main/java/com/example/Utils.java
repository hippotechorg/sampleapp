package com.example;

import java.io.InputStream;

public class Utils {
    
public static InputStream getResourceStream(String key, ClassLoader loader) {
        if (key.startsWith("/"))
            key = key.substring(1);
        InputStream is = null;
        if (loader != null) {
            is = loader.getResourceAsStream(key);
            if (is != null)
                return is;
        }
        // Try to use Context Class Loader to load the properties file.
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                is = contextClassLoader.getResourceAsStream(key);
            }
        } catch (Throwable e) {
            // empty body
        }

        if (is == null) {
            is = Utils.class.getResourceAsStream("/" + key);
        }
        if (is == null) {
            is = ClassLoader.getSystemResourceAsStream(key);
        }
        return is;
    }}
