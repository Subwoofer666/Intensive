package Observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Observer {
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();

        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());

        station.setMeasurements(20, 765);
        station.setMeasurements(-10, 740);

    }
}

//Observable
interface Observed{
    void addObserver(ObserverI o);
    void removeObserver(ObserverI o);
    void notifyObservers();
}
//издатель
class MeteoStation implements Observed{
    private int temperature;
    private int pressure;

    List<ObserverI> observers = new ArrayList<>();

    public void setMeasurements(int t, int p){
        temperature = t;
        pressure = p;
        notifyObservers();
    }

    public void addObserver(ObserverI o) {
        observers.add(o);
    }
    public void removeObserver(ObserverI o) {
        observers.remove(o);
    }
    public void notifyObservers() {
        for(ObserverI o: observers){
            o.handleEvent(temperature, pressure);
        }
    }
}
//Observer
interface ObserverI {
    void handleEvent(int temp, int pressure);
}



class ConsoleObserver implements ObserverI {
    public void handleEvent(int temp, int pressure) {
        System.out.println("Температура в консоли = " + temp + "," +
                " Pressure  = " + pressure +".");
    }
}


class FileObserver implements ObserverI {
    public void handleEvent(int temp, int pressure) {
        File f;
        try {
            f = File.createTempFile("TempPressure", "file.txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print("Температура в файле = " + temp + "," +
                    " Pressure = " + pressure +".");
            pw.println();
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}