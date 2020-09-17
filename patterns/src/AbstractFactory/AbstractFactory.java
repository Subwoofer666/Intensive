package AbstractFactory;

public class AbstractFactory {
    public static void main(String[] args) {

        DeviceFactory deviceFactory = getFactiryCountryCode("EN"); //меняется только код страны
        Mouse mouse = deviceFactory.getMouse();
        Keyboard keyboard = deviceFactory.getKeyboard();
        Touchpad touchpad = deviceFactory.getTouchpad();

        mouse.click();
        keyboard.print();
        touchpad.track(6, 17);
    }
    private static DeviceFactory getFactiryCountryCode(String lang) {
        switch (lang) {
            case "RU":
                return new RuDeviveFactory();
            case "EN":
                return new EngDeviveFactory();
            default:
                throw new RuntimeException("error Country Code: " + lang);
        }
    }
}

interface Mouse {
    void click();
    void dbclick();
    void scroll(int direction);
}
interface Keyboard {
    void print();
    void println();
}
interface Touchpad {
    void track(int x, int y);
}

interface DeviceFactory {
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}

class RuMouse implements  Mouse {
    public void click() {
        System.out.println("Щелчок мышью");
    }
    public void dbclick() {
        System.out.println("Двойной щелчок мышью");
    }
    public void scroll(int direction) {
      if (direction > 0) System.out.println("Скроллим вверх");
      else if (direction < 0) System.out.println("Скроллим вниз");
      else System.out.println("Не скроллим");
    }
}
class RuKeyboard implements Keyboard {
    public void print() {
        System.out.println("Печатаем строку");
    }
    public void println() {
        System.out.println("Печатаем строку с переводом строки");
    }
}
class RuTouchpad implements Touchpad {
    public void track(int x, int y) {
        int s = (int) Math.sqrt(Math.pow(x,2)+ Math.pow(y,2));
        System.out.println("Передвинулись на " + s + " пикселей");
    }
}



class EngMouse implements  Mouse {
    public void click() {
        System.out.println("Mouse clicjk");
    }
    public void dbclick() {
        System.out.println("Mouse double click");
    }
    public void scroll(int direction) {
        if (direction > 0) System.out.println("Scroll up");
        else if (direction < 0) System.out.println("Scroll down");
        else System.out.println("No scrolling");
    }
}
class EngKeyboard implements Keyboard {
    public void print() {
        System.out.println("Print");
    }
    public void println() {
        System.out.println("Print line");
    }
}
class EngTouchpad implements Touchpad {
    public void track(int x, int y) {
        int s = (int) Math.sqrt(Math.pow(x,2)+ Math.pow(y,2));
        System.out.println("Moved " + s + " pixels");
    }
}

class EngDeviveFactory implements DeviceFactory {
    public Mouse getMouse() {
        return new EngMouse();
    }
    public Keyboard getKeyboard() {
        return new EngKeyboard();
    }
    public Touchpad getTouchpad() {
        return new EngTouchpad();
    }
}
class RuDeviveFactory implements DeviceFactory {
    public Mouse getMouse() {
        return new RuMouse();
    }
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }
    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}
