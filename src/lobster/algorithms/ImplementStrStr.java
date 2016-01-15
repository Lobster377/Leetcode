package lobster.algorithms;

/**
 * 
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * @author lobster
 *
 */
public class ImplementStrStr {

	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return -1;
		}
		if (needle.length() > haystack.length()) {
			return -1;
		}
		if (needle.length() == 0) {
			return 0;
		} else if (haystack.length() == 0) {
			return -1;
		}
		int index = -1;
		int ph = 0, pn = 0, h = 0;
		while (true) {
			if (haystack.charAt(ph) == needle.charAt(pn)) {
				if (pn == needle.length() - 1) {
					index = ph - needle.length() + 1;
					break;
				}
				ph++;
				pn++;
			} else {
				h++;
				ph = h;
				pn = 0;
			}
			if (ph == haystack.length()) {
				break;
			}
		}
		return index;
	}

	// KMP
	public int strstr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return -1;
		}
		if (needle.length() > haystack.length()) {
			return -1;
		}
		if (needle.length() == 0) {
			return 0;
		} else if (haystack.length() == 0) {
			return -1;
		}
		int next[] = new int[needle.length()];
		next[0] = 0;
		for (int q = 1, k = 0; q < needle.length(); ++q)
		{
			while (k > 0 && needle.charAt(q) != needle.charAt(k)){
				k = next[k - 1];				
			}
			if (needle.charAt(q) == needle.charAt(k)) {
				k++;
			}
			next[q] = k;
		}
		int index = -1;
		int ph = 0, pn = 0, h = 0;
		while (true) {
			if (haystack.charAt(ph) == needle.charAt(pn)) {
				if (pn == needle.length() - 1) {
					index = ph - needle.length() + 1;
					break;
				}
				ph++;
				pn++;
			} else {
				if(pn==0) {
					pn++;
				}
				h =h+pn-next[pn-1<0?0:pn-1];
				ph=h;
				pn = 0;
			}
			if (ph >= haystack.length()) {
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int index = new ImplementStrStr().strstr("mississippi", "issip");
		System.out.println(index);
	}
}
