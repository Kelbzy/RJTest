/**
 * Vertex 类表示二维平面上的一个点，包含 x 和 y 坐标。
 * 提供了获取和设置坐标的方法，以及计算两个顶点之间距离的方法。
 *
 * @author 李磊
 * @version 1.0
 * @date 2024/11/14
 */
public class Vertex {
    /**
     * 点的 x 坐标。
     */
    private double x;

    /**
     * 点的 y 坐标。
     */
    private double y;

    /**
     * 构造函数，用于创建一个新的顶点。
     *
     * @param x 顶点的 x 坐标
     * @param y 顶点的 y 坐标
     */
    public Vertex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * 计算当前顶点与另一个顶点之间的距离。
     * 使用欧几里得距离公式：sqrt((x2 - x1)^2 + (y2 - y1)^2)。
     *
     * @param other 另一个顶点
     * @return 当前顶点与另一个顶点之间的距离
     */
    public double calcDistance(Vertex other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }


}