package lobster.algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		Queue<Character> rex = new LinkedList<Character>();
		Stack<Character> st = new Stack<Character>();
		for(int i=0;i<p.length();i++) {
			Character c = p.charAt(i);
			if(c>'a'&&c<'z' || c>'A'&&c<'Z') {
				st.push(c);
			}
			if(c == '.'|| c == '*') {
				rex.add(c);
			}
		}
        return false;
    }
}
