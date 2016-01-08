package lobster.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent. A mapping of digit to letters (just like on the telephone
 * buttons) is given below. Input:Digit string "23" Output: ["ad", "ae", "af",
 * "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Note: Although the above answer is in lexicographical order, your answer
 * could be in any order you want.
 * 
 * @author lobster
 *
 */
public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
		String[] keymap = new String[]{" ", "", "abc", "def", "ghi", "jkl",
				"mno", "pqrs", "tuv", "wxyz"};
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < digits.length(); i++) {
			Integer key = Integer.parseInt(digits.charAt(i) + "");
			String h = keymap[key];
			if (list.size() > 0) {
				List<String> tem = new ArrayList<String>();
				for (int s = 0; s < list.size(); s++) {
					String pre = list.get(s);
					for (int j = 0; j < h.length(); j++) {
						tem.add(pre + h.charAt(j));
					}
				}
				list = tem;
			}else {
				for (int j = 0; j < h.length(); j++) {
					list.add("" + h.charAt(j));
				}
			}
		}
		return list;
	}
}
