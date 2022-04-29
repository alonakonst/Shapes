import java.awt.geom.Point2D;

public class Main {
    public static void main(String[] args) {

        //Here are created three objects: circle, rectangle and triangle. Circumference and area of each shape is printed
        Circle circle = new Circle(0, 0, 5.0);
        System.out.println("Circumference of the circle is: " + circle.circumference());
        System.out.println("Area of the circle is " + circle.area());
        System.out.println();

        Rectangle rectangle = new Rectangle(-8, 2, 9, -4);
        System.out.println("Area of the rectangle is: "+ rectangle.area());
        System.out.println("Circumference of the rectangle is: "+ rectangle.circumference());
        System.out.println();


        Triangle triangle = new Triangle(3.0, 0.0, 50.0, 10.0, 90.0, 8.0);
        System.out.println("Area of the triangle is: "+ triangle.area());
        System.out.println("Circumference of the triangle is: "+ triangle.circumference());
        System.out.println();

        //this is the point which is checked whether it is inside the shapes or not
        Point point = new Point();
        Point2D.Double pointTest = point.getPoint();
        System.out.println();
        circle.check(pointTest);
        rectangle.check(pointTest);
        triangle.check(pointTest);
        System.out.println("");

        //method Distance() is called using the centre() method for each object (circle,rectangle and triangle) and computing the distance between the centres
        System.out.println("Distance between circle and rectangle is: " + Shapes.Distance(circle.center(),rectangle.center()));
        System.out.println("Distance between circle and triangle is: " + Shapes.Distance(circle.center(),triangle.center()));
        System.out.println("Distance between triangle and rectangle is: " + Shapes.Distance(triangle.center(),rectangle.center()));

    }
}