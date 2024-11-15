import java.util.List;

/**
 * AdapterCircle 类是一个适配器类，它将 Circle 类适配到 Polygon 接口。
 * 使得 Circle 类可以通过 Polygon 接口进行操作。
 *
 * @author 李磊
 * @version 1.0
 * @date 2024/11/14
 */
public class AdapterCircle implements Polygon {
    /**
     * 被适配的 Circle 对象。
     */
    private Circle circle;

    /**
     * 构造函数，接受一个 Circle 对象作为参数。
     *
     * @param circle 要适配的 Circle 对象
     */
    public AdapterCircle(Circle circle) {
        this.circle = circle;
    }

    /**
     * 实现 Polygon 接口中的 draw 方法。
     * 调用 Circle 对象的 drawCircle 方法来绘制圆形。
     */
    @Override
    public void draw() {
        circle.drawCircle();
    }

    /**
     * 实现 Polygon 接口中的 canForm 方法。
     * 由于圆形不需要顶点列表来判断是否可以构成，因此总是返回 true。
     *
     * @return 始终返回 true
     */
    @Override
    public boolean canForm() {
        // 圆形不由顶点列表构成，因此总是返回 true
        return true;
    }

    /**
     * 实现 Polygon 接口中的 calcArea 方法。
     * 计算并返回圆形的面积。
     *
     * @return 计算得到的圆形面积
     */
    @Override
    public double calcArea() {
        return circle.areaCircle();
    }
}