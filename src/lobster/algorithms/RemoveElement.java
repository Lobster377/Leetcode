package lobster.algorithms;


/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * @author lobster
 *
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int len = 0;
        if(nums.length==0) {
        	return len;
        }
        for(int i = 0;i<nums.length;i++){
        	if(nums[i] == val) {
        		continue;
        	}else {
        		nums[len] = nums[i];
        		len++;
        	}
        }
        return len;
    }
    
    public static void main(String[] args) {
		int[] ns = new int[]{2};
		int len = new RemoveElement().removeElement(ns, 3);
		System.out.println(len);
		System.out.println(ns);
	}
}
