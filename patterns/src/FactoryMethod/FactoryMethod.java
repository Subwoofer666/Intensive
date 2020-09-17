package FactoryMethod;

import java.util.Date;

public class FactoryMethod {
    public static void main(String[] args) {
        WatchMaker maker = new DigitalWatchMaker();//меняется только new DigitalWatchMaker
        Watch watch = maker.createWatch();
        watch.showTime();
    }
}
interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}
class RomeWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println("Rome Time");
    }
}
interface WatchMaker {
    Watch createWatch();  //метод возвращает часы в зависимости от производителя
}
class DigitalWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}
class RomeWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}
