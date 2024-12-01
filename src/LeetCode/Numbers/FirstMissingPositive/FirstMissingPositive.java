package LeetCode.Numbers.FirstMissingPositive;

import java.util.Arrays;
import java.util.Scanner;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int min = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min) min++;
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(nums));
    }
}
