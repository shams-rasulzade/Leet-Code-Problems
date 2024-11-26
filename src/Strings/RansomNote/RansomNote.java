package Strings.RansomNote;

import java.util.Scanner;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        StringBuilder note = new StringBuilder();
        note.append(ransomNote);
        StringBuilder mag = new StringBuilder();
        mag.append(magazine);

        for (int i = 0; i < ransomNote.length(); i++) {
            if (note.charAt(i) == mag.charAt(i)) {
                note.setCharAt(i, ' ');
                mag.setCharAt(i, ' ');
                continue;
            } else {
                for (int j = 0; j < mag.length(); j++) {
                    if (note.charAt(i) == mag.charAt(j)) {
                        note.setCharAt(i, ' ');
                        mag.setCharAt(j, ' ');
                    }
                }
            }
        }
        return note.toString().toString().trim().isEmpty();
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