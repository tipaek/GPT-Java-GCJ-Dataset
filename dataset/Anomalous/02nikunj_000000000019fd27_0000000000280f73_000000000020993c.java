import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Jam {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int test = 0;

        while (t-- > 0) {
            test++;
            try {
                int n = sc.nextInt();
                int[][] arr = new int[n][n];
                int trace = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        arr[i][j] = sc.nextInt();
                        if (i == j) {
                            trace += arr[i][j];
                        }
                    }
                }

                int rowDuplicates = 0, colDuplicates = 0;

                for (int i = 0; i < n; i++) {
                    HashSet<Integer> rowSet = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        rowSet.add(arr[i][j]);
                    }
                    if (rowSet.size() < n) {
                        rowDuplicates++;
                    }
                }

                for (int j = 0; j < n; j++) {
                    HashSet<Integer> colSet = new HashSet<>();
                    for (int i = 0; i < n; i++) {
                        colSet.add(arr[i][j]);
                    }
                    if (colSet.size() < n) {
                        colDuplicates++;
                    }
                }

                System.out.println("Case #" + test + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
            } catch (Exception e) {
                return;
            }
        }
    }
}