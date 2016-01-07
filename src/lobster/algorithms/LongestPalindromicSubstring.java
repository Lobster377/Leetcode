package lobster.algorithms;


/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * @author lobster
 *
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		String ret = "";
		int ttl=0;
		for(int j=0;j<s.length();j++) {
			int i = (j+s.length()/2)%(s.length());
			if(ret.length()<1) {
				ret = ""+s.charAt(i);				
			}
			if((s.length()-i<i?s.length()-i:i)*2+1<ret.length()) {
				continue;
			}
			int step=0;
			boolean t1 = true;
			boolean t2 = true;
			while(i-step>=0 && i+step<s.length()) {
				ttl++;
				if(t1) {
					char a = s.charAt(i-step);
					char b = s.charAt(i+step);	
					if(a == b && t1) {
						if(ret.length()<2*step+1){
							ret = s.substring(i-step,i+step+1);						
						}
					}else {
						t1=false;
					}
				}
				if(t2) {
					char c = s.charAt(i-step);
					char d;
					if(i+step+1 != s.length()) {
						d = s.charAt(i+step+1);
					}else {
						d=0;
					}
					
					if(c == d && t2) {
						if(ret.length()<2*step+2) {
							ret = s.substring(i-step,i+step+2);						
						}
					}else {
						t2=false;
					}
				}
				if(!t1 && !t2) {
					break;
				}
				step++;
			}
		}
		System.out.println(ttl);
		return ret;
    }
	
	public static void main(String[] args) {
		String ret = new LongestPalindromicSubstring().longestPalindrome("bb");
		System.out.println(ret);
	}
}
 