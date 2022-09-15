package leetCode.easy;

import java.util.Arrays;
import java.util.List;


public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums)
            if (i == 0 || num > nums[i-1])
                nums[i++] = num;
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }
}
