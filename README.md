TOC
---
* [EASY](#EASY)
	* [Two Sum](#TwoSum)
	* [Reverse Integer](#ReverseInteger)
	* [Palindrome Number](#PalindromeNumber)
	* [Roman to Integer](#RomanToInteger)
* 
---


# LeetCode

## EASY

### TwoSum
> 輸入一串可重複的整數,其中某兩個整數和必等於目標值  
> + example1: input: nums[2,7,11,15] target=9 output: [0,1] 因為 nums[0]+nums[1]=9  
> + example2: input: nums[3,3] target=6 output: [0,1]  
> + example3: input: nums[3,2,4] target=6 output:[1,2]  


```java=
public int[] twoSum(int[] nums, int terget) {
    Map<Integer, Integer> intMap = new HashMap<>();
    int r;
    for (int i = 0; i < nums.length; i++) {
        r = terget - nums[i];
        if (intMap.containsKey(r)) {
            return new int[] {intMap.get(r) ,i};
        } else {

            // key:陣列數值, value:陣列索引
            intMap.put(nums[i], i);
        }
    }
    throw new IllegalArgumentException("Can not find answer in the Array.");
}
```

### ReverseInteger
> 倒轉一個範圍從 -2e31 ~ 2e31-1 整數  
> + example1: input:123, output:321  
> + example2: input:-123, output: -321  
> + example3: input: 120, output: 21  
> + example4: input: 0, output:  

```java=
public static int reverse(int x) {
	// input:0, return:0
	// input value 必須介於 Integer.MIN_VALUE and Integer.MAX_VALUE, 
	// 超過該範圍 return: 0

	// System.out.println(Integer.MAX_VALUE); // 2147483647
	// System.out.println(Integer.MIN_VALUE); // -2147483648

	int rev = 0;
	while (x != 0) {
		int lastNum = x % 10; // 取出最後一位數
		x /= 10;

		// 正數部分溢位判斷
		if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && lastNum > 7) {
			return 0;
		}
		// 負數部分溢位判斷
		if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && lastNum < -8) {
			return 0;
		}

		rev = rev * 10 + lastNum;
	}
	return rev;
}
```

### PalindromeNumber
> 判斷整數是否為 Palindrome Number (從左而右,從右而左讀起來都一樣)  
> example1: input:121 output:true  
> example2: input: -121 output: false (變成121-)  
> example3: input: 10 output: false (變成01)  

```java=
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
```

### RomanToInteger
> 將輸入的羅馬數字字串轉換成整數  
> 規則: I(1) 放在 V(5)前面會變 IV(4), I(1) 放在 X(10)前面會變 IX(9)  
> 規則: X(10) 放在 L(50)前面會變 XL(40), X(10) 放在 C(100)前面會變 XC(90)  
> 規則: C(100) 放在 D(500)前面會變 CD(400), C(100) 放在 M(1000)前面會變 CM(900)  
> 限制: 1 <= s.length <=15  
> 限制: 僅能有以下羅馬字串['I', 'V', 'X', 'L', 'C', 'D', 'M']  
> 限制: 換算的數字必須介於1~3999之間  
> example1: input: s= "III", output: 3
> example2: input: s= "IV", output: 4
> example3: input: s= "IX", output: 9
> example4: input: s= "LVIII", output: 58
> example5: input: s= "MCMXCIV", output: 1994

| Symbol | Value |
| ------ |:-----:|
| I      |   1   |
| V      |   5   |
| X      |  10   |
| L      |  50   |
| C      |  100  |
| D      |  500  |
| M      | 1000  |

```java=
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
```

###### tags: `LeetCode`, `Y.`