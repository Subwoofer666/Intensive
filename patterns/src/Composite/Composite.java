package Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite {
    public static void main(String[] args) {
        Shape square1 = new Square();
        Shape square2 = new Square();

        Shape triangle = new Triangle();
        Shape circle = new Circle();

        Compositee composite1 = new Compositee();
        Compositee composite2 = new Compositee();
        Compositee composite3 = new Compositee();

        composite1.addComponent(square1);
        composite1.addComponent(square2);

        composite2.addComponent(triangle);
        composite2.addComponent(circle);

        composite3.addComponent(composite1);
        composite3.addComponent(composite2);

        composite3.drew();
    }
}

interface Shape {
    public void drew();
}
class Square implements Shape {
    public void drew() {
        System.out.println("Квадрат");
    }
}
class Triangle implements Shape {
    public void drew() {
        System.out.println("Треугольник");
    }
}
class Circle implements Shape {
    public void drew() {
        System.out.println("Круг");
    }
}

class Compositee implements Shape {
    private List<Shape> components = new ArrayList<>();
    public void addComponent(Shape s){
        components.add(s);
    }
    public void removeComponent(Shape s){
        components.remove(s);
    }
    public void drew() {
        for ( Shape component : components) {
            component.drew();
        }
    }
}