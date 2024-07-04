import java.util.*;
import java.io.*;

public class Solution {

    static char printResult(int[] output, Scanner in, int dim) {
        // Build the result string
        String temp = "";
        for (int i = 0; i < dim; i++) {
            temp += String.valueOf(output[i]);
        }
        // Send the result
        System.out.println(temp);
        return in.next().charAt(0);
    }

    static int query(int P, Scanner in) {
        System.out.println(P);
        return in.nextInt();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfTests = input.nextInt(); // Number of test cases
        int size = input.nextInt(); // Number of bits
        int q = 0;
        boolean lastWasGood = true;
        // input.nextLine();
        while (q < numberOfTests && lastWasGood) {
            int[] result = new int[size];
            // Send query
            for (int i = 0; i < size; ) {
                result[i] = query(++i, input);
            }
            // Send result for checking
            if ((Solution.printResult(result, input, size)) == 'N') {
                lastWasGood = false;
            }
            q++;
        }

    }
}