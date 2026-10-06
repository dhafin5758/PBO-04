public class TestSquare {
    public static void main(String[] args) {
        // Step 14
        Square s = new Square(5.0);
        System.out.println("awal                 : " + s);
        System.out.println("area                 : " + s.getArea());
        s.setWidth(8.0);
        System.out.println("sesudah setWidth(8)  : " + s);
        System.out.println("  width=" + s.getWidth() + ", length=" + s.getLength());

        // Step 15
        s.setLength(3.0);
        System.out.println("sesudah setLength(3) : " + s);
        System.out.println("  width=" + s.getWidth() + ", length=" + s.getLength());
        System.out.println("  area=" + s.getArea() + ", perimeter=" + s.getPerimeter());
    }
}
