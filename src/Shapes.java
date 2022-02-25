//last Euclidean distance is not done, triangle area needs to be done using its vertices, triangle method check() doesn't show right result

import java.util.Arrays;
import java.util.Scanner;

abstract public class Shapes {  //This part till  public static void main(String[] args) is not ready, need more variables that are both in shapes and its child classes.
double x0;
double y0;

    public void pointX(){   //methods pointX() and point(Y) are called for each object. this is to check if the point is inside the shape. For
        //each shape it's called separately, maybe we should use one point to check all of them.
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

    //public void area(){
        //System.out.println("area is ...");
    //}
    public void circumference(){
        System.out.println("Circumference is ...");
    }  //idk if we should leave them empty her or what.
    public void check(){}


    public static void main(String[] args) {
        Circle circle = new Circle(0,0,5.0);
        circle.pointX();
        circle.pointY();
        circle.center();
        circle.area();
        circle.circumference();
        circle.check();

        Rectangle rectangle = new Rectangle(5.0, 10.0, 20.0, 30.0);
        rectangle.center();
        rectangle.area();
        rectangle.circumference();
        rectangle.pointX();
        rectangle.pointY();
        rectangle.check();

        Triangle triangle = new Triangle (0.0, 0.0, 10.0, 10.0,20.0,0.0);
        triangle.center();
        triangle.area();
        triangle.circumference();
        triangle.pointX();
        triangle.pointY();
        triangle.check();
    }


    static class Circle extends Shapes {
        public double x;
        public double y;
        public double radius;

        public Circle(double x, double y, double r) {
            this.x = x;
            this.y = y;
            radius = r;
        }

        public double[] center() { //maybe its better not to use array idk
            double[] center = new double[2];
            center[0] = x;
            center[1] = y;
            System.out.println("Center of the circle has coordinates: " + Arrays.toString(center));
            return center;

        }

        public void area() {
            double area = Math.PI * radius * radius;
            System.out.println("Area of the circle = " + area);
        }

        public void circumference() {
            double circumference = Math.PI * radius * 2;
            System.out.println("Circumference of the circle = " + circumference);
        }


        public void check() {
            boolean pointcheckx = Math.abs(x0-x)<=radius;
            boolean pointchecky = Math.abs(x0-x)<=radius;
            if (pointcheckx && pointchecky) {
                System.out.println("The point is inside the shape");
            } else {
                System.out.println("The point is not inside of the shape");
            }
        }


    }

    static class Rectangle extends Shapes {
        public double x1;
        public double y1;
        public double width;
        public double height;

        public Rectangle(double x1, double y1, double w, double h) {
            this.x1 = x1;
            this.y1 = y1;
            width = w;
            height = h;
        }

        public double[] center() {
            double[] center = new double[2];
            center[0] = x1 + width / 2;
            center[1] = y1 + height / 2;
            System.out.println("Center of the rectangle has coordinates: " + Arrays.toString(center));
            return center;
        }

        public void area(){
            double area = width * height;
            System.out.println("Area of the rectangle = " + area);
        }

        public void circumference(){
            double circumference = (width + height) * 2;
            System.out.println("Circumference of the rectangle = " + circumference);
        }

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
        public double x1;
        public double y1;
        public double x2;
        public double y2;
        public double x3;
        public double y3;

        double l1;   //These are three sides of the triangle, //there were used before for area as well
        double l2;
        double l3;

        public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }

        public double[] center() {
            double[] center = new double[2];
            center[0] = (x1 + x2 + x3) / 3;
            center[1] = (y1 + y2 + y3) / 3;
            System.out.println("Center of the triangle has coordinates: " + Arrays.toString(center));
            return center;
        }

        public void circumference(){
            double l1 = Math.sqrt(Math.pow(Math.abs(x2-x1),2)+Math.pow(Math.abs(y2-y1),2));
            double l2 = Math.sqrt(Math.pow(Math.abs(x3-x2),2)+Math.pow(Math.abs(y3-y2),2));
            double l3 = Math.sqrt(Math.pow(Math.abs(x1-x3),2)+Math.pow(Math.abs(y1-y3),2));
            double circumference = l1+ l2+ l3;
            System.out.println("Circumference of the triangle is: " + circumference);
        }

        public void area(){  //i think we should use vertices
            double area = (x1*(Math.abs(y2-y3)) + x2*(Math.abs(y3 -y1)) + x3*(Math.abs(y1-y2)))/2;
            System.out.println("Area of the triangle is: " + area);
        }

        public void check(){  //this way of doing is wrong (i think) , idk how to do check for triangle
                double area = (x1*(Math.abs(y2-y3)) + x2*(Math.abs(y3 -y1)) + x3*(Math.abs(y1-y2)))/2;
                double area1 = (x1*(Math.abs(y2-y0)) + x2*(Math.abs(y0 -y1)) + x0*(Math.abs(y1-y2)))/2;
                double area2 = (x1*(Math.abs(y0-y3)) + x0*(Math.abs(y3 -y1)) + x3*(Math.abs(y1-y0)))/2;
                double area3 = (x0*(Math.abs(y2-y3)) + x2*(Math.abs(y3 -y0)) + x3*(Math.abs(y0-y2)))/2;

                System.out.println(area1 + area2 + area3);
                System.out.println("Area is:" + area);
                boolean pointcheck = area == area1+ area2+ area3 ;
                if (pointcheck) {
                    System.out.println("The point is inside the shape");
                } else {
                    System.out.println("The point is not inside of the shape");
                }
            }
        }




}
