package LeetCode.Strings.RansomNote;

import java.util.Scanner;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] charCount = new int[26];

        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                return false;
            }
            charCount[c - 'a']--;
        }

        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ransom note: ");
        String ransomNote = sc.nextLine();
        System.out.print("Enter magazine: ");
        String magazine = sc.nextLine();

        if (canConstruct(ransomNote, magazine)) System.out.println("Note can be constructed from magazine!");
        else System.out.println("Note can't be constructed from magazine!");
    }
}