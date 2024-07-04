import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = in.nextInt();
            for (int t = 1; t <= testCases; ++t) {
                int size = in.nextInt();
                int[][] m = new int[size][size];
                for (int i = 0; i < size; ++i) {
                    for (int j = 0; j < size; ++j) {
                        m[i][j] = in.nextInt();
                    }
                }
                Set<Integer> rowElements;
                Set<Integer> colElements;
                int trace = 0;
                int rowRepeats = 0;
                int colRepeats = 0;
                for (int k = 0; k < size; ++k) {
                    rowElements = new HashSet<>();
                    colElements = new HashSet<>();
                    trace += m[k][k];
                    boolean row = true;
                    boolean col = true;
                    int i = 0;
                    while ((row || col) && i < size) {
                        if (row) {
                            if(rowElements.contains(m[k][i])){
                                row = false;
                                ++rowRepeats;
                            }
                            rowElements.add(m[k][i]);
                        }
                        if (col) {
                            if(colElements.contains(m[i][k])){
                                col = false;
                                ++colRepeats;
                            }
                            colElements.add(m[i][k]);
                        }
                        ++i;
                    }
                }
                System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
            }
        }
    }
    }