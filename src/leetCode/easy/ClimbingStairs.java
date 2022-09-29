package leetCode.easy;

public class ClimbingStairs {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int result = 0;
        int a = 1, b = 2;
        for (int i = 2; i < n; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }
}
