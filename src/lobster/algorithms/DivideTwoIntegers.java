package lobster.algorithms;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 * @author lobster
 *
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        long d1 = Math.abs(((Integer)dividend).longValue());
        long d2 = Math.abs(((Integer)divisor).longValue());
        long count = 1;
        if(d2>d1) {
        	return 0;
        }
        while(d2 <= d1) {
        	d2 = d2<<1;
        	count = count<<1;
        }
        count=count>>1;
        d2=d2>>1;
        count = count+Math.abs(divide((int)(d1-d2),divisor));
        if ((dividend>0&&divisor<0) || (dividend<0&&divisor>0)) {
        	count = 0-count;
        	
        }
        if(count > Integer.MAX_VALUE) {
        	count = Integer.MAX_VALUE;
        }
        if(count<Integer.MIN_VALUE) {
        	count = Integer.MIN_VALUE;
        }
        return (int)count;
    }
    
    public static void main(String[] args) {
		int i = new DivideTwoIntegers().divide( -2147483648,-3);
		System.out.println(i);
	}
}
