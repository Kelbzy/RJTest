import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试 Rectangle 类的单元测试。
 * <p>
 * 该类包含对 Rectangle 对象创建、验证顶点有效性以及计算面积的方法的测试。
 * </p>
 */
class RectangleTest {

    /**
     * 测试使用有效顶点创建 Rectangle 对象。
     * <p>
     * 此测试验证当提供合法的四个顶点时，Rectangle 对象能够成功创建，并且不应为 null。
     * </p>
     */
    @Test
    void testRectangleCreation() {
        Vertex topLeft = new Vertex(0, 0);
        Vertex topRight = new Vertex(4, 0);
        Vertex bottomLeft = new Vertex(0, 3);
        Vertex bottomRight = new Vertex(4, 3);

        Rectangle rectangle = new Rectangle(topLeft, topRight, bottomLeft, bottomRight);
        assertNotNull(rectangle);
    }

    /**
     * 测试无效顶点组合是否导致无法形成矩形。
     * <p>
     * 此测试验证如果提供的四个顶点不能形成一个有效的矩形（例如右下角顶点不在正确的位置），
     * 则应抛出 IllegalStateException 异常。
     * </p>
     */
    @Test
    void testInvalidRectangleVertices() {
        Vertex topLeft = new Vertex(0, 0);
        Vertex topRight = new Vertex(4, 0);
        Vertex bottomLeft = new Vertex(0, 3);
        Vertex bottomRight = new Vertex(5, 3);
//        Rectangle rectangle = new Rectangle(topLeft, topRight, bottomLeft, bottomRight);

        assertThrows(IllegalStateException.class, () -> {
            new Rectangle(topLeft, topRight, bottomLeft, bottomRight);
        });
//        assertThrows(IllegalStateException.class, rectangle::canForm);
    }

    /**
     * 测试矩形面积计算方法。
     * <p>
     * 此测试验证给定四个顶点所定义的矩形能够正确计算其面积，
     * 并确保 calcArea 方法返回值等于长方形面积（宽 × 高）。
     * 在此示例中，期望面积为 12.0（宽度为 4，高度为 3）。
     * </p>
     */
    @Test
    void testRectangleArea() {
        Vertex topLeft = new Vertex(0, 0);
        Vertex topRight = new Vertex(4, 0);
        Vertex bottomLeft = new Vertex(0, 3);
        Vertex bottomRight = new Vertex(4, 3);

        Rectangle rectangle = new Rectangle(topLeft, topRight, bottomLeft, bottomRight);

        // Verify that the calculated area matches the expected value
        assertEquals(12.0, rectangle.calcArea(), 1e-9); // Allowing for floating-point precision issues
    }
}
