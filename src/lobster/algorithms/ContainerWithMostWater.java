package lobster.algorithms;


/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 * @author lobster
 *
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
        int max = 0;
        int first = 0;
        int last = height.length-1;
        while(first != last) {
        	int h1 = height[first];
        	int h2 = height[last];
        	int r = (last-first)*(h2>h1?h1:h2);
        	if(r>max) {
        		max = r;
        	}
        	//
        	if(h1<h2) {
        		first++;
        	}else {
        		last--;
        	}
        }
        return max;
    }
}
