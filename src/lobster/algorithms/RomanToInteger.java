package lobster.algorithms;


/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author lobster
 *
 */
public class RomanToInteger {
	public int romanToInt(String s) {
		int ret = 0;
		String[][] sym = new String[][]{
        		new String[]{"I","II","III","IV","V","VI","VII","VIII","IX"},
        		new String[]{"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
        		new String[]{"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
        		new String[]{"M","MM","MMM"}};
		int step=1;
		int index = s.length();
		for(int i = 0;i<sym.length;i++) {
			for(int j=sym[i].length-1;j>=0;j--) {
				if(j==4) {
					int g = s.substring(0, index).lastIndexOf(sym[i][j-1]);
					if(g!=-1) {
						ret = ret+j*step;
						index=g;
						break;
					}
				}
				int g = s.substring(0, index).lastIndexOf(sym[i][j]);
				if(g!=-1) {
					ret = ret+(j+1)*step;
					index=g;
					break;
				}
			}
			step=step*10;
		}
		return ret;
    }
	public static void main(String[] args) {
		System.out.println(new RomanToInteger().romanToInt("MCMXCVI"));
	}
}
