import java.util.List;


/**
 * Triangle 类表示一个三角形，包含三个顶点。
 * 它实现了 Polygon 接口，提供了绘制、判断是否能形成三角形以及计算面积的功能。
 *
 * @author 李磊
 * @version 1.0
 * @since 2024/11/14
 */
public class Triangle implements Polygon {

    /**
     * 三角形的顶点列表，必须包含且仅包含三个顶点。
     */
    private List<Vertex> vertices;


    /**
     * 构造函数，接收一个包含三个顶点的列表。
     *
     * @param vertices 包含三个顶点的列表。如果列表为空、为null或包含的元素个数不为3，将抛出异常。
     * @throws IllegalArgumentException 如果顶点列表为空、为null或包含的元素个数不为3。
     */
    public Triangle(List<Vertex> vertices) {
        if (vertices == null || vertices.size() != 3 || vertices.contains(null)) {
            throw new IllegalArgumentException("顶点列表必须包含且仅包含三个非空顶点");
        }
        this.vertices = vertices;
    }


    /**
     * 绘制三角形的方法。
     * 具体的绘制逻辑由子类或实现类提供，这里仅打印一个提示信息。
     */
    @Override
    public void draw() {
        System.out.println("画一个三角形");
        // 绘制三角形的逻辑
    }

    /**
     * 判断给定的顶点列表是否能形成一个三角形。
     * 根据三角形不等式定理：任意两边之和大于第三边。
     *
     * @return 如果能形成三角形，则返回 true；否则返回 false。
     * @throws IllegalStateException 如果顶点列表中的顶点为空或数量不对。
     */
    @Override
    public boolean canForm() {

        // 首先检查顶点列表是否包含且仅包含三个顶点
        if (vertices == null || vertices.size() != 3) {
            throw new IllegalStateException("顶点列表必须包含且仅包含三个顶点");
        }

        Vertex v1 = vertices.get(0);
        Vertex v2 = vertices.get(1);
        Vertex v3 = vertices.get(2);

        // 检查顶点是否为null，以避免在后续计算中抛出NullPointerException
        if (v1 == null || v2 == null || v3 == null) {
            throw new IllegalStateException("顶点列表中的顶点不能为空");
        }

        double a = v1.calcDistance(v2);
        double b = v2.calcDistance(v3);
        double c = v3.calcDistance(v1);

        // 应用三角形不等式定理来判断是否能形成三角形
        return (a + b > c) && (a + c > b) && (b + c > a);

    }


    /**
     * 计算三角形的面积。
     * 使用海伦公式：面积 = sqrt(s * (s - a) * (s - b) * (s - c))，其中 s 是半周长。
     *
     * @return 三角形的面积。
     * @throws IllegalStateException 如果顶点列表中的顶点不能形成三角形。
     */
    @Override
    public double calcArea() {
        Vertex v1 = vertices.get(0);
        Vertex v2 = vertices.get(1);
        Vertex v3 = vertices.get(2);
        double a = v1.calcDistance(v2);
        double b = v2.calcDistance(v3);
        double c = v3.calcDistance(v1);
        double s = (a + b + c) / 2; // 半周长
        return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // 海伦公式计算面积
    }


}