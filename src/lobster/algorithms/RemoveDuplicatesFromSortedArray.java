package lobster.algorithms;


/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 *   For example,
 *   Given input array nums = [1,1,2],
 *   Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * 
 * @author lobster
 *
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
    	int len = 0;
    	if(nums.length == 0) {
    		return len;
    	}
    	int pre = nums[0];
    	len = 1;
  
    	for(int i = 1;i<nums.length;i++) {
    		if(nums[i] == pre) {
    			continue;
    		}else {
    			pre = nums[i];
    			nums[len] = pre;
    			len++;
    		}
    	}
        return len;
    }
    
    public static void main(String[] args) {
    	int[] ns = new int[]{1,1,2};
		int i = new RemoveDuplicatesFromSortedArray().removeDuplicates(ns);
		System.out.println(i);
		System.out.println(ns);
	}
}
