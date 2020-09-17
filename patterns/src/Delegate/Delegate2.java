package Delegate;

public class Delegate2 {
    public static void main(String[] args) {
        Painter painter = new Painter();
        painter.setGraphics(new Circle());
        painter.drow();

        painter.setGraphics(new Triangle());
        painter.drow();
    }
}
interface Graphics {
    void drow();
}

class Triangle implements Graphics {
    @Override
    public void drow() {
        System.out.println("Рисуем треугольник");
    }
}
class Square implements Graphics {
    @Override
    public void drow() {
        System.out.println("Рисуем квадрат");
    }
}
class Circle implements Graphics {
    @Override
    public void drow() {
        System.out.println("Рисуем круг");
    }
}
class Painter {  //Painter делегирует рисование фигуры конкретным экземплярам классов
    Graphics graphics;  //мы можем добавлять новые реализации графики не изменяя класс Painter
    void setGraphics(Graphics g) {
        graphics = g;
    }
    void drow() {
        graphics.drow();
    }
}
