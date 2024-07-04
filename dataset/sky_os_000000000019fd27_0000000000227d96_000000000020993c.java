
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author namhcn
 */
public class Solution {

    private static final boolean DEBUG = false;

    private static class Pair {

        public int trace;
        public int numberRow;
        public int numberColum;

        public Pair() {
            this.trace = 0;
            this.numberRow = 0;
            this.numberColum = 0;
        }

        public Pair(int trace, int numberRow, int numberColum) {
            this.trace = trace;
            this.numberRow = numberRow;
            this.numberColum = numberColum;
        }

    }

    public static int[] getColumn(int[][] array, int index) {
        int[] column = new int[array[0].length]; // Here I assume a rectangular 2D array! 
        for (int i = 0; i < column.length; i++) {
            column[i] = array[i][index];
        }
        return column;
    }

    public static int firstDuplicate(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (!set.add(a[i])) {
                return a[i];
            }
        }
        return -1; // no duplicates found 
    }

    public static Pair solve(int[][] arr, int size) {
        Pair pair = new Pair();

        for (int i = 0; i < size; i++) {
            pair.trace += arr[i][i];
        }

        //row
        for (int i = 0; i < size; i++) {
            pair.numberRow += firstDuplicate(arr[i]) == -1 ? 0 : 1;
        }

        //colum
        for (int i = 0; i < size; i++) {
            pair.numberColum += firstDuplicate(getColumn(arr, i)) == -1 ? 0 : 1;

        }
        return pair;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("resources/input1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                String N = scanner.next();
                int NLoop = Integer.parseInt(N);
                int[][] arr = new int[NLoop][NLoop];
                for (int j = 0; j < NLoop; j++) {
                    for (int k = 0; k < NLoop; k++) {
                        arr[j][k] = Integer.parseInt(scanner.next());
                    }
                }
                Pair result = solve(arr, NLoop);

                //(DEBUG ? input + "," : "") 
                System.out.println("Case #" + testNumber + ": " + result.trace + " " + result.numberRow + " " + result.numberColum);
            }
//            System.err.println(Long.MAX_VALUE);
        }
        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}
