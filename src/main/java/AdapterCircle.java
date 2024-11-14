import java.util.List;

public class AdapterCircle implements Polygon {
    private Circle circle;
    private double radius;


    public AdapterCircle(Circle circle) {
        this.circle = circle;
    }


    // 实现Polygon接口中定义的方法，如draw, canForm, calcArea等
    @Override
    public void draw() {
        circle.drawCircle();
    }

    @Override
    public boolean canForm() {
        // 判断是否可以构成圆形的逻辑（虽然圆形不需要顶点列表来判断，但接口要求如此）
        return true; // 圆形不由顶点列表构成，因此总是返回true
    }

    @Override
    public double calcArea() {
        return circle.areaCircle();
    }

}