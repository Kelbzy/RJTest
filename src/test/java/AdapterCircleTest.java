import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdapterCircleTest {

    @Test
    void testAdapterCircle() {
        Vertex center = new Vertex(0, 0);
        Circle circle = new Circle(center, 5);
        AdapterCircle adapterCircle = new AdapterCircle(circle);

        // Test that AdapterCircle correctly calls Circle's methods
        assertDoesNotThrow(() -> adapterCircle.draw());
        assertTrue(adapterCircle.canForm()); // Circle can always form (it doesn't need vertices)
        assertEquals(circle.areaCircle(), adapterCircle.calcArea(), 1e-9);
    }

    @Test
    void testAdapterCircleWithNull() {
        assertThrows(NullPointerException.class, () -> new AdapterCircle(null));
    }
}
