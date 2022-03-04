import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testing {

    @Test
    public void myTest (){ assertEquals(1,1);}

    @Test
    void testPoint() {
       Point p = new Point();
       assertEquals(p, p, "Point x,y:" );
    }

    @Test
    void testRectangleArea() {
        Rectangle r = new Rectangle(-2, 2, 4, -4);
        r.area();
        assertEquals(16, r.area(), " Rectangle area");
    }

        @Test
        void testRectangleCircumference(){
            Rectangle r = new Rectangle(-2, 2, 4, -4);
            r.circumference();
            assertEquals(0.0, r.circumference(),"Rectangle circumference");
    }

    @Test
    void testCircleArea() {
        Circle c = new Circle(0,4,5.0);
        c.area();
        assertEquals(78.53981633974483, c.area(), "Circle area");
    }

    @Test
    void testCircleCircumference(){
        Circle c = new Circle(0,4,5.0);
        c.circumference();
        assertEquals(31.41592653589793, c.circumference(),"Circle circumference");
    }

    @Test
    void testCircleTriangle() {
        Triangle t = new Triangle (0.0, 0.0, 10.0, 10.0,20.0,0.0);
        t.area();
        assertEquals(100.0, t.area(), "Triangle area");
    }

    @Test
    void testTriangleCircumference(){
        Triangle t = new Triangle (0.0, 0.0, 10.0, 10.0,20.0,0.0);
        t.circumference();
        assertEquals(48.2842712474619, t.circumference(),"Triangle circumference");
    }
}

