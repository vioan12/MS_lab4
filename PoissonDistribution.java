/**
 * Created by ioan on 10/29/17.
 */
public class PoissonDistribution {
    private double Lambda;
    private int n;
    private Generator G;

    PoissonDistribution(double valueofLambda,int valueofn,Generator valueofG)
    {
        this.Lambda=valueofLambda;
        this.n=valueofn;
        this.G=valueofG;
    }

    public double next()
    {
        double L,p;
        float u;
        int k;
        L=Math.pow(Math.E,-Lambda);
        k=0;
        p=1;
        do{
            k=k+1;
            u=G.next();
            p=p*u;
        }while ((p>L)&&(k<=n));
        return k-1;
    }
}
