package lobster.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * @author lobster
 *
 */
public class GenerateParentheses {
	//待优化
    public List<String> generateParenthesis(int n) {
        Map<Integer,Set<String>> map = new HashMap<Integer,Set<String>>();
        for(int i =1;i<=n;i++) {
        	if(i==1) {
        		Set<String> set = new HashSet<String>();
        		set.add("()");
        		map.put(i, set);
        	}else {
        		Set<String> set = new HashSet<String>();
        		for (String par : map.get(i-1)) {
					for(int p = 0;p<par.length()+1;p++) {
						if(p==0) {
							set.add("()"+par);
						}else {
							set.add(par.substring(0,p)+"()"+par.substring(p, par.length()));
						}
					}
				}
        		map.put(i, set);
        	}
        }
        return new ArrayList<String>(map.get(n));
    }
}
