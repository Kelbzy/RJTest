import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

/**
 * 测试 Triangle 类的单元测试。
 * <p>
 * 该类包含对 Triangle 对象创建、有效性检查以及面积计算的测试。
 * </p>
 */
class TriangleTest {

    /**
     * 测试使用有效顶点创建 Triangle 对象。
     * <p>
     * 此测试验证当提供合法的三个顶点时，Triangle 对象能够成功创建，并且不应为 null。
     * </p>
     */
    @Test
    void testTriangleCreationWithValidVertices() {
        Vertex v1 = new Vertex(0, 0);
        Vertex v2 = new Vertex(4, 0);
        Vertex v3 = new Vertex(2, 3);
        Triangle triangle = new Triangle(Arrays.asList(v1, v2, v3));
        assertNotNull(triangle);
    }

    /**
     * 测试使用无效顶点创建 Triangle 对象。
     * <p>
     * 此测试验证如果尝试只提供两个顶点（不足以形成三角形），则应抛出 IllegalArgumentException 异常。
     * </p>
     */
    @Test
    void testTriangleCreationWithInvalidVertices() {
        assertThrows(IllegalArgumentException.class, () ->
                new Triangle(Arrays.asList(new Vertex(0, 0), new Vertex(4, 0)))
        );
    }

    /**
     * 测试可以形成三角形的情况。
     * <p>
     * 此测试验证给定三个非共线顶点时，canForm 方法返回 true，表示这些顶点可以形成一个有效的三角形。
     * </p>
     */
    @Test
    void testCanFormTriangle() {
        Vertex v1 = new Vertex(0, 0);
        Vertex v2 = new Vertex(4, 0);
        Vertex v3 = new Vertex(2, 3);
        Triangle triangle = new Triangle(Arrays.asList(v1, v2, v3));
        assertTrue(triangle.canForm());
    }

    /**
     * 测试无法形成三角形的情况。
     * <p>
     * 此测试验证给定三个共线顶点时，canForm 方法返回 false，表示这些顶点不能形成一个有效的三角形。
     * </p>
     */
    @Test
    void testCannotFormTriangle() {
        Vertex v1 = new Vertex(0, 0);
        Vertex v2 = new Vertex(4, 0);
        Vertex v3 = new Vertex(8, 0); // Collinear points, not a valid triangle
        Triangle triangle = new Triangle(Arrays.asList(v1, v2, v3));
        assertFalse(triangle.canForm());
    }

    /**
     * 测试计算三角形面积的方法。
     *
     * <p>
     * 此测试验证在给定特定三个顶点情况下，calcArea 方法返回正确的面积值，
     * 即通过公式 Area = 0.5 × base × height 来计算。对于这个例子，应返回6.0（即：面积=0.5×4×3）。
     *</p>
     */
    @Test
    void testTriangleArea() {
        Vertex v1 = new Vertex(0, 0);
        Vertex v2 = new Vertex(4, 0);
        Vertex v3 = new Vertex(2, 3);
        Triangle triangle = new Triangle(Arrays.asList(v1, v2, v3));

        double area = triangle.calcArea();
        assertEquals(6.0, area ,1e-9); // Area should be equal to expected value.
    }
}
