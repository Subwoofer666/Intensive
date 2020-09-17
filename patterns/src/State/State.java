package State;

public class State {
    public static void main(String[] args) {

        Station station = new Radio1();
        Radio radio = new Radio();
        radio.setStation(station);

        for(int i=0; i<=10;i++){
            radio.play();
            radio.changeStation(); //изменение контекста
        }
    }
}


//State
interface Station{
    void play();
}


class Radio1 implements Station{
    @Override
    public void play() {System.out.println("Radio1");
    }
}
class Radio2 implements Station{
    @Override
    public void play() {System.out.println("Radio2");
    }
}
class Radio3 implements Station{
    @Override
    public void play() {System.out.println("Radio3");
    }
}
class Pause implements Station{
    @Override
    public void play() {
        System.out.println("Pause");
    }
}


//Context
class Radio{
    private Station station;
    public void setStation(Station station) {
        this.station = station;
    }

    public void changeStation(){
        if(station instanceof Radio1){
            setStation(new Radio2());
        }
        else if(station instanceof Radio2){
            setStation(new Radio3());
        }
        else if(station instanceof Radio3){
            setStation(new Pause());
        }
        else if(station instanceof Pause){
            setStation(new Radio1());
        }

    }
    void play(){
        station.play();
    }
}

