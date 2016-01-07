package lobster.algorithms;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * @author lobster
 *
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x<0){
            return false;
        }
		long last = x;
		long step = 10;
		long ret = 0;
        while(last!=0) {
        	if(ret*step>Integer.MAX_VALUE || ret*step<Integer.MIN_VALUE) {
        		return false;
        	}
        	ret = ret*step;
        	long p = last%10;
        	ret = ret+p;
        	last/=10;
        }
        return (int)ret == x;
	
	}
	
}
