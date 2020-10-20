{%hackmd theme-dark %}
# LeetCode

## Two Sum
> 輸入一串可重複的整數,其中某兩個整數和必等於目標值
> + example1: input: nums[2,7,11,15] target=9 output: [0,1] 因為 nums[0]+nums[1]=9
> + example2: input: nums[3,3] target=6 output: [0,1]
> + example3: input: nums[3,2,4] target=6 output:[1,2]

Ans:

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


###### tags: `LeetCode`, `Y.`