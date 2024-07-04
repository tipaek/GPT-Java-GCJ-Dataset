import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {

    public static ArrayList<ArrayList<Integer>> allPossiblePerm;
    public static int[][] square;

    public static boolean fillSquare(int currentCell, int n, int k, boolean[][] rows, boolean[][] cols) {
        if (currentCell == n * n) {
            return true;
        }

        int currentRow = currentCell / n;
        int currentCol = currentCell % n;

        if (currentRow == currentCol) {
            return fillSquare(currentCell + 1, n, k, rows, cols);
        }

        for (int i = 1; i <= n; i++) {
            if (!rows[currentRow][i] && !cols[currentCol][i]) {
                int temp = square[currentRow][currentCol];
                square[currentRow][currentCol] = i;
                rows[currentRow][i] = true;
                cols[currentCol][i] = true;
                if (fillSquare(currentCell + 1, n, k, rows, cols)) {
                    return true;
                }
                square[currentRow][currentCol] = temp;
                rows[currentRow][i] = false;
                cols[currentCol][i] = false;
            }
        }
        return false;
    }

    public static void findLatinSquares(int n, int k, int testCase) {
        if (allPossiblePerm.isEmpty()) {
            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            return;
        }

        for (ArrayList<Integer> diagonal : allPossiblePerm) {
            square = new int[n][n];
            boolean[][] rows = new boolean[n][n + 1];
            boolean[][] cols = new boolean[n][n + 1];

            for (int j = 0; j < n; j++) {
                int d = diagonal.get(j);
                square[j][j] = d;
                rows[j][d] = true;
                cols[j][d] = true;
            }

            if (fillSquare(0, n, k, rows, cols)) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(square[i][j] + " ");
                    }
                    System.out.println();
                }
                return;
            }
        }
        System.out.println("Case #" + testCase + ": IMPOSSIBLE");
    }

    public static void generatePermutations(int currentIndex, ArrayList<Integer> currentPerm, int currentSum, int n, int k) {
        if (currentIndex == n) {
            if (currentSum == k) {
                allPossiblePerm.add(new ArrayList<>(currentPerm));
            }
            return;
        }

        if (currentSum > k) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            currentPerm.add(i);
            generatePermutations(currentIndex + 1, currentPerm, currentSum + i, n, k);
            currentPerm.remove(currentPerm.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            allPossiblePerm = new ArrayList<>();
            generatePermutations(0, new ArrayList<>(), 0, n, k);
            findLatinSquares(n, k, testCase);
        }
    }
}