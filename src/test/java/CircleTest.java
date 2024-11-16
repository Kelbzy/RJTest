import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * 测试 Circle 类的单元测试。
 * <p>
 * 该类包含对 Circle 的构造函数和方法的测试，确保圆形对象能够正确创建并计算面积。
 * </p>
 */
class CircleTest {

    /**
     * 测试使用有效参数创建 Circle 对象。
     * <p>
     * 此测试验证当提供合法的中心点和半径时，Circle 对象能够成功创建，并且不应为 null。
     * </p>
     */
    @Test
    void testCircleCreationWithValidParameters() {
        Vertex center = new Vertex(0, 0);
        Circle circle = new Circle(center, 5);
        assertNotNull(circle);
    }

    /**
     * 测试使用无效中心点创建 Circle 对象。
     * <p>
     * 此测试验证如果尝试使用 null 作为中心点来创建 Circle 实例，则应抛出 IllegalArgumentException 异常。
     * </p>
     */
    @Test
    void testCircleCreationWithInvalidCenter() {
        assertThrows(IllegalArgumentException.class, () -> new Circle(null, 5));
    }

    /**
     * 测试使用无效半径创建 Circle 对象。
     * <p>
     * 此测试验证如果尝试使用负值作为半径来创建 Circle 实例，则应抛出 IllegalArgumentException 异常。
     * </p>
     */
    @Test
    void testCircleCreationWithInvalidRadius() {
        Vertex center = new Vertex(0, 0);
        assertThrows(IllegalArgumentException.class, () -> new Circle(center, -1));
    }

    /**
     * 测试圆形面积计算方法。
     * <p>
     * 此测试验证在给定半径为 5 的情况下，areaCircle 方法返回正确的面积值，即 π × 半径²（25）。
     * </p>
     */
    @Test
    void testAreaCalculation() {
        Vertex center = new Vertex(0, 0);
        Circle circle = new Circle(center, 5);
        assertEquals(Math.PI * 25, circle.areaCircle(), 1e-9);
    }

    /**
     * 测试绘制圆形的方法。
     *
     * <p>
     * 此测试确保 drawCircle 方法不会抛出异常。由于该方法目前仅打印消息，因此可以手动检查输出以确认其工作正常。
     *</p>
     */
    @Test
    void testDrawCircle() {
        // This test just ensures no exceptions are thrown
        Vertex center = new Vertex(0, 0);
        Circle circle = new Circle(center, 5);
        circle.drawCircle(); // Manual inspection: ensures method works
    }
}
