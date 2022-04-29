import java.awt.geom.Point2D;

//this is an abstract class of the shape and it has four abstract classes which are overrided in Circle, Rectangle
// and triangle.
abstract public class Shapes {

    public abstract Point2D.Double center();
    public abstract double area();
    public abstract double circumference();
    public abstract void check(Point2D.Double point);

   //this method is not abstract since it's universal to each shape
    public static double Distance(Point2D.Double firstShape_center, Point2D.Double secondShape_center){
        double dX1 = firstShape_center.x - secondShape_center.x;
        double dY1 = firstShape_center.y - secondShape_center.y;
        double distance = Math.sqrt(dX1*dX1 +dY1*dY1);
        return distance;
    }

    }


