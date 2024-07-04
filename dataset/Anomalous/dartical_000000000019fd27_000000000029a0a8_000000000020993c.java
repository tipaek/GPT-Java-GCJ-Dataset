import java.util.*;
import java.io.*;

public class Main {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static int t = in.nextInt();

    public static void main(String[] args) {
        for (int loop = 1; loop <= t; loop++) {

            int size = in.nextInt();
            int[][] matrix = new int[size][size];

            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }

            // loop through each row
            int r = 0;
            for (int j = 0; j < size; j++) {
                if (hasDuplicates(matrix[j]))
                    r++;
            }

            // loop through columns
            int c = 0;
            for (int j = 0; j < size; j++) {
                int[] temp = new int[size];
                for (int k = 0; k < size; k++) {
                    temp[k] = matrix[k][j];
                }

                if (hasDuplicates(temp))
                    c++;
            }

            // compute trace
            int trace = 0;
            for (int x = 0; x < size; x++) {
                trace += matrix[x][x];
            }

            // print desired results
            System.out.println("Case #" + loop + ": " + trace + " " + r + " " + c);

        }
    }

    public static boolean hasDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}