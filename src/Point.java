import java.awt.geom.Point2D;
import java.util.Scanner;


public class Point {
    Point2D.Double point;

    //this method asks a user for an input of x and y coordinates (doubles) of the point that going to be checked
    // weather it is insight of the each shape or not .
 public Point2D.Double getPoint(){
    Scanner input = new Scanner(System.in);
        System.out.println("Enter a point coordinates to test whether it is inside the shape or not");
        System.out.print("Enter x: ");
    double x = input.nextDouble();
        System.out.print("Enter y: ");
    double y = input.nextDouble();

    point = new Point2D.Double(x,y);

        return point;

    }



}
