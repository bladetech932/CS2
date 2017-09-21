public class Ramanujan 
{
    public static void main(String[] args)
    {
        
        int k = Integer.parseInt(args[0]);
        
        double pi = 0;
        double fourXFact;
        double xFact; 
        double percentError;
        
        for (int x = 0; x <= k; x++)
        {
           fourXFact = Factorial.calculate(4*x); 
           xFact = Factorial.calculate(x);
           pi += (fourXFact*(1103+26390*x))/(Math.pow(xFact, 4)*(Math.pow(396, 4*x)));
        }
        pi = 1/(((2*Math.sqrt(2))/9801) * pi);
        
        System.out.println(pi);
        
        if (pi < Math.PI)
        {
            percentError = 100 - ((pi/Math.PI)*100);
        }
        else
        {
            percentError = 100 - ((Math.PI/pi)*100);
        }
        System.out.println("This differs from Java's value by " + percentError + " percent.");
    }
}
