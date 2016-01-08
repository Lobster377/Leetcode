package lobster.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *    A solution set is:
 *    (-1,  0, 0, 1)
 *    (-2, -1, 1, 2)
 *    (-2,  0, 0, 2)
 * @author lobster
 *
 */
public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++) {
        	if(nums[i]>0 && nums[i]>target) {
        		break;
        	}
        	if(i-1>=0 && nums[i-1] == nums[i]) {
        		continue;
        	}
        	List<List<Integer>> three = threeSum(nums,i+1,nums.length-1,target-nums[i]);
        	for (List<Integer> list2 : three) {
        		List<Integer> atom = new ArrayList<Integer>();
        		atom.add(nums[i]);
        		atom.addAll(list2);
        		list.add(atom);
			}
        }
        return list;
    }
    
    private List<List<Integer>> threeSum(int[] nums,int s,int e,int target) {
    	List<List<Integer>> list = new Stack<List<Integer>>();
    	if(nums.length>2) {
    		for(int i=s;i<e;i++) {
        		if(i>s && nums[i]==nums[i-1] || (nums[i]>0 && nums[i]>target)) {
        			continue;
        		}
        		int p = nums[i];
        		int f = i+1;
        		int l = e;
        		while(l!=f) {
        			int t = nums[f]+nums[l];
        			if(f>0&&f-1!=i&&nums[f] == nums[f-1]) {
        				f++;
        				continue;
        			}
        			if(l<e&&nums[l] == nums[l+1]) {
        				l--;
        				continue;
        			}
        			if(t+p==target) {
        				List<Integer> o = new ArrayList<Integer>();
        				o.add(p);
        				o.add(nums[f]);
        				o.add(nums[l]);
        				list.add(o);
        			}
        			if((t+p)>target){
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
