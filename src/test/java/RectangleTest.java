import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void testRectangleCreation() {
        Vertex topLeft = new Vertex(0, 0);
        Vertex topRight = new Vertex(4, 0);
        Vertex bottomLeft = new Vertex(0, 3);
        Vertex bottomRight = new Vertex(4, 3);

        Rectangle rectangle = new Rectangle(topLeft, topRight, bottomLeft, bottomRight);
        assertNotNull(rectangle);
    }

    @Test
    void testInvalidRectangleVertices() {
        Vertex topLeft = new Vertex(0, 0);
        Vertex topRight = new Vertex(4, 0);
        Vertex bottomLeft = new Vertex(0, 3);
        Vertex bottomRight = new Vertex(5, 3); // Invalid right corner
        Rectangle rectangle = new Rectangle(topLeft, topRight, bottomLeft, bottomRight);
        assertThrows(IllegalStateException.class, rectangle::canForm);
    }

    @Test
    void testRectangleArea() {
        Vertex topLeft = new Vertex(0, 0);
        Vertex topRight = new Vertex(4, 0);
        Vertex bottomLeft = new Vertex(0, 3);
        Vertex bottomRight = new Vertex(4, 3);

        Rectangle rectangle = new Rectangle(topLeft, topRight, bottomLeft, bottomRight);
        assertEquals(12.0, rectangle.calcArea(), 1e-9);
    }
}
