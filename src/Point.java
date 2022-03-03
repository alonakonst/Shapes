import java.awt.geom.Point2D;
import java.util.Scanner;

public class Point {
    Point2D.Double point;

 public Point2D.Double getPoint(){
    Scanner input = new Scanner(System.in);
        System.out.println("Point to test whether it is inside the shape of not");
        System.out.print("Enter x: ");
    double x = input.nextDouble();
        System.out.print("Enter y: ");
    double y = input.nextDouble();

    point = new Point2D.Double(x,y);

        return point;

    }

}
