package Builder;

public class Builder {
    public static void main(String[] args) {
//        Car car = new CarBuilder()
//                .buildMake("Audi")
//                .buildTransmission(Transmission.AUTO)
//                .buildMaxSpeed(280)
//                .build();
//        System.out.println(car);

        Director director = new Director();
        director.setBuilder(new FordFocusBuilder());
        Car car = director.buildCar();
        System.out.println(car);
    }
}

enum Transmission {
    MANUAL, AUTO
}

class Car {
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

//class CarBuilder {  //класс который строит наш объект
//    String m = "Default";
//    Transmission t = Transmission.MANUAL;
//    int s = 180;
//
//    CarBuilder buildMake(String m) {
//        this.m = m;
//        return this;
//    }
//    CarBuilder buildTransmission(Transmission t) {
//        this.t = t;
//        return this;
//    }
//    CarBuilder buildMaxSpeed(int s) {
//        this.s = s;
//        return this;
//    }
//    Car build() {
//        Car car = new Car();
//        car.setMake(m);
//        car.setTransmission(Transmission.AUTO);
//        car.setMaxSpeed(s);
//        return car;
//    }
//}

abstract class CarBuilder {
    Car car;
    void createCar() {car = new Car();}

    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();

    Car getCar() {return car;}
}
class FordFocusBuilder extends CarBuilder {
    void buildMake() {
        car.setMake("Ford Focus");
    }
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }
    void buildMaxSpeed() {
        car.setMaxSpeed(180);
    }
}

class Director {
    CarBuilder builder;
    void setBuilder(CarBuilder b) {
        builder = b;
    }
    Car buildCar(){
        builder.createCar();
        builder.buildMake();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        Car car = builder.getCar();
        return car;
    }
}
