package com.github.siroshun09.sirolibrary.text;

import org.jetbrains.annotations.NotNull;

public class NumberChecker {
    public final static char[] MAX_INT = String.valueOf(Integer.MAX_VALUE).toCharArray();
    public final static char[] MIN_INT = String.valueOf(Integer.MIN_VALUE).toCharArray();
    public final static char[] MAX_LONG = String.valueOf(Long.MAX_VALUE).toCharArray();
    public final static char[] MIN_LONG = String.valueOf(Long.MIN_VALUE).toCharArray();

    public static boolean isInteger(@NotNull String str) {
        int length = str.length();

        if (str.length() < 1) {
            return false;
        }

        if (str.charAt(0) == '-') {
            if (11 < length) {
                return false;
            }
            boolean isMinCheck = length == 11;
            for (int i = 1; i < length; i++) {
                char c = str.charAt(i);
                if (c < '0' || '9' < c) {
                    return false;
                }

                if (isMinCheck && MIN_INT[i] < c) {
                    return false;
                } else if (c < MIN_INT[i]) {
                    isMinCheck = false;
                }
            }
        } else {
            if (10 < length) {
                return false;
            }
            boolean isMaxCheck = length == 10;
            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                if (c < '0' || '9' < c) {
                    return false;
                }

                if (isMaxCheck && MAX_INT[i] < c) {
                    return false;
                } else if (c < MAX_INT[i]) {
                    isMaxCheck = false;
                }
            }
        }
        return true;
    }

    public static boolean isLong(@NotNull String str) {
        int length = str.length();

        if (str.length() < 1) {
            return false;
        }

        if (str.charAt(0) == '-') {
            if (20 < length) {
                return false;
            }
            boolean isMinCheck = length == 20;
            for (int i = 1; i < length; i++) {
                char c = str.charAt(i);
                if (c < '0' || '9' < c) {
                    return false;
                }

                if (isMinCheck && MIN_LONG[i] < c) {
                    return false;
                } else if (c < MIN_LONG[i]) {
                    isMinCheck = false;
                }
            }
        } else {
            if (19 < length) {
                return false;
            }
            boolean isMaxCheck = length == 19;
            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                if (c < '0' || '9' < c) {
                    return false;
                }

                if (isMaxCheck && MAX_LONG[i] < c) {
                    return false;
                } else if (c < MAX_LONG[i]) {
                    isMaxCheck = false;
                }
            }
        }
        return true;
    }
}