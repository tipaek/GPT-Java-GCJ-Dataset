import java.util.*;
import java.io.*;

public class Solution {

    private static String magic(int[][] array, int n) {
        int[] rowHasDup = new int[n];
        int[] colHasDup = new int[n];
        int diag = 0;

        for (int i = 0; i < n; i++) {
            rowHasDup[i] = 0;
            colHasDup[i] = 0;
        }

        List<Map<Integer, Integer>> rowMaps = new ArrayList<Map<Integer, Integer>>();
        List<Map<Integer, Integer>> colMaps = new ArrayList<Map<Integer, Integer>>();

        for (int i = 0; i < n; i++) {
            rowMaps.add(new HashMap<Integer, Integer>());
            colMaps.add(new HashMap<Integer, Integer>());
        }



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int item = array[i][j];

                if (i == j) {
                    diag += item;
                }

                if (rowHasDup[i] == 0) {
                    if (rowMaps.get(i).containsKey(item)) {
                        rowHasDup[i] = 1;
                    } else {
                        rowMaps.get(i).put(item, 1);
                    }
                }

                if (colHasDup[j] == 0) {
                    if (colMaps.get(j).containsKey(item)) {
                        colHasDup[j] = 1;
                    } else {
                        colMaps.get(j).put(item, 1);
                    }
                }
            }
        }

        int rowDup = 0, colDup = 0;

        for (int i = 0; i < n; i++) {
            rowDup += rowHasDup[i];
            colDup += colHasDup[i];
        }

        return "" + diag + " " + rowDup + " " + colDup;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] array = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int z = 0; z < n; z++) {
                    array[j][z] = in.nextInt();
                }
            }

            System.out.println("Case #" + i + ": " + magic(array, n));
        }
    }
}