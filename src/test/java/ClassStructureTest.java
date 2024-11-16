import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.Method;

/**
 * 测试类结构相关功能的单元测试。
 * <p>
 * 该类包含对各种图形类（如 Rectangle、Triangle 和 AdapterCircle）是否实现 Polygon 接口、
 * 是否继承自 Object 类，以及是否正确重写了某些方法的测试。
 * </p>
 */
public class ClassStructureTest {

    /**
     * 测试 Rectangle 类是否实现了 Polygon 接口。
     * <p>
     * 此测试验证 Rectangle.class 是否可以被视为 Polygon 的子类型。
     * </p>
     */
    @Test
    public void testRectangleImplementsPolygon() {
        assertTrue(Polygon.class.isAssignableFrom(Rectangle.class));
    }

    /**
     * 测试 Triangle 类是否实现了 Polygon 接口。
     * <p>
     * 此测试验证 Triangle.class 是否可以被视为 Polygon 的子类型。
     * </p>
     */
    @Test
    public void testTriangleImplementsPolygon() {
        assertTrue(Polygon.class.isAssignableFrom(Triangle.class));
    }

    /**
     * 测试 AdapterCircle 类是否实现了 Polygon 接口。
     * <p>
     * 此测试验证 AdapterCircle.class 是否可以被视为 Polygon 的子类型。
     * </p>
     */
    @Test
    public void testAdapterCircleImplementsPolygon() {
        assertTrue(Polygon.class.isAssignableFrom(AdapterCircle.class));
    }

    /**
     * 测试 Circle 类是否是 Object 类的子类。
     * <p>
     * 此测试验证 Circle.class 是否可以被视为 Object 的子类型，确保所有 Java 对象都具有基本特性。
     * </p>
     */
    @Test
    public void testCircleIsSubclassOfObject() {
        assertTrue(Object.class.isAssignableFrom(Circle.class));
    }

    /**
     * 测试 Rectangle 类是否重写了 draw 方法。
     *
     * <p>
     * 此测试尝试获取 Rectangle 中的 draw 方法，并检查它不是从 Object 类继承而来的，
     * 如果没有找到该方法则失败并抛出异常提示信息。
     *</p>
     */
    @Test
    public void testRectangleOverridesDrawMethod() {
        try {
            Method method = Rectangle.class.getMethod("draw");
            assertNotEquals(Object.class, method.getDeclaringClass());
        } catch (NoSuchMethodException e) {
            fail("Rectangle class should override draw method");
        }
    }

    /**
     ** 测试 Triangle 类是否重写了 draw 方法。
     *
     **<p>
     **此测试尝试获取 Triangle 中的 draw 方法，并检查它不是从 Object 类继承而来的，
     **如果没有找到该方法则失败并抛出异常提示信息。
     **</p>
     **/
    @Test
    public void testTriangleOverridesDrawMethod() {
        try {
            Method method = Triangle.class.getMethod("draw");
            assertNotEquals(Object.class, method.getDeclaringClass());
        } catch (NoSuchMethodException e) {
            fail("Triangle class should override draw method");
        }
    }

    /**
     ** 测试 AdapterCircle 类是否重写了 calcArea 方法。
     *
     **<p>
     **此测试尝试获取 AdapterCircle 中的 calcArea 方法，并检查它不是从 Object 类继承而来的，
     **如果没有找到该方法则失败并抛出异常提示信息。
     **</p>
     **/
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