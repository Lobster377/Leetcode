package lobster.algorithms;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * @author lobster
 *
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] solution = new int[2];
		boolean done=false;
		for(int i =0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]+nums[j] == target) {
					done=true;
					solution[0]=(i>j?j:i)+1;
					solution[1]=(i>j?i:j)+1;
					break;
				}
			}
			if(done) {
				break;
			}
		}
		return solution;
    }
}
