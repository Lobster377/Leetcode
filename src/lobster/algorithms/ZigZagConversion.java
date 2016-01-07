package lobster.algorithms;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
        char[] ret = new char[s.length()];
        int t = 0;
        for(int i=0;i<numRows;i++) {
        	int target = i;
        	if(i == 0 || i==numRows-1) {
        		while(target<s.length()) {
        			ret[t++]=s.charAt(target);     			
        			target = target+(((numRows-1)*2-1)>0?(numRows-1)*2-1:0)+1;
        		}
        	}else {
        		while(target<s.length()) {
        			ret[t++]=s.charAt(target);     			
        			target = target+(numRows-i)*2-2;
        			if(target<s.length()) {
        				ret[t++]=s.charAt(target);
        				target = target+i*2;
        			}else {
        				break;
        			}
        		}
        	}
        }
        return new String(ret);
    }
}