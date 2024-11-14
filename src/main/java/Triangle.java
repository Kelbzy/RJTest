import java.util.List;

public class Triangle implements Polygon {
    private List<Vertex> vertices;

    public Triangle(List<Vertex> vertices) {
        this.vertices = vertices;
    }



    @Override
    public void draw() {
        System.out.println("画一个三角形");
        // 绘制三角形的逻辑
    }

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