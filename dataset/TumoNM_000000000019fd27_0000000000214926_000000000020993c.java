import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Reads in number of lines
        for (int i = 0; i < t; ++i) { // For every N
            int n = in.nextInt(); // Reads in size of matrix
            int k = 0;
            int r = 0;
            int c = 0;
            ArrayList<Integer>[] rows = new ArrayList[n];
            ArrayList<Integer>[] columns = new ArrayList[n];
            for (int p = 0; p < n; p++) {
                rows[p] = new ArrayList<Integer>();
                columns[p] = new ArrayList<Integer>();
            }
            for (int j = 0; j < n; j++) { // Row
                for (int l = 0; l < n; l++) { // Column
                    int value = in.nextInt(); // Reads in matrix value
                    rows[j].add(value);
                    columns[l].add(value);
                    if (j == l) k += value;
                }
            }
            // Check repeated chars
            Set<String> repeatsRow = new LinkedHashSet<>();
            Set<String> repeatsCol = new LinkedHashSet<>();
            for (int j = 0; j < n; j++) {
                for (Integer number : rows[j]) {
                    if(Collections.frequency(rows[i], number) > 1)
                        repeatsRow.add(String.valueOf(number));
                }
                if (!repeatsRow.isEmpty()) r++;
                for (Integer number : columns[j]) {
                    if(Collections.frequency(columns[i], number) > 1)
                        repeatsCol.add(String.valueOf(number));
                }
                if (!repeatsCol.isEmpty()) c++;
            }


            System.out.println("Case #" + (i+1) + ": " + k + " " + r + " " +c);
        }
    }
}