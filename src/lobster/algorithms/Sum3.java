package lobster.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * @author lobster
 *
 */
public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> list = new Stack<List<Integer>>();
    	if(nums.length>2) {
    		Arrays.sort(nums);
    		for(int i=0;i<nums.length-1;i++) {
        		if(i>0 && nums[i]==nums[i-1] || nums[i]>0) {
        			continue;
        		}
        		int p = nums[i];
        		int f = i+1;
        		int l = nums.length-1;
        		while(l!=f) {
        			int t = nums[f]+nums[l];
        			if(f>0&&f-1!=i&&nums[f] == nums[f-1]) {
        				f++;
        				continue;
        			}
        			if(l<nums.length-1&&nums[l] == nums[l+1]) {
        				l--;
        				continue;
        			}
        			if(t+p==0) {
        				List<Integer> o = new ArrayList<Integer>();
        				o.add(p);
        				o.add(nums[f]);
        				o.add(nums[l]);
        				list.add(o);
        			}
        			if((t+p)>0){
        				l--;
        			}else {
        				f++;
        			}
        		}
        	}
    	}
    	return list;
    }
}
