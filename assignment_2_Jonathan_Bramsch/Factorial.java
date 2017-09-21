public class Factorial {
	public static void main(String[] args) {
		System.out.print("Factorial.calculate(0) ");
		System.out.print("returned " + calculate(0));
		if (calculate(0) == 1) {System.out.println(" Test Passed!");}
		else {System.out.print(" Test Failed");}
		System.out.print("Factorial.calculate(5) ");
		System.out.print("returned " + calculate(5));
		if (calculate(5) == 120) {System.out.println(" Test Passed!");}
		else {System.out.print(" Test Failed");}
	}
	public static long calculate(long n) {
		long runningTotal = 0;
		if (n > 20 || n < 0) {System.out.println("Usage: n  must be within the range of (0,20)");}
		else {	
			for (int i = 0;i <= n;i++) {
				if (i == 1 || i == 0) {runningTotal = 1;}
				else {runningTotal = runningTotal * i;}
			}
		}
	return runningTotal;
	}
}