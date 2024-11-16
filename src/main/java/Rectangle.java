import java.util.List;


/**
 * 矩形类，实现了Polygon接口，用于表示和操作矩形。
 *
 * @author 李磊
 * @version 1.0
 * @since 2024/11/14
 */
public class Rectangle implements Polygon {
    /**
     * 矩形的左上角顶点。
     */
    private Vertex topLeft;
    /**
     * 矩形的右上角顶点。
     */
    private Vertex topRight;
    /**
     * 矩形的左下角顶点。
     */
    private Vertex bottomLeft;
    /**
     * 矩形的右下角顶点。
     */
    private Vertex bottomRight;

    /**
     * 构造一个矩形，使用四个顶点来定义。
     *
     * @param topLeft     矩形的左上角顶点
     * @param topRight    矩形的右上角顶点
     * @param bottomLeft  矩形的左下角顶点
     * @param bottomRight 矩形的右下角顶点
     */
    public Rectangle(Vertex topLeft, Vertex topRight, Vertex bottomLeft, Vertex bottomRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;

        // 检查顶点是否能形成有效的矩形
        if (!canForm()) {
            throw new IllegalStateException("给定的顶点无法构成一个有效的矩形");
        }
    }



    /**
     * 绘制矩形的方法。
     *
     * <p>该方法仅打印一条消息表示矩形被绘制，实际的绘制逻辑需要由子类或实现类提供。</p>
     */

    @Override
    public void draw() {
        System.out.println("画一个矩形");
        // 绘制矩形的逻辑
    }

    /**
     * 一个非常小的数，用于处理浮点数比较中的精度问题。
     */
    private static final double EPSILON = 1e-9;

    /**
     * 检查给定的顶点是否能构成一个有效的矩形。
     *
     * <p>该方法验证四个顶点是否能构成一个矩形，通过检查对边是否等长以及可选地检查对角线是否相等。</p>
     *
     * @return 如果顶点能构成一个有效的矩形，则返回true；否则返回false。
     * @throws IllegalStateException 如果任何一个顶点为null，则抛出此异常。
     */
    @Override
    public boolean canForm() {
        // 检查顶点是否为null，以避免在后续计算中抛出NullPointerException
        if (topLeft == null || topRight == null || bottomLeft == null || bottomRight == null) {
            throw new IllegalStateException("顶点不能为空");
        }

        // 计算各边的长度
        double topSideLength = topLeft.calcDistance(topRight);
        double bottomSideLength = bottomLeft.calcDistance(bottomRight);
        double leftSideLength = topLeft.calcDistance(bottomLeft);
        double rightSideLength = topRight.calcDistance(bottomRight);

        // 检查对边是否等长
        return Math.abs(topSideLength - bottomSideLength) < EPSILON &&
                Math.abs(leftSideLength - rightSideLength) < EPSILON &&
                // 可选：检查对角线是否相等（增加验证的严格性，但可能不是必需的）
                Math.abs(topLeft.calcDistance(bottomRight) - topRight.calcDistance(bottomLeft)) < EPSILON;

    }

    /**
     * 计算矩形的面积。
     *
     * <p>该方法使用矩形的顶点来计算面积，通过计算宽度和高度的乘积得到。</p>
     *
     * @return 矩形的面积。
     */
    @Override
    public double calcArea() {
        // 使用顶点计算矩形面积（或者可以直接使用宽高计算，如果提供了宽高构造函数）
        double width = topRight.calcDistance(topLeft);
        double height = bottomLeft.calcDistance(topLeft);
        return width * height;
    }


}