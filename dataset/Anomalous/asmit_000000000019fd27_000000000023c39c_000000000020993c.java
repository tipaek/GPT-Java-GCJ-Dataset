import java.io.*;
import java.util.*;

class Vestigium {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int T = Math.abs(sc.nextInt());

        for (int h = 1; h <= T; h++) {
            int size = Math.abs(sc.nextInt());
            int[][] arr = new int[size][size];

            for (int v = 0; v < size; v++) {
                for (int y = 0; y < size; y++) {
                    arr[v][y] = Math.abs(sc.nextInt());
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int d = 0; d < size; d++) {
                trace += arr[d][d];
            }

            // Calculate the number of rows with duplicate elements
            int rowDuplicates = 0;
            for (int j = 0; j < size; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int l = 0; l < size; l++) {
                    if (!rowSet.add(arr[j][l])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Calculate the number of columns with duplicate elements
            int colDuplicates = 0;
            for (int s = 0; s < size; s++) {
                Set<Integer> colSet = new HashSet<>();
                for (int l = 0; l < size; l++) {
                    if (!colSet.add(arr[l][s])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + h + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}