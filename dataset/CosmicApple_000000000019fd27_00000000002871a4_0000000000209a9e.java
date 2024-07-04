import java.util.Scanner;

public class Solution {
    public static void main (String args[]) {
        Scanner input = new Scanner (System.in);
        int numOfTests = input.nextInt ();
        int length = input.nextInt();
        
        if (length != 10)
        while (true)
            System.out.println ("" + 0);
            
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            DataFinder dataFinder = new DataFinder (length);
            for (int i = 0; i < 10; i++) {
                dataFinder.getBit (i, input);
            }
            System.out.println (dataFinder.getOutput());
            input.next();
        }
    }
}

class DataFinder {
    int[] arr;
    public DataFinder (int length) {
        arr = new int[length];
    }
    
    public void getBit (int index, Scanner input) {
        System.out.println ("" + (index+1));
                arr[index] = input.nextInt();
    }
    
    public String getOutput () {
        String output = "";
        for (int i = 0; i < 10; i++) {
            output += arr[i];
        }
        return output;
    } 
}