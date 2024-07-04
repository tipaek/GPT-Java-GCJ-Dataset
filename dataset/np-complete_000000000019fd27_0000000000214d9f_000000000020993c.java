import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String T = in.nextLine();
        int t = Integer.parseInt(T);
        for (int i = 1; i <= t; i++) {
            String N = in.nextLine();
            int n = Integer.parseInt(N);

            HashMap<Integer, HashSet<Integer>> rowElements = new HashMap<Integer, HashSet<Integer>>();
            HashMap<Integer, HashSet<Integer>> colElements = new HashMap<Integer, HashSet<Integer>>();

            int tr = 0;
            int r = 0;
            int c = 0;

            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                String row = in.nextLine();
                String[] elements = row.split(" ");

                Boolean rowAdded = false;
                HashSet<Integer> rowJ = new HashSet<Integer>();
                if (rowElements.containsKey(j)) {
                    rowJ = rowElements.get(j);
                }

                for (int k = 0; k < n; k++) {
                    int value = Integer.parseInt(elements[k]);
                    matrix[j][k] = value;

                    if (rowJ.contains(value) && !rowAdded) {
                            r++;
                            rowAdded = true;
                    }
                    rowJ.add(value);

                    if (j == k) {
                            tr += value;
                    }
                }

                rowElements.put(j, rowJ);
            }

            for (int k = 0; k < n; k++) {
                Boolean colAdded = false;
                HashSet<Integer> colK = new HashSet<Integer>();
                if (colElements.containsKey(k)) {
                    colK = colElements.get(k);
                }

                for (int j = 0; j < n; j++) {
                    int val = matrix[j][k];
                    if (colK.contains(val) && !colAdded) {
                            c++;
                            colAdded = true;
                    }
                    colK.add(val);

                    colElements.put(k, colK);
                }
            }

            System.out.println("Case #" + i + ": " + tr + " " + r + " " + c);
        }

        in.close();
    }
}
