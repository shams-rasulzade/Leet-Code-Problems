package TwoSneakyNumbers;


import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static int[] getSneakyNumbers(int[] nums) {
        int[] newArray = new int[2];
        int n = 0;
        for (int i = 0; i < nums.length && n < 2; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count += 1;
                }
            }
            if (count >= 2) {
                boolean alreadyAdded = false;
                for (int k = 0; k < n; k++) {
                    if (newArray[k] == nums[i]) {
                        alreadyAdded = true;
                        break;
                    }
                }
                if (!alreadyAdded) {
                    newArray[n] = nums[i];
                    n += 1;
                }
            }
        }
        return newArray;
    }

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[6];
        System.out.println("Enter values: ");
        for (int i = 0; i < arr.length; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(getSneakyNumbers(arr)));
    }
}