//package Decorator;
//
//public class Decorator {
//    public static void main(String[] args) {
//        //without decorator:
//        PrinterInterface printer = new Printer("Привет"); // Hello,Java!
//        printer.print();
//
//        //with one decorator:
//        PrinterInterface printerWithQuote = new QuoteDecorator(new Printer("Hello,Java!")); // "Hello,Java!"
//        printerWithQuote.print();
//
//        PrinterInterface printerWithBracket = new BracketDecorator(new Printer("Hello,Java!")); // {Hello,Java!}
//        printerWithBracket.print();
//
//        //with two decorator:
//        PrinterInterface printerWithTwoDecorators =
//                new BracketDecorator(
//                        new QuoteDecorator(
//                                new Printer("Hello,Java!"))); // {"Hello,Java!"}
//        printerWithTwoDecorators.print();
//    }
//
//}
//
////-Step 1----:Create an interface. --------------------------------------------------
//interface PrinterInterface { // Component
//    void print();
//}
//
////-Step 2:----Create concrete classes implementing the same interface----------------
//class Printer implements PrinterInterface{ // Concrete Component
//    String value;
//
//    public Printer(String value) {
//        this.value = value;
//    }
//    public void print() {
//        System.out.print(value);
//    }
//}
//
//
////-Step 3:----Create abstract decorator class implementing the PrinterInterface ---------------
//abstract class Decoratorr implements PrinterInterface{
//
//    PrinterInterface printerInterface; // component
//
//    public Decoratorr(PrinterInterface printerInterface) {
//        this.printerInterface = printerInterface;
//    }
//    public void print() {
//        printerInterface.print();
//    }
//}
//
////-Step 4:----create concrete decorator---and add new functionality----------------------------
//
//class QuoteDecorator extends Decorator{
//    public QuoteDecorator(PrinterInterface printerInterface) {
//        super(printerInterface);
//    }
//    public void print() {
//        System.out.print("\""); //new functionality
//        super.print();
//        System.out.print("\""); //new functionality
//    }
//}
//
////-Step 5:----create another concrete decorator---and add new functionality--------------------
//
//class BracketDecorator extends Decorator{
//
//    public BracketDecorator(PrinterInterface printerInterface) {
//        super(printerInterface);
//    }
//
//    public void print() {
//        System.out.print('{'); //new functionality
//        super.print();
//        System.out.print('}'); //new functionality
//    }
//}