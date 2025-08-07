package OOP1.OOP_Demo.Circle;

public class circleMain {
    public static void main(String[] args) {
        Circle f1 = new Circle();
        f1.input();
        double a = f1.getArea();
        double b = f1.getPerimeter();
        f1.output();
        System.out.println("Chu vi = " + b);
        System.out.println("dien tich = " + a);
    }
}
