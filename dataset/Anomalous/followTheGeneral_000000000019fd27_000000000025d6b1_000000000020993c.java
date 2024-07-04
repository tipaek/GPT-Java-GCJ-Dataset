import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        new Solution().solve();
    }

    private void solve() {
        int currentCase = 1;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());

            while (testCases-- > 0) {
                int n = Integer.parseInt(br.readLine());
                int[][] arr = new int[n][n];

                int rowDup = 0;

                for (int i = 0; i < n; i++) {
                    String[] arrRowItems = br.readLine().split(" ");
                    Set<Integer> dupSet = new HashSet<>();
                    boolean isRowDup = false;

                    for (int j = 0; j < n; j++) {
                        int arrItem = Integer.parseInt(arrRowItems[j]);
                        arr[i][j] = arrItem;

                        if (!isRowDup && !dupSet.add(arrItem)) {
                            rowDup++;
                            isRowDup = true;
                        }
                    }
                }

                System.out.println("Case #" + currentCase++ + ": " + calculateDiagonalSum(arr) + " " + rowDup + " " + calculateColumnDups(arr));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int calculateDiagonalSum(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        return sum;
    }

    private int calculateColumnDups(int[][] arr) {
        int colDup = 0;
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> dupSet = new HashSet<>();
            for (int j = 0; j < arr.length; j++) {
                if (!dupSet.add(arr[j][i])) {
                    colDup++;
                    break;
                }
            }
        }
        return colDup;
    }
}