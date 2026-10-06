public class TestCircle {
    public static void main(String[] args) {
        // Step 1
        Circle c1 = new Circle();
        Circle c2 = new Circle(2.5);
        System.out.println("== Step 1 ==");
        System.out.println("c1 radius = " + c1.getRadius() + ", area = " + c1.getArea());
        System.out.println("c2 radius = " + c2.getRadius() + ", area = " + c2.getArea());
        System.out.println(c1);
        System.out.println(c2);

        // Step 2
        System.out.println("\n== Step 2 ==");
        Circle c3 = new Circle(3.0, "blue");
        System.out.println("awal    : " + c3);
        c3.setRadius(4.5);
        c3.setColor("green");
        System.out.println("sesudah : " + c3 + ", color via getter = " + c3.getColor());
    }
}
