import java.awt.geom.Point2D;

class Rectangle extends Shapes {
    private final double x1;
    private final double y1;
    private final double width;
    private final double height;

    //Rectangle is constructed using coordinates od top left corner as well as width and height
    public Rectangle(double x1, double y1, double w, double h) {
        this.x1 = x1;
        this.y1 = y1;
        width = w;
        height = h;
    }

    //center(), area() and circumference() methods uses properties of rectangle
    @Override
    public Point2D.Double center() {
        double x = this.x1 + width / 2;
        double y = this.y1 + height / 2;
        return new Point2D.Double(x,y);
    }

    @Override
    public double area(){
        double area = Math.abs(width * height);
        return area;
    }

    //taking absolute value for both width and height to calculate a circumference
    @Override
    public double circumference(){
        double circumference = (Math.abs(width) + Math.abs(height)) * 2;
        return circumference;
    }

    @Override
    public void check(Point2D.Double point) {  //A point lies inside or not the rectangle if and only if it’s x-coordinate lies
        // between the x-coordinate of the given bottom-right and top-left coordinates of the rectangle and
        // y-coordinate lies between the y-coordinate of the given bottom-right and top-left coordinates
        // (https://www.geeksforgeeks.org/check-if-a-point-lies-on-or-inside-a-rectangle-set-2/)
        //We already have a top-left coordinates, but we have to find bottom right coordinates.
        double x3 = this.x1+width;
        double y3 = this.y1-height;
        boolean pointcheckx = x1 <= point.x && point.x <= x3;
        boolean pointchecky = y3 <= point.x && point.y <= y1;
        if (pointcheckx && pointchecky) {
            System.out.println("The point is inside the rectangle");
        } else {
            System.out.println("The point is not inside of the rectangle");}
    }

}
