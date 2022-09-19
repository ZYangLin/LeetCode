package leetCode.easy;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (nums[m] == target) return m;
            else if (nums[m] > target) r = m;
            else l = m + 1;
        }
        return nums[l] < target ? l + 1 : l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        searchInsert(nums, 5);
    }
}
