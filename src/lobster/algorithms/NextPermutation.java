package lobster.algorithms;

import java.util.Arrays;


/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * @author lobster
 *
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
    	int i = nums.length-1;
    	boolean d = false;
        for(;i>=0;i--) {
        	for(int j = nums.length-1;j>=i+1;j--) {
        		if(nums[i]>=nums[j]) {
        			continue;
        		}else {
        			int tem = nums[i];
            		nums[i]=nums[j];
            		nums[j]=tem;
            		d=true;
            		Arrays.sort(nums, i+1, nums.length);
            		break;
        		}
        	}
        	if(d) {
        		break;
        	}
        }
        if(i==-1 && !d) {
        	for(int k = 0;k<nums.length/2;k++) {
        		int tem = nums[k];
        		nums[k]=nums[nums.length-1-k];
        		nums[nums.length-1-k] = tem;
        	}
        }
    }
}
