package Delegate;

public class Delegate {
    public static void main(String[] args) {

    }
}

class A {
    void f() {
        System.out.println("f()");
    }
}

class B {
    A a = new A();
    void f(){
        a.f();
    }
}