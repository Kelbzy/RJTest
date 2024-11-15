import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void testCircleCreationWithValidParameters() {
        Vertex center = new Vertex(0, 0);
        Circle circle = new Circle(center, 5);
        assertNotNull(circle);
    }

    @Test
    void testCircleCreationWithInvalidCenter() {
        assertThrows(IllegalArgumentException.class, () -> new Circle(null, 5));
    }

    @Test
    void testCircleCreationWithInvalidRadius() {
        Vertex center = new Vertex(0, 0);
        assertThrows(IllegalArgumentException.class, () -> new Circle(center, -1));
    }

    @Test
    void testAreaCalculation() {
        Vertex center = new Vertex(0, 0);
        Circle circle = new Circle(center, 5);
        assertEquals(Math.PI * 25, circle.areaCircle(), 1e-9);
    }

    @Test
    void testDrawCircle() {
        // This test just ensures no exceptions are thrown
        Vertex center = new Vertex(0, 0);
        Circle circle = new Circle(center, 5);
        circle.drawCircle(); // Manual inspection: ensures method works
    }
}
