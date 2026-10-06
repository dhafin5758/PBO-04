public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super();
        height = 1.0;
    }

    public Cylinder(double height) {
        super();
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Step 8: getArea() di-override menjadi luas permukaan silinder
    @Override
    public double getArea() {
        return 2 * Math.PI * getRadius() * height
                + 2 * Math.PI * getRadius() * getRadius();
    }

    // Step 8: super.getArea() secara eksplisit meminta luas alas milik Circle
    public double getVolume() {
        return super.getArea() * height;
    }

    // Step 9
    @Override
    public String toString() {
        return "Cylinder: subclass of " + super.toString()
                + ", height=" + height;
    }
}
