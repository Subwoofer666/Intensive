package Template;

public class TemplateMethod {
    public static void main(String[] args) {

        Template subClass1 = new Class1();
        subClass1.templateMethod();

        Template subClass2 = new Class2();
        subClass2.templateMethod();
    }
}


abstract class Template {

    public final void templateMethod(){
        System.out.print("текст 1");
        difference();
        System.out.println("текст 2");
    }

    public abstract void difference();
}


class Class1 extends Template{
    public void difference() {
        System.out.print("Class1");
    }
}


class Class2 extends Template{
    public void difference() {
        System.out.print("Class2");
    }
}