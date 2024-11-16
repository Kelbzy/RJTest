import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试 AdapterCircle 类的单元测试。
 * <p>
 * 该类包含对 AdapterCircle 的构造函数和方法的测试，确保适配器能够正确地调用 Circle 的相关功能。
 * </p>
 */
class AdapterCircleTest {

    /**
     * 测试 AdapterCircle 的基本功能。
     * <p>
     * 此测试创建一个 Circle 对象并使用它初始化 AdapterCircle。然后验证：
     * 1. 调用 draw 方法不会抛出异常。
     * 2. canForm 方法返回 true，因为圆形总是可以形成。
     * 3. calcArea 方法返回与 Circle 对象相同的面积值（在一定精度范围内）。
     * </p>
     */
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

    /**
     * 测试当传入 null 时，AdapterCircle 构造函数是否会抛出 NullPointerException 异常。
     *
     * <p>
     * 此测试验证如果尝试使用 null 创建一个 AdapterCircle 实例，则应抛出 NullPointerException。
     * </p>
     */
    @Test
    void testAdapterCircleWithNull() {
        assertThrows(NullPointerException.class, () -> new AdapterCircle(null));
    }
}
