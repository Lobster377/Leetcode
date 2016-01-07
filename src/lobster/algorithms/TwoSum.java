package lobster.algorithms;

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
