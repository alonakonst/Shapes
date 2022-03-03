import java.awt.geom.Point2D;

class Circle extends Shapes {
    private final double x;
    private final double y;
    private final double radius;

    //Circle is constructed from a coordinates of the center and radius
    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        radius = r;
    }
    //Center coordinates
    @Override
    public Point2D.Double center() {
        return new Point2D.Double(this.x,this.y);
    }

    //area and circumference is calculated through radius
    @Override
    public double area() {
        double area = Math.PI * radius * radius;
        System.out.println("Area of the circle = " + area);
        return area;
    }
    @Override
    public double circumference() {
        double circumference = Math.PI * Math.abs(radius) * 2;
        System.out.println("Circumference of the circle = " + circumference);
        return circumference;
    }

    //this method checks if the point is within area of the circle
    @Override
    public void check(Point2D.Double point) {
        boolean pointcheckx = Math.abs(point.x-this.x)<=radius;
        boolean pointchecky = Math.abs(point.y-this.x)<=radius;
        if (pointcheckx && pointchecky) {
            System.out.println("The point is inside the shape");
        } else {
            System.out.println("The point is not inside of the shape");}
    }

}
