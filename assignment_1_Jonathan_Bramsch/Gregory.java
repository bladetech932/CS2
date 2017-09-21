import java.lang.Math;
public class Gregory {
    public static void main(String[] args) {
        try{
            int k = Integer.parseInt(args[0]);
            double result = 0;
            for(int i = 1; i <= k; i++) {
                result = (4 * Math.pow(-1,i+1)/(2*i-1)) + result;
            }
            System.out.println("Pi according to Gregory series: " + result);
            double diffPercent = 100 * (Math.PI - result) / Math.PI;
            System.out.println("This differs from Java's Value by " + diffPercent + " percent.");
        }
        catch(Exception e) {
            System.out.println("Usage: Java Gregory k \nWhere k is the number of terms to use to calculate Pi");
        }
    }
}
