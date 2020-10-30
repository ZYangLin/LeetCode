package leetCode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		isValid("(){}}{");
	}

	public static boolean isValid(String s) {

		// constraints: 1<= s.length() <= 10e4
		// constraints: s consists of parentheses only '()[]{}'
		// 根據限制來做一開始的條件判斷其實會拖慢速度 很多leetcode最佳解根本都沒做判斷 XD
		if (s.length() < 1 || s.length() > Math.pow(10, 4) || s.matches(".*[\\d\\w].*"))
			return false;
		
		/* 第一版: 使用 StringBuilder 
		Map<String, String> bracketsMap = new HashMap<>();
		bracketsMap.put("]", "[");
		bracketsMap.put(")", "(");
		bracketsMap.put("}", "{");

		String[] sArray = s.split("");

		StringBuilder strBde = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			// 當遇到 closed brackets
			if (bracketsMap.containsKey(sArray[i])) {
			
				// StringBuilder 最後一個字元和 sArray[i]為一組括號
				if (strBde.length() > 0 && (bracketsMap.get(sArray[i]).charAt(0) == (strBde.charAt(strBde.length() - 1)))) {
				
					// stringBuilder最後字元的索引值不要使用i(像是 stringBuilder.charAt(i))來取, 因為i值會一值遞增
					// 但我們 stringBuilder的值卻會有增有減 這樣i一值增加的狀況下會產生 indexOutOfBoundsException
					strBde.deleteCharAt(strBde.length() - 1);
				} else
					return false; // StringBuilder 最後一個字元和 sArray[i] 無法湊成一組括號 return false
			} else
				strBde.append(sArray[i]);
		}
		return strBde.length() > 0 ? false : true;
		*/

		Map<Character, Character> bracketsMap = new HashMap<>();
		bracketsMap.put(']', '[');
		bracketsMap.put(')', '(');
		bracketsMap.put('}', '{');

		Stack<Character> bracketsStack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			// ↓會重複使用到的東西 拉出來當成變數, 也會提高一點速度
			char c = s.charAt(i);
			if (bracketsMap.containsKey(c) && !bracketsStack.isEmpty()) {
				Character refStr = bracketsStack.pop();
				if (bracketsMap.get(c) != refStr) {
					return false;
				}
			} else
				bracketsStack.push(c);
		}
		return bracketsStack.isEmpty();

	}
}
