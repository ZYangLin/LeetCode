package leetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public static void main(String[] args) {
		System.out.println(romanToInt("III"));;
	}
	
	
	public static int romanToInt(String str) {
		// v3 不使用Map直接將字串倒著看 
		int result = 0;
		char lastChat;
		
		for(int i = str.length()-1; i >= 0; i--) {
			lastChat = str.charAt(i);
			switch(lastChat) {
				case 'I':
					if(i < str.length()-1 && (str.charAt(i+1) == 'V' || str.charAt(i+1) == 'X' )) {
						result -= 1;
					} else {
						result += 1;
					}
					break;
				case 'V':
					result += 5;
					break;
				case 'X':
					if(i < str.length() && (str.charAt(i+1) == 'L' || str.charAt(i+1) == 'C' )) {
						result -= 10;
					} else {
						result += 10;
					}
					break;
				case 'L':
					result += 50;
					break;
				case 'C':
					if(i < str.length() && (str.charAt(i+1) == 'D' || str.charAt(i+1) == 'M' )) {
						result -= 100;
					} else {
						result += 100;
					}
					break;
				case 'D':
					result += 500;
					break;
				case 'M':
					result += 1000;
					break;
			} 
		}
		return result;
		
		/*
		int total = 0;
		// 條件,字串長度限制(1<= str <= 15), 只能有字元I V X L C D M
		if (str.length() >= 1 && str.length() <= 15 && str.matches("^[IVXLCDM]+$")) {
			// 規則 I:1, V:5, X:10, L:50, C:100, D:500, M:1000,
			// 變形 IV:4, IX:9, XL:40, XC:90, CD:400, CM:900
			Map<String, Integer> romanMap = new HashMap<>();
			romanMap.put("I", 1);
			romanMap.put("V", 5);
			romanMap.put("X", 10);
			romanMap.put("L", 50);
			romanMap.put("C", 100);
			romanMap.put("D", 500);
			romanMap.put("M", 1000);

//			int curVal = 0;

			String[] strArray = str.split("");
			for (int i = strArray.length - 1; i >= 0; i--) {
				if (strArray.length == 1 || i == strArray.length - 1) {
					total = romanMap.get(strArray[i]);
					continue;
				}

				// v.1
//				if (strArray[i].equals("C") && strArray[i + 1].matches("^[DM]{1}$")) {
//					curVal = -romanMap.get(strArray[i]);
//				} else if (strArray[i].equals("X") && strArray[i + 1].matches("^[LC]{1}$")) {
//					curVal = -romanMap.get(strArray[i]);
//				} else if (strArray[i].equals("I") && strArray[i + 1].matches("^[VX]{1}$")) {
//					curVal = -romanMap.get(strArray[i]);
//				} else {
//					curVal = romanMap.get(strArray[i]);
//				}
//				total += curVal;

				
				// v.2 不管上面的規則, 直接前面的數字比後面小的時候就是減的
				if(romanMap.get(strArray[i]) < romanMap.get(strArray[i+1]) ) {
					total -= romanMap.get(strArray[i]);
				} else {
					total += romanMap.get(strArray[i]);
				}

			}
		} else {
			System.out.println("Not match");
		}
		return total;
		*/
	}
}
