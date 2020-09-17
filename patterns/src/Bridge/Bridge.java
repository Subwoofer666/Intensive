package Bridge;

public class Bridge {
    public static void main(String[] args) {
        Car c = new Sedan(new Kia());
        c.showDetails();
    }
}

abstract class Car {
    Make make;
    public Car(Make m) {
        make = m;
    }
    abstract void showType();
    void showDetails() {
        showType();
        make.setMaker();
    }
}


class Sedan extends Car {
    public Sedan(Make m) {
        super(m);
    }
    @Override
    void showType() {
        System.out.println("Sedan");
    }
}
class Hatchback extends Car {
    public Hatchback(Make m) {
        super(m);
    }
    @Override
    void showType() {
        System.out.println("Hatchback");
    }
}


interface Make {
    void setMaker();
}


class Kia implements Make {
    @Override
    public void setMaker() {
        System.out.println("Kia");
    }
}
class Audi implements Make {
    @Override
    public void setMaker() {
        System.out.println("Audi");
    }
}