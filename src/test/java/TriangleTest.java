import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class TriangleTest {

    @Test
    void testTriangleCreationWithValidVertices() {
        Vertex v1 = new Vertex(0, 0);
        Vertex v2 = new Vertex(4, 0);
        Vertex v3 = new Vertex(2, 3);
        Triangle triangle = new Triangle(Arrays.asList(v1, v2, v3));
        assertNotNull(triangle);
    }

    @Test
    void testTriangleCreationWithInvalidVertices() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(Arrays.asList(new Vertex(0, 0), new Vertex(4, 0))));
    }

    @Test
    void testCanFormTriangle() {
        Vertex v1 = new Vertex(0, 0);
        Vertex v2 = new Vertex(4, 0);
        Vertex v3 = new Vertex(2, 3);
        Triangle triangle = new Triangle(Arrays.asList(v1, v2, v3));
        assertTrue(triangle.canForm());
    }

    @Test
    void testCannotFormTriangle() {
        Vertex v1 = new Vertex(0, 0);
        Vertex v2 = new Vertex(4, 0);
        Vertex v3 = new Vertex(8, 0); // Collinear points, not a valid triangle
        Triangle triangle = new Triangle(Arrays.asList(v1, v2, v3));
        assertFalse(triangle.canForm());
    }

    @Test
    void testTriangleArea() {
        Vertex v1 = new Vertex(0, 0);
        Vertex v2 = new Vertex(4, 0);
        Vertex v3 = new Vertex(2, 3);
        Triangle triangle = new Triangle(Arrays.asList(v1, v2, v3));
        double area = triangle.calcArea();
        assertEquals(6.0, area, 1e-9); // Area = 0.5 * base * height = 0.5 * 4 * 3
    }
}
