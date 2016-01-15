package lobster.algorithms;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * @author lobster
 *
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
    	int maxLen=0;
    	Stack<Character> stack = new Stack<Character>();
    	int len = 0;
    	boolean l = true;
        for(int i = 0;i<s.length();i++){
        	char c = s.charAt(i);
        	if(c == '(') {
        		stack.push(c);
        		l=false;
        	}
        	if(c == ')'){
        		if(!stack.isEmpty()) {
        			stack.pop();
        			len+=2;
        			if(stack.isEmpty()) {
        				if(maxLen<=len) {
        					maxLen = len;
        				}        				
        			}
        			l = true;
        		}else {
        			stack.clear();
        			len=0;
        			l=true;
        		}
        	}
        }
        if(!stack.isEmpty()) {
        	len = len - maxLen;
        	if(maxLen<=len) {
				maxLen = len;
			}  
        }
        return maxLen;
    }
    
    public static void main(String[] args) {
    	//010001=2  ((())()())) 00011010111
    	
		int len = new LongestValidParentheses().longestValidParentheses("((()(()(())");
		
		System.out.println(len);
	}
}
