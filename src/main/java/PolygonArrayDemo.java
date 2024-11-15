import java.util.ArrayList;
import java.util.List;


/**
 * PolygonArrayDemo 类演示了如何使用多边形数组来存储和打印不同类型的多边形信息。
 *
 * @author 李磊
 * @version 1.0
 * @since 2024/11/14
 */
public class PolygonArrayDemo {

    public static void main(String[] args) {
        // 创建顶点
        Vertex vertex1 = new Vertex(0, 0);
        Vertex vertex2 = new Vertex(4, 0);
        Vertex vertex3 = new Vertex(4, 3);
        Vertex vertex4 = new Vertex(0, 3);
        Vertex center = new Vertex(2, 2);

        // 创建多边形
        List<Vertex> rectangleVertices = new ArrayList<>();
        rectangleVertices.add(vertex1);
        rectangleVertices.add(vertex2);
        rectangleVertices.add(vertex3);
        rectangleVertices.add(vertex4);

        Rectangle rectangle = new Rectangle(vertex1, vertex2, vertex3, vertex4);
        Circle circle = new Circle(center, 2);
        AdapterCircle adapterCircle = new AdapterCircle(circle);

        List<Vertex> triangleVertices = new ArrayList<>();
        triangleVertices.add(new Vertex(0, 0));
        triangleVertices.add(new Vertex(4, 0));
        triangleVertices.add(new Vertex(4, 3));

        Triangle triangle = new Triangle(triangleVertices);

        // 创建多边形数组
        Polygon[] polygons = {rectangle, adapterCircle, triangle};


        // 输出多边形信息
        for (Polygon polygon : polygons) {
            System.out.println("Drawing polygon:");
            polygon.draw(); // 假设这些方法有打印语句或实际功能
            System.out.println("Can form with given vertices: " + polygon.canForm()); // 对于圆形和三角形，这个调用是演示性的
            System.out.println("Area: " + polygon.calcArea());
            System.out.println();
        }
    }
}