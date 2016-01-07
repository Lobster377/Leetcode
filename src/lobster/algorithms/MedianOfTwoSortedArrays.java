package lobster.algorithms;
/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * @author lobster
 *
 */
public class MedianOfTwoSortedArrays {
	//m+n /2
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        double arn=0;
        double arnp = 0;
        if(nums1.length==0) {
        	if(nums2.length%2 == 0) {
        		arn= (nums2[nums2.length/2-1]+nums2[nums2.length/2])/2.0;
        	}else {
        		arn= nums2[nums2.length/2];
        	}
        }else if(nums2.length==0){
        	if(nums1.length%2 == 0) {
        		arn= (nums1[nums1.length/2-1]+nums1[nums1.length/2])/2.0;
        	}else {
        		arn= nums1[nums1.length/2];
        	}
        }else{
        	for(int i=0,j=0;;) {
            	if(i+j>(m+n)/2 && (m+n)%2 !=0) {
            		break;
            	}
            	if(i+j>(m+n)/2 && (m+n)%2 == 0) {
            		arn=(arn+arnp)/2;
            		break;
            	}
            	arnp=arn;
            	if(i<nums1.length && j<nums2.length) {
            		if(nums1[i]<nums2[j]){
                		arn = nums1[i];
                		i++;
                	}else{
                		arn = nums2[j];
                		j++;
                	}
            	}else if(i == nums1.length){
            		arn = nums2[j];
            		j++;
            	}else {
            		arn = nums1[i];
            		i++;
            	}
            	
            }
        }
        return arn;
    }
}
