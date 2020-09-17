package Strategy;

import java.util.Arrays;

public class Strategy {
    public static void main(String[] args) {
        StrategyClient c = new StrategyClient();

        int [] arr = {1,5,3,8};
        c.setStrategy(new BubbleSort());
        c.executeStrategy(arr);
    }
}

//Context
class StrategyClient {
    Sorting strategy;
    public void setStrategy (Sorting strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy (int[]arr) {
        strategy.sort(arr);
    }
}


//Strategy
interface Sorting {
    void sort(int[]arr);
}


class BubbleSort implements Sorting {
    public void sort(int[] arr) {
       for (int l = arr.length-1; l>=0; l--) {
           for(int i=0; i<l; i++){
               if (arr[i]>arr[i+1]) {
                   int temp = arr[i];
                   arr[i] = arr[i+1];
                   arr[i+1] = temp;
               }
           }
       }
        System.out.println(Arrays.toString(arr));
    }
}