import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int B = in.nextInt();
        in.nextLine();
        
        for (int t = 1; t <= T; t++) {
            char[] A = new char[B];
            int queryCount = 0;
            
            // Read B bits
            for (int i = 0; i < B; i++) {
                if (i % 10 == 0 && i != 0) {
                    queryCount++;
                }
                System.out.println(i + 1);
                A[i] = in.nextInt() == 0 ? '0' : '1';
            }
            in.nextLine();

            // Try various transformations to match the expected output
            if (tryPrintTransformation(A, in)) continue;
            if (tryPrintTransformation(complement(A), in)) continue;
            if (tryPrintTransformation(reverse(A), in)) continue;
            if (tryPrintTransformation(complement(reverse(A)), in)) continue;

            // Additional 10-bit sequence processing
            char[] Z = new char[10];
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                Z[i] = in.nextInt() == 0 ? '0' : '1';
            }
            in.nextLine();

            char[] O = Arrays.copyOf(A, A.length);
            System.arraycopy(Z, 0, O, 0, 10);

            if (tryPrintTransformation(O, in)) continue;
            if (tryPrintTransformation(complement(O), in)) continue;
            if (tryPrintTransformation(reverse(O), in)) continue;
            if (tryPrintTransformation(complement(reverse(O)), in)) continue;
        }
    }

    private static boolean tryPrintTransformation(char[] array, Scanner in) {
        System.out.println(new String(array));
        return in.nextLine().contains("Y");
    }

    private static char[] complement(char[] array) {
        char[] complemented = array.clone();
        for (int i = 0; i < complemented.length; i++) {
            complemented[i] = complemented[i] == '0' ? '1' : '0';
        }
        return complemented;
    }

    private static char[] reverse(char[] array) {
        char[] reversed = array.clone();
        for (int left = 0, right = reversed.length - 1; left < right; left++, right--) {
            char temp = reversed[left];
            reversed[left] = reversed[right];
            reversed[right] = temp;
        }
        return reversed;
    }
}