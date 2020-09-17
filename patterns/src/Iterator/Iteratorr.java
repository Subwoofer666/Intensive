package Iterator;

public class Iteratorr {
    public static void main(String[] args) {
        Integer [] test = {1,2,3,44,5};
        Aggregate Aggregate = new ConcreteCollection(test);
        Iterator it = Aggregate.getIterator();

        while(it.hasNext()){
            System.out.print(it.next() + " "); 
        }
    }
}


interface Iterator{
    boolean hasNext();
    Object next();
}


interface Aggregate{
    Iterator getIterator();
}


class ConcreteCollection implements Aggregate {
    public Object[] tasks;

    public ConcreteCollection(Object[] tasks) {
        this.tasks = tasks;
    }
    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }


    private class TaskIterator implements Iterator {
        int index = 0;
        @Override
        public boolean hasNext() {
            if (index < tasks.length) {
                return true;
            }
            return false;
        }
        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}