package lobster.algorithms;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author lobster
 *
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        String[][] sym = new String[][]{
        		new String[]{"I","II","III","IV","V","VI","VII","VIII","IX"},
        		new String[]{"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
        		new String[]{"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
        		new String[]{"M","MM","MMM"}};
        int n = num;
        int sy = 0;
        String ret = "";
        while(n!=0) {
        	int s = n%10;
        	if(s>0) {
        		ret = sym[sy][s-1]+ret;        		
        	}
        	n=n/10;
        	sy++;
        }
        return ret;
    }

    public static void main(String[] args) {
		System.out.println(new IntegerToRoman().intToRoman(240));
	}
}
