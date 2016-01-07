package lobster.algorithms;

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
	
	
	
	public static void main(String[] args) {
		long i = new ReverseInteger().reverse(1534236469);
		System.out.println(i);
	}
}
