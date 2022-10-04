package leetCode.easy;

public class Sqrt_x {
    public static void main(String[] args) {
        Sqrt_x sqr = new Sqrt_x();
        System.out.println(sqr.mySqrt(8));
    }

    public int mySqrt(int x) {
        int l = 1, r = x;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m == x / m) return m;

            if (m > x / m) r = m - 1;
            else l = m + 1;
        }
        return r;
    }
}
