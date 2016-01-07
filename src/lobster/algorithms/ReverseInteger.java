package lobster.algorithms;


/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * @author lobster
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
		long last = x;
		long step = 10;
		long ret = 0;
        while(last!=0) {
        	if(ret*step>Integer.MAX_VALUE || ret*step<Integer.MIN_VALUE) {
        		return 0;
        	}
        	ret = ret*step;
        	long p = last%10;
        	ret = ret+p;
        	last/=10;
        }
        return (int)ret;
	}
	
}
