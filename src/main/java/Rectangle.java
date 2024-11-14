import java.util.List;

public class Rectangle implements Polygon {
    private Vertex topLeft;
    private Vertex topRight;
    private Vertex bottomLeft;
    private Vertex bottomRight;

    public Rectangle(Vertex topLeft, Vertex topRight, Vertex bottomLeft, Vertex bottomRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    // 可以提供一个使用宽高构造的构造函数作为替代或补充

    @Override
    public void draw() {
        System.out.println("画一个矩形");
        // 绘制矩形的逻辑
    }

    // 定义一个非常小的数来处理浮点数比较中的精度问题
    private static final double EPSILON = 1e-9;

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



    @Override
    public double calcArea() {
        // 使用顶点计算矩形面积（或者可以直接使用宽高计算，如果提供了宽高构造函数）
        double width = topRight.calcDistance(topLeft);
        double height = bottomLeft.calcDistance(topLeft);
        return width * height;
    }


}