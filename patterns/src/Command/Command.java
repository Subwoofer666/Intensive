package Command;

public class Command {
    public static void main(String[] args) {
        Computer c = new Computer();
        User u = new User(new StartCommand(c), new StopCommand(c), new ResetCommand(c));

        u.startComputer();
        u.stopComputer();
        u.resetComputer();
    }
}

interface CommandInt{
    void execute();
}

//Receiver
class Computer{
    public void start(){
        System.out.println("Start");
    }
    public void stop(){
        System.out.println("Stop");
    }
    public void reset(){
        System.out.println("Reset");
    }
}



//ConcreteCommand
class StartCommand implements CommandInt {
    Computer computer;

    public StartCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.start();
    }
}
class StopCommand implements CommandInt{
    Computer computer;
    public StopCommand(Computer computer) {this.computer = computer;}
    @Override
    public void execute() {
        computer.stop();
    }
}
class ResetCommand implements CommandInt{
    Computer computer;
    public ResetCommand(Computer computer) {this.computer = computer;}
    @Override
    public void execute() {
        computer.reset();
    }
}



//Step4 invoker
class User{
    private CommandInt start;
    private CommandInt stop;
    private CommandInt reset;
    public User(CommandInt start, CommandInt stop, CommandInt reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }
    public void startComputer(){
        start.execute();
    }
    public void stopComputer(){
        stop.execute();
    }
    public void resetComputer(){
        reset.execute();
    }
}