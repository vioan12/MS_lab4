
import java.awt.geom.Path2D;
import java.io.*;
import java.util.Vector;

import static java.lang.System.err;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Vector<Double> V = new Vector<Double>();
            double min,max;
            int nr;
            StdGenerator SG= new StdGenerator(100000);
            BinomialDistribution BD= new BinomialDistribution(100000,0.6,SG);
            PoissonDistribution PD=new PoissonDistribution(60,100000,SG);

            min= Double.MAX_VALUE;
            max=Double.MIN_VALUE;
            System.out.println("Poisson Distribution");
            for(int i=0;i<100;i++) {
                V.add(PD.next());
                if(V.lastElement()<min)
                    min=V.lastElement();
                if(V.lastElement()>max)
                    max=V.lastElement();
                System.out.println(V.lastElement().toString());
            }
            System.out.println("");
            for(double i=min;i<=max;i=i+1){
                nr=0;
                for(int j=0;j<V.size();j++)
                    if(V.elementAt(j)==i)
                        nr++;
                System.out.println(i+"->"+nr);
            }
            V.removeAllElements();

            System.out.println("");
            System.out.println("");
            System.out.println("Binomial Distribution");
            min= Double.MAX_VALUE;
            max=Double.MIN_VALUE;
            for(int i=0;i<100;i++) {
                V.add(BD.next());
                if(V.lastElement()<min)
                    min=V.lastElement();
                if(V.lastElement()>max)
                    max=V.lastElement();
                System.out.println(V.lastElement().toString());
            }
            System.out.println("");
            double div=0.01;
            for(double i=min;i<max;i=i+div){
                nr=0;
                for(int j=0;j<V.size();j++)
                    if((V.elementAt(j)>=i) && (V.elementAt(j)<=i+div))
                        nr++;
                System.out.println("["+i+","+(i+div)+"]->"+nr);
            }
            V.removeAllElements();

        }catch (Exception e)
        {
            System.out.println("Got an exception! " + err);
        }
    }
}
