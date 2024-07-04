import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Solution{
     public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int array[][] = new int[n][n];
            int j = 0;
            while (j < array.length) {
                int k = 0;
                while (k < array.length) {
                    array[j][k++] = in.nextInt();
                }
                j++;
            }
            int repeatedRow = 0;
            int repeatedColumn = 0;
            int trace = 0;
            int temp[] = new int[n];
            for (int k = 0; k < n; k++) {
                System.arraycopy(array[k], 0, temp, 0, n);
                if (isDuplicated(temp)) repeatedRow++;
                for (int l = 0; l < n; l++) {
                    temp[l] = array[l][k];
                }
                if (isDuplicated(temp)) repeatedColumn++;
                trace += array[k][k];
            }
            String result = String.format("Case #%d: %d %d %d", i, trace, repeatedRow, repeatedColumn);
            System.out.println(result);
        }

    }

    private static boolean isDuplicated(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = i;
            while (j + 1 != array[j]) {
                int x = array[j];
                if (array[x - 1] == x) return true;
                int temp = array[j];
                array[j] = array[x - 1];
                array[x - 1] = temp;
                j = x - 1;
            }
        }
        return false;
    }
}