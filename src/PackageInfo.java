
public class PackageInfo {

    String packageName;
    double ca, ce, na, nc;

    public PackageInfo(double na, double nc, double ca, double ce) {
        this.ce = ce;
        this.ca = ca;
        this.na = na;
        this.nc = nc;
    }

    public double getInstability() {
        if(ce == 0 || (ca + ce) == 0) return 0;
        return ce/(ca+ce);
    }

    public double getAbstractness() {
        if(na == 0 || nc == 0) return 0;
        return na/nc;
    }

    public double getDistance() {
        return Math.abs(getAbstractness() + getInstability() - 1);
    }
    
}
