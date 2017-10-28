
import java.io.*;
import static java.lang.System.err;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            StdGenerator SG= new StdGenerator(100000);
            BinomialDistribution BD= new BinomialDistribution(1000,0.6,SG);
            PoissonDistribution PD=new PoissonDistribution(26.036,1000,SG);
            for(int i=0;i<100;i++)
                System.out.println(PD.next());

        }catch (Exception e)
        {
            System.out.println("Got an exception! " + err);
        }
    }
}
