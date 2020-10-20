package leetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int terget) {
		Map<Integer, Integer> intMap = new HashMap<>();
		int r;
		for (int i = 0; i < nums.length; i++) {
			r = terget - nums[i];
			if (intMap.containsKey(r)) {
				return new int[] {intMap.get(r) ,i};
			} else {
				intMap.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException("Can not find answer in the Array.");
	}
}
