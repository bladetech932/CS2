//import java.lang.Math;cm
public class Fib {
    public static void main(String[] args) {
        try {
            int nput = 
                    Integer.parseInt(args[0]);
            double output = (Math.pow(((Math.sqrt(5)+1)/2),nput) - Math.pow(((1-Math.sqrt(5))/2),nput))/Math.sqrt(5);
            System.out.printf("%9.0f\n", output);        
        }
        catch(Exception e) {System.out.println("Usage: enter number for nth term as first parameter");}
    }
}
