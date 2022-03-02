//last Euclidean distance is not done
//idk how to do tests as well

import java.util.Arrays;
import java.util.Scanner;

abstract public class Shapes {  //This part till  public static void main(String[] args) is not ready, need more variables that are both in shapes and its child classes.
double x0;
double y0;

//methods pointX() and point(Y) are called for each object. this is to check if the point is inside the shape. For
    public void pointX(){
        double x1; //coordinates of the point which going to be checked
        Scanner inputx = new Scanner(System.in);
        System.out.println("Type your point coordinate X: ");
        x1 = inputx.nextDouble();
        System.out.println("Your point coordinates are: [" + x1 + "]");
        x0 = x1;
    }
    public void pointY() {
        double y1;
        Scanner inputy = new Scanner(System.in);
        System.out.println(" Type your point coordinate Y: ");
        y1 = inputy.nextDouble();
        System.out.println("Your point coordinates are: [" + y1 + "]");
        y0 = y1;
    }

    public double[] center(){
        return new double[]{};
    }
    public void area(){
        System.out.println("area is ...");
    }
    public void circumference(){
        System.out.println("Circumference is ...");
    }  //idk if we should leave them empty her or what.
    public void check(){}

    public void distanceToTriangle(){

    }

    public void distanceToRectangle(){

    }

    public void distanceToCircle(){


    }


    public static void main(String[] args) {
//Here are created three objects: circle, rectangle and triangle.

        System.out.println("Info about circle");
        Circle circle = new Circle(5,0,5.0);
        circle.pointX();
        circle.pointY();
        circle.center();
        circle.area();
        circle.circumference();
        circle.check();


        System.out.println("Info about rectangle");
        Rectangle rectangle = new Rectangle(5.0, 10.0, 20.0, 30.0);
        rectangle.center();
        rectangle.area();
        rectangle.circumference();
        rectangle.pointX();
        rectangle.pointY();
        rectangle.check();


        System.out.println("Info about triangle");
        Triangle triangle = new Triangle (0.0, 0.0, 10.0, 10.0,20.0,0.0);
        triangle.center();
        triangle.area();
        triangle.circumference();
        triangle.pointX();
        triangle.pointY();
        triangle.check();
    }

/*class of Circle combines methods,
that are listed in class Shapes, however they are changed according to circle properies.
Same for class Rectangle and Triangle.  */
    static class Circle extends Shapes {
        public double x;
        public double y;
        public double radius;

        //Circle is constructed from a coordinates of the center and radius
        public Circle(double x, double y, double r) {
            this.x = x;
            this.y = y;
            radius = r;
        }

        //Center coordinates are stored in array
    @Override
    public double[] center() {
            double[] center = new double[2];
            center[0] = this.x;
            center[1] = this.y;
            System.out.println("Center of the circle has coordinates: " + Arrays.toString(center));
            return new double[]{center[0],center[1]};

        }

       //area and circumference is calculated through radius
         @Override
         public void area() {
            double area = Math.PI * radius * radius;
            System.out.println("Area of the circle = " + area);
        }
        @Override
        public void circumference() {
            double circumference = Math.PI * radius * 2;
            System.out.println("Circumference of the circle = " + circumference);
        }


        //this method checks if the point is within area of the circle
        @Override
        public void check() {
            boolean pointcheckx = Math.abs(x0-this.x)<=radius;
            boolean pointchecky = Math.abs(x0-this.x)<=radius;
            if (pointcheckx && pointchecky) {
                System.out.println("The point is inside the shape");
            } else {
                System.out.println("The point is not inside of the shape");}
        }

    }

    static class Rectangle extends Shapes {
        public double x1;
        public double y1;
        public double width;
        public double height;

        //Rectangle is constructed using coordinates od top left corner as well as width and height
        public Rectangle(double x1, double y1, double w, double h) {
            this.x1 = x1;
            this.y1 = y1;
            width = w;
            height = h;
        }

        //center(), area() and circumference() methods uses proprties of rectangle
        @Override
        public double[] center() {
            double[] center = new double[2];
            center[0] = x1 + width / 2;
            center[1] = y1 + height / 2;
            System.out.println("Center of the rectangle has coordinates: " + Arrays.toString(center));
            return center;
        }

        @Override
        public void area(){
            double area = width * height;
            System.out.println("Area of the rectangle = " + area);
        }

        @Override
        public void circumference(){
            double circumference = (width + height) * 2;
            System.out.println("Circumference of the rectangle = " + circumference);
        }

        @Override
        public void check() {  //A point lies inside or not the rectangle if and only if it’s x-coordinate lies
            // between the x-coordinate of the given bottom-right and top-left coordinates of the rectangle and
            // y-coordinate lies between the y-coordinate of the given bottom-right and top-left coordinates
            // (https://www.geeksforgeeks.org/check-if-a-point-lies-on-or-inside-a-rectangle-set-2/)
            //We already have a top-left coordinates, but we have to find bottom right coordinates.
            double x3 = this.x1+width;
            double y3 = this.y1-height;
            boolean pointcheckx = x1 <= x0 && x0 <= x3;
            boolean pointchecky = y3 <= y0 && y0 <= y1;
            if (pointcheckx && pointchecky) {
                System.out.println("The point is inside the shape");
            } else {
                System.out.println("The point is not inside of the shape");
            }
            }




    }

    static class Triangle extends Shapes {
        private double x1;
        private double y1;
        private double x2;
        private double y2;
        private double x3;
        private double y3;

        //Triangle is constructed using coordinates of three points
        public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }

        //formulas are found here https://study.com/academy/lesson/how-to-find-the-centroid-of-a-triangle.html

        @Override
        public double[] center() {
            double[] center = new double[2];
            center[0] = (x1 + x2 + x3) / 3;
            center[1] = (y1 + y2 + y3) / 3;
            System.out.println("Center of the triangle has coordinates: " + Arrays.toString(center));
            return center;
        }

        //circumference is calculated by finding three lines of triangle
        @Override
        public void circumference(){
            double l1 = Math.sqrt(Math.pow(Math.abs(x2-x1),2)+Math.pow(Math.abs(y2-y1),2));
            double l2 = Math.sqrt(Math.pow(Math.abs(x3-x2),2)+Math.pow(Math.abs(y3-y2),2));
            double l3 = Math.sqrt(Math.pow(Math.abs(x1-x3),2)+Math.pow(Math.abs(y1-y3),2));
            double circumference = l1+ l2+ l3;
            System.out.println("Circumference of the triangle is: " + circumference);
        }

        //formula for are was found here https://www.geeksforgeeks.org/check-whether-a-given-point-lies-inside-a-triangle-or-not/
        //it is also possible to calculate with semi perimeter
        @Override
        public void area(){
            double area = Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
            System.out.println("Area of the triangle is: " + area);

        }

        /*point is checked by calculating areas of three triangles that the point and points of triangle compares.
        If sum of these areas is equal to area of triangle, then it is within the triangle.*/
        @Override
        public void check() {
            double area = Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
            double area1 = Math.abs((x0 * (y2 - y3) + x2 * (y3 - y0) + x3 * (y0 - y2)) / 2.0);
            double area2 = Math.abs((x1 * (y0 - y3) + x0 * (y3 - y1) + x3 * (y1 - y0)) / 2.0);
            double area3 = Math.abs((x1 * (y2 - y0) + x2 * (y0 - y1) + x0 * (y1 - y2)) / 2.0);

            boolean pointcheck = area == area1 + area2 + area3;
            if (pointcheck) {
                System.out.println("The point is inside the shape");
            } else {
                System.out.println("The point is not inside of the shape");}
        }



    }




}
