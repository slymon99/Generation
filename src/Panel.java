import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Simon on 5/24/2017.
 */
public class Panel extends JPanel {
    public static void main(String[] args) {

        JFrame window = new JFrame("Template");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 800, 800); //(x, y, w, h)

        Panel panel = new Panel();
        window.add(panel);

        window.setVisible(true);
        panel.setFocusable(true);
        panel.requestFocusInWindow();


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        AffineTransform yFlip = AffineTransform.getScaleInstance(1, -1);
        AffineTransform move = AffineTransform.getTranslateInstance(0, -760);
        g2.transform(yFlip);
        g2.transform(move);

//        Point2D.Double a = new Point2D.Double(200, 200);
//        Point2D.Double b = new Point2D.Double(600, 0);
//        Point2D.Double c = new Point2D.Double(300, 500);
//
//        Point2D.Double ab = findMidPoint(a, b);
//        Point2D.Double ac = findMidPoint(a, c);
//
//
//        double abSlope = findSlope(a, b);
//        double acSlope = findSlope(a, c);
//        System.out.println(abSlope);
//        System.out.println(acSlope);
//
//        Point2D.Double intersect = findIntersectPoint(ab, -1 / abSlope, ac, -1 / acSlope);
//
//        g2.draw(new Line2D.Double(a, ab));
//        g2.draw(new Line2D.Double(a, ac));
//        g2.draw(new Line2D.Double(ab, intersect));
//        g2.draw(new Line2D.Double(ac, intersect));
//        drawPoint(a, g2);
//        drawPoint(b, g2);
//        drawPoint(c, g2);
//        drawPoint(intersect, g2);
//        drawPoint(ab, g2);
//        drawPoint(ac, g2);

//        Point2D.Double a = new Point2D.Double(200, 200);
//        Point2D.Double b = new Point2D.Double(300, 200);
//        Point2D.Double c = new Point2D.Double(300, 250);
//        Point2D.Double d = new Point2D.Double(300, 150);
//        AnglePoint e = new AnglePoint(b, a);
//        AnglePoint f = new AnglePoint(c, a);
//        AnglePoint h = new AnglePoint(d, a);
//        drawPoint(a, g2);
//        drawPoint(b, g2);
//        drawPoint(c, g2);
//        drawPoint(d, g2);
//        LinkedList<AnglePoint> evalPoints = new LinkedList<AnglePoint>();
//        evalPoints.add(e);
//        evalPoints.add(0, h);
//        System.out.println(evalPoints.toString() + " " + evalPoints.get(0).toString());

        ArrayList<Point2D.Double> points = new ArrayList<Point2D.Double>();
        for (int i = 0; i < 10; i++) {
            points.add(new Point2D.Double(Math.random() * 800, Math.random() * 800));
        }


        Point2D.Double origin = points.get(0);

        LinkedList<AnglePoint> evalPoints = new LinkedList<AnglePoint>();

        //places points into evalPoints in order based on angle towards the origin point
        for (Point2D.Double other : points) {
            if (!other.equals(origin)) {
                AnglePoint c = new AnglePoint(other, origin);

                if (evalPoints.size() == 0) {
                    evalPoints.add(c);
                } else {
                    int index = 0;
                    while (index < evalPoints.size() && evalPoints.get(index).getTheta() < c.getTheta()) {
                        index++;
                    }
                    evalPoints.add(index, c);
                }
            }
        }

        //culls excess points



    }

    public static Point2D.Double findMidPoint(Point2D.Double a, Point2D.Double b) {
        return (new Point2D.Double((a.x + b.x) / 2, (a.y + b.y) / 2));
    }

    public static double findSlope(Point2D.Double a, Point2D.Double b) {
        return ((b.y - a.y) / (b.x - a.x));
    }

    public static Point2D.Double findIntersectPoint(Point2D.Double a, double aSlope, Point2D.Double b, double bSlope) {
        //math
        double x = (aSlope * a.getX() - bSlope * b.getX() - a.getY() + b.getY()) / (aSlope - bSlope);
        double y = aSlope * (x - a.getX()) + a.getY();
        return (new Point2D.Double(x, y));
    }

    public static void drawPoint(Point2D.Double a, Graphics2D g2) {
        g2.fillOval((int) a.x - 2, (int) a.y - 2, 5, 5);
    }
}
