import java.util.Arrays;

abstract public class Shapes {  //This part till  public static void main(String[] args) is not ready 

    public double[] center(){
        return new double[0];
    }
    public void area(){
        System.out.println("area is ...");
    }
    public void circumference(){
        System.out.println("Circumference is ...");
    }


    public static void main(String[] args) {
        Circle circle = new Circle(3.3,4.3,5.0);
        circle.center();
        circle.area();
        circle.circumference();

        Rectangle rectangle = new Rectangle(5.0, 10.0, 20.0, 30.0);
        rectangle.center();
        rectangle.area();
        rectangle.circumference();

        Triangle triangle = new Triangle (2.2, 3.2, 2.0, 6.9,7.0,4.8);
        triangle.center();
        triangle.area();
        triangle.circumference();

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

        public double[] center(){
            double[] center = new double[2];
            center[0] = x;
            center[1] = y;
            System.out.println("Center of the circle has coordinates: " + Arrays.toString(center));
            return center;

        }

        public void area(){
            double area = Math.PI * radius * radius;
            System.out.println("Area of the circle = " + area);
        }

        public void circumference(){
            double circumference = Math.PI * radius * 2;
            System.out.println("Circumference of the circle = " + circumference);
        }

    }

    static class Rectangle extends Shapes {
        public double x;
        public double y;
        public double width;
        public double height;


        public Rectangle(double x, double y, double w, double h) {
            this.x = x;
            this.y = y;
            width = w;
            height = h;
        }

        public double[] center() {
            double[] center = new double[2];
            center[0] = x + width / 2;   //need to check is these formulas are legit
            center[1] = y + height / 2;
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

    }

    static class Triangle extends Shapes {
        public double x1;
        public double y1;
        public double x2;
        public double y2;
        public double x3;
        public double y3;

        double l1;   //These are three sides of the triangle
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
            l1 = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
            l2 = Math.sqrt(Math.pow(x3-x2,2)+Math.pow(y3-y2,2));
            l3 = Math.sqrt(Math.pow(x1-x3,2)+Math.pow(y1-y3,2));
            double circumference = l1+ l2+ l3;
            System.out.println("Circumference of the triangle is: " + circumference);
        }

        public void area(){
            double s = (l1 + l2 + l3)/2; //semi perimeter
            double area =  Math.sqrt(s*(s-l1)*(s-l2)*(s-l3));
            System.out.println("Area of the triangle is: " + area);
        }



    }



}
