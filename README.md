{%hackmd theme-dark %}
TOC
---
* [EASY](#EASY)
	* [Two Sum](#TwoSum)
	* [Reverse Integer](#ReverseInteger)
	* [Palindrome Number](#PalindromeNumber)
	* [Roman to Integer](#RomanToInteger)
	* [Longest Common Prefix](#LongestCommonPrefix)
	* [Valid Parentheses](#ValidParentheses)
* [MEDIUM](#MEDIUM)
    * [Add Two Numbers](#AddTwoNumbers)
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
public int reverse(int x) {
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



/* v2
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
*/


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
			/*
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
```

### LongestCommonPrefix
> 發現一組字串陣列中從開頭開始算,求他們共同的字母有幾個? 若無共同字母則回傳空字串""  
> example1: input: strs = ["flower","flow","flight"]; output: "fl"  
> example2: input: strs = ["dog","racecar","car"]; output: ""  
> constrains: 0 <= strs.length <=200  
> constrains: 0 <= strs[i].length() <= 200  
> constrains: strs[i] consists of only lower-case English letters.  

```java=
// Horizontal scanning
public String longestCommonPrefix(String[] strs) {
	if (strs.length == 0)
		return "";
	// 選第0個陣列數值當比較值
	String prefix = strs[0];
	// 進入迴圈和陣列裡面其他的數值做比較
	for (int i = 1; i < strs.length; i++)
		// 當 strs[i]的內容無法完整和prefix的內容相符時 就進入迴圈一值比對
		while (strs[i].indexOf(prefix) != 0) {
			// prefix 每次都捨棄最後一個字元和 strs[i]進行比對
			prefix = prefix.substring(0, prefix.length() - 1);
			if (prefix.isEmpty())
				return "";
		}
	return prefix;
}


// Vertical scanning
public String longestCommonPrefix(String[] strs) {
	if (strs == null || strs.length == 0) return "";

	// 第一層迴圈為 strs[0] 第一個字元 到 最後一個字元
	for (int i = 0; i < strs[0].length() ; i++){
		// 從第一個字元開始取出來
		char c = strs[0].charAt(i);
		// 第二層迴圈為 strs[1] 到陣列的最後一個字串
		for (int j = 1; j < strs.length; j ++) {
			//條件1: i == strs[j].length() 當找到陣列中長度最短的字串時 最長共同前綴字元(LCP)的比較也隨即結束 
			//條件2: strs[j].charAt(i) != c 當strs[j]的第charAt(i)個字元和我們的 c 不相同時比較隨即結束
			if (i == strs[j].length() || strs[j].charAt(i) != c)
				return strs[0].substring(0, i);             
		}
	}
	return strs[0];
}
```

### ValidParentheses
> Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.  
> constraints: 1<= s.length() <= 10e4  
> constraints: s consists of parentheses only '()[]{}'  
> example1: input: "()"; output: true  
> example2: input: "()[]{}"; output: true  
> example3: input: "(]"; output: false  
> example4: input: "([)]"; output: false  
> example5: input: "{[]}"; output: true

```java=
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
```

## MEDIUM

### AddTwoNumbers
> 輸入兩個非空的數值串列求總和
> ![](https://i.imgur.com/mBbtFtN.png)

```java=
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode temp = l3;
        int carry = 0;
        int sum = 0;
        
        while(l1 != null || l2 != null){
            int x =  (l1 == null) ? 0 : l1.val;
            int y =  (l2 == null) ? 0 : l2.val;
            
            sum = x + y + carry;
            // 取得進位數值
            carry = sum / 10;
            // 創造子節點並賦予數值
            temp.next = new ListNode(sum % 10);
            // 將當前節點移到剛創立的子節點
            temp = temp.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // 最後還要再做一次是否有進位的判斷
        if (carry > 0) 
            temp.next = new ListNode(1);
        
        return l3.next;
    }
}
```
 

###### tags: `LeetCode`, `Y.`