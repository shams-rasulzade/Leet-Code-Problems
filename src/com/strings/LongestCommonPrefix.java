package com.strings;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return ""; // to not get error on empty string
        }

        String smallest = strs[0]; //to get a reference for comparing

        System.out.println(smallest);
        for (String str : strs) {
            while (!str.startsWith(smallest)) {
                smallest = smallest.substring(0, smallest.length() - 1);
                System.out.println(smallest + " while");
                if (smallest.isEmpty()) { // to not to get error when the substring becomes empty
                    return "";
                }
            }
        }

        return smallest;
    }

    public static void main(String[] args) {
        String[] array = {"flow", "flowe", "fit"};
        System.out.println(longestCommonPrefix(array));
    }
}
