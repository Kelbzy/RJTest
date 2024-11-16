import java.util.List;


/**
 * Polygon 接口定义了多边形的基本操作。
 *
 * @author 李磊
 * @version 1.0
 * @since 2024/11/14
 */
public interface Polygon {
    /**
     * 绘制多边形的方法。
     * <p>
     * 该方法应负责将多边形的图形表示绘制到某种输出设备上，例如屏幕或打印机。
     * 具体的绘制逻辑由实现该接口的类提供。
     * </p>
     */
    void draw();

    /**
     * 检查是否可以形成多边形的方法。
     * <p>
     * 该方法用于验证当前多边形的顶点或边是否满足形成有效多边形的条件。
     * 具体的验证逻辑由实现该接口的类提供。
     * </p>
     *
     * @return 如果可以形成多边形，则返回 {@code true}；否则返回 {@code false}。
     */
    boolean canForm();

    /**
     * 计算多边形面积的方法。
     * <p>
     * 该方法应返回多边形的面积，面积的计算方式取决于多边形的类型和顶点坐标。
     * 具体的计算逻辑由实现该接口的类提供。
     * </p>
     *
     * @return 多边形的面积，类型为 {@code double}。
     */
    double calcArea();
}