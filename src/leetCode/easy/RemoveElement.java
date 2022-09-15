package leetCode.easy;

public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        re.removeElement(3);
    }

    public int removeElement(int val) {
        int i = 0;
        int[] nums = {3, 2, 2, 3};

        for (int num : nums) {
            if (num != val) {
                nums[i++] = num;
            }
        }

        return i;
    }
}
