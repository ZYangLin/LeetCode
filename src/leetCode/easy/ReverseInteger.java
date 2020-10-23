package leetCode.easy;

public class ReverseInteger {
	public static int reverse(int x) {
//		 input:0, output:0
//		 input value 必須介於 Integer.MIN_VALUE and Integer.MAX_VALUE, 超過該範圍 return: 0

		// System.out.println(Integer.MAX_VALUE); // 2147483647
		// System.out.println(Integer.MIN_VALUE); // -2147483648

		int rev = 0;
		while (x != 0) {
			int pick = x % 10; // 取出最後一位數
			x /= 10;

			// 正數部分溢位判斷
			if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pick > 7) {
				return 0;
			}
			// 負數部分溢位判斷
			if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && pick < -8) {
				return 0;
			}

			rev = rev * 10 + pick;
		}
		return rev;
	}
}
