import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.Method;

public class ClassStructureTest {

    @Test
    public void testRectangleImplementsPolygon() {
        assertTrue(Polygon.class.isAssignableFrom(Rectangle.class));
    }

    @Test
    public void testTriangleImplementsPolygon() {
        assertTrue(Polygon.class.isAssignableFrom(Triangle.class));
    }

    @Test
    public void testAdapterCircleImplementsPolygon() {
        assertTrue(Polygon.class.isAssignableFrom(AdapterCircle.class));
    }

    @Test
    public void testCircleIsSubclassOfObject() {
        assertTrue(Object.class.isAssignableFrom(Circle.class));
    }

    @Test
    public void testRectangleOverridesDrawMethod() {
        try {
            Method method = Rectangle.class.getMethod("draw");
            assertNotEquals(Object.class, method.getDeclaringClass());
        } catch (NoSuchMethodException e) {
            fail("Rectangle class should override draw method");
        }
    }

    @Test
    public void testTriangleOverridesDrawMethod() {
        try {
            Method method = Triangle.class.getMethod("draw");
            assertNotEquals(Object.class, method.getDeclaringClass());
        } catch (NoSuchMethodException e) {
            fail("Triangle class should override draw method");
        }
    }

    @Test
    public void testAdapterCircleOverridesCalcAreaMethod() {
        try {
            Method method = AdapterCircle.class.getMethod("calcArea");
            assertNotEquals(Object.class, method.getDeclaringClass());
        } catch (NoSuchMethodException e) {
            fail("AdapterCircle class should override calcArea method");
        }
    }
}
