import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;

class Vestigium {

    public static void main(String[] args) throws IOException {
        new Vestigium().solve();
    }

    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);

        int testCases = Integer.parseInt(br.readLine());
        int currentCase = 1;

        while (testCases-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            Collection<Integer> dupSet = new HashSet<>();
            int rowDup = 0;

            for (int i = 0; i < n; ++i) {
                String[] arrRowItems = br.readLine().split(" ");

                boolean isRowDup = false;
                dupSet.clear();
                for (int j = 0; j < n; ++j) {
                    int arrItem = Integer.parseInt(arrRowItems[j]);
                    arr[i][j] = arrItem;

                    if (!isRowDup && !dupSet.add(arrItem)) {
                        ++rowDup;
                        isRowDup = true;
                    }
                }
            }

            out.println("Case #" + currentCase++ + ": " + diagonalSum(arr) + " " + rowDup + " " + getColDups(arr));
        }
    }

    static int diagonalSum(int[][] arr) {
        int leftDiag = 0;
        final int len = arr.length;

        for (int i = 0; i < len; ++i) {
            leftDiag += arr[i][i];
        }

        return leftDiag;
    }

    static int getColDups(int[][] arr) {
        int colDup = 0;
        Collection<Integer> dupCol = new HashSet<>();
        final int len = arr.length;
        for (int i = 0; i < len; ++i) {
            dupCol.clear();
            for (int j = 0; j < len; ++j) {
                int arrItem = arr[j][i];

                if (!dupCol.add(arrItem)) {
                    ++colDup;
                    break;
                }
            }
        }

        return colDup;
    }
}