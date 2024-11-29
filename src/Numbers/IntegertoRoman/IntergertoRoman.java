package Numbers.IntegertoRoman;

import java.util.Scanner;

public class IntergertoRoman {

    public static String intToRoman(int num) {
        int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M","CM","D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int i = 0;

        String string = new String();
        while(num>0){
            if(num>=n[i]){
                string = string + roman[i];
                num -=n[i];
            }else{
                i++;
            }
        }
        return string;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to convert: ");
        int number = sc.nextInt();
        System.out.println(intToRoman(number));
    }
}
