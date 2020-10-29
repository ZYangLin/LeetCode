package leetCode.easy;

public class ValidParentheses {
	public static void main(String[] args) {
		isValid("a(j");
	}

	public static boolean isValid(String s) {
		// constraints: 1<= s.length() <= 10e4
		if(s.length() <1 || s.length() > Math.pow(10, 4) || s.matches("[\\d\\w]+"));
			return false;
	}
}
