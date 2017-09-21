//import java.lang.Math;cm
public class FibIter {
    public static void main(String[] args) {
    	int input = Integer.parseInt(args[0]);
    	System.out.println(fibIter(input));
    }
	public static int fibIter(int nput) {
		int n = 0;
	    int nMinusOne = 1;
	    int nMinusTwo = 0;
		try {
	            if (nput == 1) {n = 1;}
	            else {
	      			for (int i = 2; i <= nput; i++) {
	      				n = nMinusTwo + nMinusOne;
	      				nMinusTwo = nMinusOne; 
	      				nMinusOne = n;        	
	      			}
	      		}
	            
	        }
	        catch(Exception e) {System.out.println("Usage: enter number for nth term as first parameter");}
	return n;
	}
}