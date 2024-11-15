import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ShapeTest {

    @Test
    public void testCircleArea() {
        Vertex center = new Vertex(0, 0);
        Circle circle = new Circle(center, 2);
        assertEquals(12.566370614359172, circle.areaCircle(), 0.0001);
    }

    @Test
    public void testRectangleArea() {
        Vertex topLeft = new Vertex(0, 0);
        Vertex topRight = new Vertex(4, 0);
        Vertex bottomLeft = new Vertex(0, 3);
        Vertex bottomRight = new Vertex(4, 3);
        Rectangle rectangle = new Rectangle(topLeft, topRight, bottomLeft, bottomRight);
        assertEquals(12.0, rectangle.calcArea(), 0.0001);
    }

    @Test
    public void testTriangleArea() {
        Vertex v1 = new Vertex(0, 0);
        Vertex v2 = new Vertex(4, 0);
        Vertex v3 = new Vertex(0, 3);
        List<Vertex> vertices = Arrays.asList(v1, v2, v3);
        Triangle triangle = new Triangle(vertices);
        assertEquals(6.0, triangle.calcArea(), 0.0001);
    }

    @Test
    public void testRectangleCanForm() {
        Vertex v1 = new Vertex(0, 0);
        Vertex v2 = new Vertex(4, 0);
        Vertex v3 = new Vertex(4, 3);
        Vertex v4 = new Vertex(0, 3);
        Rectangle rectangle = new Rectangle(v1, v2, v3, v4);
        assertTrue(rectangle.canForm());
    }

    @Test
    public void testTriangleCanForm() {
        Vertex v1 = new Vertex(0, 0);
        Vertex v2 = new Vertex(4, 0);
        Vertex v3 = new Vertex(4, 3);
        Triangle triangle = new Triangle(Arrays.asList(v1, v2, v3));
        assertTrue(triangle.canForm());
    }

    @Test
    public void testInvalidTriangleCanForm() {
        Vertex v1 = new Vertex(0, 0);
        Vertex v2 = new Vertex(4, 0);
        Vertex v3 = new Vertex(8, 3);
        Triangle triangle = new Triangle(Arrays.asList(v1, v2, v3));
        assertFalse(triangle.canForm());
    }

    @Test
    public void testAdapterCircleCanForm() {
        Vertex center = new Vertex(2, 2);
        Circle circle = new Circle(center, 2);
        AdapterCircle adapterCircle = new AdapterCircle(circle);
        assertTrue(adapterCircle.canForm());
    }
}