package leetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public int romanToInt(String str) {
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
	}
}
