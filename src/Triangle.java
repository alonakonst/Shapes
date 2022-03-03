import java.awt.geom.Point2D;
class Triangle extends Shapes {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final double x3;
    private final double y3;

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
    public Point2D.Double center() {
        double x = (x1 + x2 + x3) / 3;
        double y = (y1 + y2 + y3) / 3;
        return new Point2D.Double(x,y);
    }

    //circumference is calculated by finding three lines of triangle
    @Override
    public double circumference(){
        double l1 = Math.sqrt(Math.pow(Math.abs(x2-x1),2)+Math.pow(Math.abs(y2-y1),2));
        double l2 = Math.sqrt(Math.pow(Math.abs(x3-x2),2)+Math.pow(Math.abs(y3-y2),2));
        double l3 = Math.sqrt(Math.pow(Math.abs(x1-x3),2)+Math.pow(Math.abs(y1-y3),2));
        double circumference = l1+ l2+ l3;
        System.out.println("Circumference of the triangle is: " + circumference);
        return circumference;
    }

    //formula for are was found here https://www.geeksforgeeks.org/check-whether-a-given-point-lies-inside-a-triangle-or-not/
    //it is also possible to calculate with semi perimeter
    @Override
    public double area(){
        double area = Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
        System.out.println("Area of the triangle is: " + area);
        return area;
    }

    /*point is checked by calculating areas of three triangles that the point and points of triangle compares.
    If sum of these areas is equal to area of triangle, then it is within the triangle.*/
    @Override
    public void check(Point2D.Double point) {
        double area1 = Math.abs((point.x * (y2 - y3) + x2 * (y3 - point.y) + x3 * (point.y - y2)) / 2.0);
        double area2 = Math.abs((x1 * (point.y - y3) + point.x * (y3 - y1) + x3 * (y1 - point.y)) / 2.0);
        double area3 = Math.abs((x1 * (y2 - point.y) + x2 * (point.y - y1) + point.x * (y1 - y2)) / 2.0);
        boolean pointCheck = area() == area1 + area2 + area3;
        if (pointCheck) {
            System.out.println("The point is inside the shape");
        } else {
            System.out.println("The point is not inside of the shape");}
    }

}
