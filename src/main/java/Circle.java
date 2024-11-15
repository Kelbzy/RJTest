import java.util.List;

/**
 * Circle 类表示一个圆形，具有中心点和半径属性。
 *
 * @author 李磊
 * @version 1.0
 * @date 2024/11/14
 */
public class Circle {
    /**
     * 圆形的中心点，使用 Vertex 类表示。
     */
    private Vertex center;

    /**
     * 圆形的半径。
     */
    private double radius;

    /**
     * 构造函数，用于创建 Circle 对象。
     *
     * @param center 圆形的中心点，不能为 null
     * @param radius 圆形的半径，必须为非负数
     * @throws IllegalArgumentException 如果 center 为 null 或 radius 为负数
     */
    public Circle(Vertex center, double radius) {
        if (center == null) {
            throw new IllegalArgumentException("Center cannot be null");
        }
        if (radius < 0) {
            throw new IllegalArgumentException("Radius must be non-negative");
        }
        this.center = center;
        this.radius = radius;
    }

    /**
     * 绘制圆形的方法。
     * <p>
     * 此方法目前仅打印一条消息表示正在绘制圆形，实际的绘制逻辑需要额外的实现。
     * </p>
     */
    public void drawCircle() {
        System.out.println("画一个圆形");
        // 实际的绘制逻辑应该在这里实现
    }

    /**
     * 计算圆形的面积。
     *
     * @return 圆形的面积，类型为 double
     * @see Math#PI
     */
    public double areaCircle() {
        return Math.PI * radius * radius;
    }

}