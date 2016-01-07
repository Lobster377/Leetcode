package lobster.algorithms;

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
	
	public static void main(String[] args) {
		new PalindromeNumber().isPalindrome(-2147447412);
	}
}
