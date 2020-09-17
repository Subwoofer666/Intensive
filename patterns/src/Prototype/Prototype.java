package Prototype;

public class Prototype {
    public static void main(String[] args) {
        Human original = new Human(22, "Oleg");
        System.out.println(original);

        Human copy = (Human) original.copy();
        System.out.println(copy);


        HumanFactory factory = new HumanFactory(copy);
        Human h1 = factory.makeCopy();
        System.out.println(h1);

        factory.setPrototype(new Human(25, "Sveta"));
        Human h2 = factory.makeCopy();
        System.out.println(h2);
    }
}
interface Copyable {
    Object copy();
}
class Human implements Copyable {
    int age;
    String name;

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public Object copy() {
        Human copy = new Human (age, name);
        return copy;
    }
}

class HumanFactory{
    Human human;

    public HumanFactory(Human human) {
        setPrototype(human);
    }
    public void setPrototype(Human human) {
        this.human = human;
    }
    Human makeCopy(){
        return (Human)human.copy();
    }
}