import java.util.Scanner;

public class Solution {
    public static void main (String args[]) {
        Scanner input = new Scanner (System.in);
        int numOfTests = input.nextInt ();
        int length = input.nextInt();
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                System.out.println ("" + (i+1));
                arr[i] = input.nextInt();
            }
            String output = "";
            for (int i = 0; i < 10; i++) {
                output += arr[i];
            }
            System.out.println (output);
            input.next();
        }
    }
}