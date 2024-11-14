import java.util.List;

public class Circle  {
    private Vertex center;
    private double radius;

    public Circle(Vertex center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public void drawCircle() {
        System.out.println("画一个圆形");
        // 绘制圆形的逻辑
    }

    public double areaCircle() {
        return Math.PI * radius * radius;
    }


}