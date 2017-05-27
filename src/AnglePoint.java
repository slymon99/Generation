import java.awt.geom.Point2D;

/**
 * Created by Simon on 5/25/2017.
 */
public class AnglePoint extends Point2D.Double {
    private double theta;
    public AnglePoint(Point2D.Double p, Point2D.Double origin){
        super(p.getX(), p.getY());
        double x = p.getX() - origin.getX();
        double y = p.getY() - origin.getY();
        theta = Math.atan(y/x);
    }

    public double getTheta(){
        return theta;
    }

    public String toString(){
        return (super.getX() + " " + super.getY() + " " + theta);
    }
}
