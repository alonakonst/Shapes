//idk how to do testing
import java.awt.geom.Point2D;

abstract public class Shapes {

    public static void main(String[] args) {
        //this is the point which is checked whether it is inside the shapes or not
        Point point = new Point();
        Point2D.Double pointTest = point.getPoint();
        System.out.println();

        //Here are created three objects: circle, rectangle and triangle.
        System.out.println("Info about circle");
        Circle circle = new Circle(0,4,5.0);
        circle.center();
        circle.area();
        circle.circumference();
        circle.check(pointTest);
        System.out.println();

        System.out.println("Info about rectangle");
        Rectangle rectangle = new Rectangle(-2, 2, 4, -4);
        rectangle.center();
        rectangle.area();
        rectangle.circumference();
        rectangle.check(pointTest);
        System.out.println();

        System.out.println("Info about triangle");
        Triangle triangle = new Triangle (0.0, 0.0, 10.0, 10.0,20.0,0.0);
        triangle.center();
        triangle.area();
        triangle.circumference();
        triangle.check(pointTest);
        System.out.println();

        System.out.println("Distances between shapes are: ");
        Shapes.Distance(circle.center(), rectangle.center(), triangle.center());

    }

    public Point2D.Double center(){
        return new Point2D.Double();}

    public abstract double area();
    public abstract double circumference();
    public abstract void check(Point2D.Double point);

    public static void Distance(Point2D.Double Circle_center, Point2D.Double Rectangle_center, Point2D.Double Triangle_center){
        double dX1 = Circle_center.x - Rectangle_center.x;
        double dY1 = Circle_center.y - Rectangle_center.y;
        double dCircleRectangle = Math.sqrt(dX1*dX1 +dY1*dY1);
        System.out.println("Distance between circle and rectangle is: " + dCircleRectangle);

        double dX2 = Circle_center.x - Triangle_center.x;
        double dY2 = Circle_center.y - Triangle_center.y;
        double dCircleTriangle = Math.sqrt(dX2*dX2 +dY2*dY2);
        System.out.println("Distance between circle and triangle is: " + dCircleTriangle);

        double dX3 = Rectangle_center.x - Triangle_center.x;
        double dY3 = Rectangle_center.y - Triangle_center.y;
        double dRectangleTriangle = Math.sqrt(dX3*dX3 +dY3*dY3);
        System.out.println("Distance between rectangle and triangle is :" + dRectangleTriangle);

    }



}
