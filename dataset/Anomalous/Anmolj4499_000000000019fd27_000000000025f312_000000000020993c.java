import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();

        for (int a = 1; a <= testcases; a++) {
            int k = 0, r = 0, c = 0;
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];

            for (int l = 0; l < n; l++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowDuplicate = false;

                for (int m = 0; m < n; m++) {
                    int value = scanner.nextInt();
                    arr[l][m] = value;

                    if (l == m) {
                        k += value;
                    }

                    if (!rowDuplicate && rowSet.contains(value)) {
                        r++;
                        rowDuplicate = true;
                    } else {
                        rowSet.add(value);
                    }
                }
            }

            for (int l = 0; l < n; l++) {
                Set<Integer> columnSet = new HashSet<>();
                boolean columnDuplicate = false;

                for (int m = 0; m < n; m++) {
                    if (!columnDuplicate && columnSet.contains(arr[m][l])) {
                        c++;
                        columnDuplicate = true;
                    } else {
                        columnSet.add(arr[m][l]);
                    }
                }
            }

            System.out.println("Case #" + a + ": " + k + " " + r + " " + c);
        }

        scanner.close();
    }
}