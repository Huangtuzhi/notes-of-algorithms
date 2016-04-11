public class Point2D
{
    private final double x;
    private final double y;

    public Point2D(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public static int ccw(Point2D a, Point2D b, Point2D c)
    {
        double area2 = (b.x - a.x)*(c.y - a.y) - (b.y - a.y)*(c.x - a.x);
        if (area2 < 0) return -1; //clockwise
        if (area2 > 0) return 1;  //counter-clockwise
        else return 0;            //collinear
    }
}

Stack<Point2D> hull = new Stack<Point2D>();

Arrays.sort(p, Point2D.Y_ORDER);
Arrays.sort(p, p[0].BY_POLAR_ORDER);

hull.push(p[0]);
hull.push(p[1]);

for (int i = 2; i < N; i++) {
    Point2D top = hull.pop();
    While(Point2D.ccw(hull.peek(), top, p[i]) <= 0)
        top = hull.pop(); //栈中弹出多个元素
    hull.push(top);
    hull.push(p[i]);
}