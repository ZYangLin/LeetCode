package leetCode.easy;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		// v2
		// x 為負數或者 x不為0個位數卻為0時 都不可能是palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		int rev = 0;
        // 當x不在大於 rev時 代表reverse的狀況已經到一半
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x /= 10;
		}
        // 狀況一 input:1221 x:12 rev:12, 狀況二 input:12321 x:12 rev:123 所以 rev要除以10
		return x == rev || x == rev / 10;
/* ------------------------------------------------------------------------------------*/		
		// v1
		/*
		int rev = 0;
		int orig = x;
		if (x < 0)
			return false;
		else {
			while(x>0) {
				int lastNum = x % 10;
				x /= 10;

				if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE && lastNum > 7))
					return false;

				rev = rev * 10 + lastNum;
			}
		}
		if(rev == orig || orig == 0)
			return true;
		else
			return false;
		*/
	}
}
