package lobster.algorithms;


/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author lobster
 *
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if(strs.length != 0) {
        	prefix = strs[0];
        	for(int i = 1;i<strs.length;i++) {
        		if(prefix == null || prefix.equals("")) {
        			prefix = "";
        			break;
        		}
        		if(strs[i].length() == 0) {
        			prefix = "";
        			break;
        		}
        		if(!strs[i].equals(prefix)) {
        			for(int t = 0;t<prefix.length();t++) {
        				if(t>=strs[i].length()) {
        					prefix = strs[i];
        					break;
        				}
        				if(prefix.charAt(t) != strs[i].charAt(t)) {
        					prefix = strs[i].substring(0,t);
        					break;
        				}
        			}
        		}
        	}
        }
        return prefix;
    }
}
