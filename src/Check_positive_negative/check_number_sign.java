package Check_positive_negative;
import java.sql.SQLOutput;
import java.util.Scanner;

public class check_number_sign {
    public static void check_number (double number){
        if (number > 0 ) System.out.println("The number is positive!");
        else if ( number < 0) System.out.println("The number is negative!");
        else System.out.println("The number is 0! It's not positive nor negative!");
    }

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number for checking: ");
        double num = scanner.nextDouble();
        check_number(num);
    }

}
