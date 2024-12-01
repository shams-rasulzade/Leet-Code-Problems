package LeetCode.Strings.LongestCommonPrefix;

/**
* 0ms 100%
*<a href="https://leetcode.com/problems/longest-common-prefix/description/"> Longest Common Prefix
*
**/

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return ""; // to not get error on empty string
        }

        String smallest = strs[0]; //to get a reference for comparing

        for (String str : strs) {
            while (!str.startsWith(smallest)) {
                smallest = smallest.substring(0, smallest.length() - 1);
            }
        }

        return smallest;
    }

    public static void main(String[] args) {
        String[] array = {"flow", "lflowe", "mfit"};
        System.out.println(longestCommonPrefix(array));
    }
}
