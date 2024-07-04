import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
            int dim = in.nextInt();
            int arr[][] = new int[dim][dim];
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++)
                    arr[i][j] = in.nextInt();
            }
            System.out.println(LatinSquares(arr, k));
        }
    }

    static String LatinSquares(int[][] arr, int c) {
        Map<Integer, List<Map<Integer, Integer>>> clasification = new HashMap<>();
        int k = 0;
        int repeatCol = 0;
        int repeatRow = 0;
        for (int i = 0; i < arr.length; i++) {
            k += arr[i][i];
// burda da baxa bilersen koda baxim, hardasa sehv edibsen xrda sehv var
            for (int j = 0; j < arr[i].length; j++) {
                if (!clasification.containsKey(arr[i][j])) {
                    List<Map<Integer, Integer>> maps = new ArrayList<>(2);
                    Map<Integer, Integer> cols = new HashMap<>();
                    cols.put(j, 1);

                    Map<Integer, Integer> rows = new HashMap<>();
                    rows.put(i, 1);
                    maps.add(rows);
                    maps.add(cols);
                    clasification.put(arr[i][j], maps);
                } else {
                    List<Map<Integer, Integer>> maps = clasification.get(arr[i][j]);
                    Map<Integer, Integer> rows = maps.get(0);
                    Map<Integer, Integer> cols = maps.get(1);

                    if (rows.containsKey(i) && repeatRow < arr.length)
                        repeatRow = repeatRow + 1;
                    else
                        rows.put(i, 1);

                    if (cols.containsKey(j) && repeatCol < arr.length)
                        repeatCol = repeatCol + 1;
                    else
                        cols.put(j, 1);
                }
            }
        }
   

        return "Case " + c + "#: " + k + " " + repeatRow + " " + repeatCol;
    }
}
