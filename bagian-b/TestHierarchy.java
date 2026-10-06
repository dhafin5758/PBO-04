public class TestHierarchy {
    public static void main(String[] args) {
        System.out.println("== Step 10: Shape ==");
        Shape s1 = new Shape();
        Shape s2 = new Shape("red", false);
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("\n== Step 11: Circle ==");
        Circle c1 = new Circle();
        Circle c2 = new Circle(2.0);
        Circle c3 = new Circle(3.0, "blue", false);
        for (Circle c : new Circle[] {c1, c2, c3}) {
            System.out.println(c);
            System.out.println("  area=" + c.getArea() + ", perimeter=" + c.getPerimeter()
                    + ", color=" + c.getColor() + ", filled=" + c.isFilled());
        }

        System.out.println("\n== Step 12: Rectangle ==");
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(3.0, 4.0);
        Rectangle r3 = new Rectangle(2.0, 5.0, "yellow", false);
        for (Rectangle r : new Rectangle[] {r1, r2, r3}) {
            System.out.println(r);
            System.out.println("  area=" + r.getArea() + ", perimeter=" + r.getPerimeter());
        }
    }
}
