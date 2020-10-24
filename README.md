TOC
---
* [EASY](#EASY)
	* [TwoSum](#TwoSum)
	* [ReverseInteger](#ReverseInteger)
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
> + example4: input: 0, output: 0

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


###### tags: `LeetCode`, `Y.`