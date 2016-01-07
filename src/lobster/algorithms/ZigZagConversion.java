package lobster.algorithms;


/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * @author lobster
 *
 */
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