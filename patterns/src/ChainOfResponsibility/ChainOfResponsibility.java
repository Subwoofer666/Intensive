package ChainOfResponsibility;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Logger smsLogger = new SMSLogger(Level.ERROR);
        Logger fileLogger = new FileLogger(Level.DEBUG);
        Logger emailLogger = new EmailLogger(Level.INFO);

        smsLogger.setNext(fileLogger);
        fileLogger.setNext(emailLogger);

        smsLogger.writeMessage("Ok", Level.INFO);     // one handler
        System.out.println("----------------------------------");
        smsLogger.writeMessage("debbug", Level.DEBUG);      // two handler
        System.out.println("-----------------------------------");
        smsLogger.writeMessage("error ", Level.ERROR);// three handler
    }
}


    class Level {
        public static final int ERROR = 1;
        public static final int DEBUG = 2;
        public static final int INFO = 3;
    }


    abstract class Logger {
        private int priority;

        public Logger(int priority) {
            this.priority = priority;
        }

        private Logger next;

        public void setNext(Logger next) {
            this.next = next;
        }

        public void writeMessage(String message, int level) {
            if (level <= priority) {
                write(message);
            }
            if (next != null) {
                next.writeMessage(message, level);
            }
        }

        abstract void write(String message);
    }


    class SMSLogger extends Logger {
        public SMSLogger(int priority) {
            super(priority);
        }
        public void write(String message) {
            System.out.println("SMS: " + message);
        }
    }
    class FileLogger extends Logger {
        public FileLogger(int priority) {
            super(priority);
        }
        public void write(String message) {
            System.out.println("file: " + message);
        }
    }
    class EmailLogger extends Logger {
        public EmailLogger(int priority) {
            super(priority);
        }
        public void write(String message) {
            System.out.println("E-mail : " + message);
        }
    }

