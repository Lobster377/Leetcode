package lobster.algorithms;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author lobster
 *
 */
public class Sum3Closest {
	public int threeSumClosest(int[] nums, int target) {
		int ret = nums[0]+nums[1]+nums[2];
		if (nums.length > 2) {
			Arrays.sort(nums);
			for (int i = 0; i < nums.length - 1; i++) {
				if (i > 0 && nums[i] == nums[i - 1]) {
					continue;
				}
				int p = nums[i];
				int f = i + 1;
				int l = nums.length - 1;
				while (l != f) {
					int t = nums[f] + nums[l];
					if (f > 0 && f - 1 != i && nums[f] == nums[f - 1]) {
						f++;
						continue;
					}
					if (l < nums.length - 1 && nums[l] == nums[l + 1]) {
						l--;
						continue;
					}
					int sum = t + p;
					if (Math.abs(target - sum) < Math.abs(target - ret)) {
						ret = sum;
					}
					if ((t + p) > target) {
						l--;
					} else {
						f++;
					}
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		int i = new Sum3Closest().threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1);
		
		System.out.println(i);
	}
}
