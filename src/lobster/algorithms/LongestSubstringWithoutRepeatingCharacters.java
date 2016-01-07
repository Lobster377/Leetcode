package lobster.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * @author lobster
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		Set<Character> chars = new HashSet<Character>();
		Queue<Character> queue = new LinkedList<Character>();
		int max = 0;
		for(int i = 0;i<s.length();i++) {
			if(chars.contains(s.charAt(i))) {
				Character t;
				while((t = queue.poll()) != s.charAt(i)) {
					chars.remove(t);
				}
			}
			chars.add(s.charAt(i));
			queue.add(s.charAt(i));
			
			if(queue.size()>max) {
				max = queue.size();
			}
		}
		return max;
    }
	
}
