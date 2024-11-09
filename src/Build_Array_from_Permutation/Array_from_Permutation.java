package Build_Array_from_Permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Array_from_Permutation {

    public static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            ans[i] = nums[nums[i]];
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the lenght of the Array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the values of the Array: ");

        for (int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(buildArray(arr)));;
    }
}
