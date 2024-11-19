package NumberGuess;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static long generateRandomDigits(int n) { // creates random number
        long min = (long) Math.pow(10, n - 1); // minimum number for n digits
        long max = (long) Math.pow(10, n) - 1; // maximum number for n digits
        return new Random().nextLong(max - min + 1) + min; // Random number between min and max
    }


    public static void finddigits(long randomNumber, long userNumber, int length){
        int x=0,y=0; // counts for digits
        StringBuilder random = new StringBuilder();
        StringBuilder usernum = new StringBuilder();
        random.append(randomNumber);
        usernum.append(userNumber);

        for (int i = 0; i < length; i++){
            if(usernum.charAt(i) == random.charAt(i)){
                x++;
                random.setCharAt(i, ' ');
                continue;
            }

            else {
                for (int j = 0; j < length; j++){
                    if(usernum.charAt(i) == random.charAt(j)){
                        y++;
                        random.setCharAt(j, ' ');
                        break;
                    }
                }
            }
        }

        System.out.println(x + " green, " + y + " yellow");
    }

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of the value: ");
        int length = scanner.nextInt();

        long randomNumber = generateRandomDigits(length);
        System.out.println(randomNumber);

        System.out.print("Random number is generated. Enter value to guess: ");
        long userNumber = scanner.nextLong();

        finddigits(randomNumber, userNumber, length);
    }
}

// todo
// exceptions:
// 1. user entered more than defined length
// 2. user entered number starts with 0 - it trims that 0 and throws an exception