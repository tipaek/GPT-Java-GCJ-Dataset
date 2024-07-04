import java.io.*;
import java.util.*;

public class CodeForces {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = in.nextInt();

        for (int e = 0; e < t; e++) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            int k = 0, r = 0, c = 0;

            for (int i = 0; i < n; i++) {
                k += arr[i][i];
            }

            for (int i = 0; i < n; i++) {
                if (!hasUniqueElements(arr[i])) {
                    r++;
                }
            }

            for (int j = 0; j < n; j++) {
                if (!hasUniqueElements(getColumn(arr, j))) {
                    c++;
                }
            }

            out.printf("Case #%d: %d %d %d%n", e + 1, k, r, c);
        }

        out.close();
        in.close();
    }

    private static boolean hasUniqueElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) {
                return false;
            }
        }
        return true;
    }

    private static int[] getColumn(int[][] array, int index) {
        int[] column = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            column[i] = array[i][index];
        }
        return column;
    }
}