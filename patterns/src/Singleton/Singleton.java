package Singleton;

public class Singleton {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getSingleton();


    }


    private static Singleton instance;

    public static synchronized Singleton getSingleton(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }


    private Singleton() {  //приватный конструктор
    }

}