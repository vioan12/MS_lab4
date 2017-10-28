/**
 * Created by ioan on 10/29/17.
 */
public class BinomialDistribution {
    private int n;
    private double p;
    private Generator G;

    BinomialDistribution(int valueofn,double valueofp,Generator valueofG)
    {
        this.n=valueofn;
        this.p=valueofp;
        this.G=valueofG;
    }

    public double next()
    {
        int x=0;
        float u;
        for(int i=0;i<n;i++){
            u=G.next();
            if(u<p)
                x++;
        }
        return (double)x/(double)(n-1);
    }
}
