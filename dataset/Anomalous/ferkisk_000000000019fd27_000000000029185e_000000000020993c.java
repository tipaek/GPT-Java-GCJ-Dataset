import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public Solution() {}

    public static void main(String[] args) {
        new Solution().run();
    }

    private Scanner in;

    public void run() {
        in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            solve(i);
        }
    }

    private void solve(int test) {
        int N = in.nextInt();
        int diag = 0;

        Set<Integer> rowDup = new HashSet<>();
        Set<Integer> colDup = new HashSet<>();
        Map<Integer, Set<Integer>> colDupMap = new HashMap<>();

        for (int row = 0; row < N; row++) {
            Set<Integer> rowNum = new HashSet<>();

            for (int col = 0; col < N; col++) {
                int num = in.nextInt();

                if (!rowNum.add(num) && rowDup.add(row)) {
                    rowDup.add(row);
                }

                colDupMap.computeIfAbsent(col, k -> new HashSet<>());
                Set<Integer> colNum = colDupMap.get(col);

                if (!colNum.add(num) && colDup.add(col)) {
                    colDup.add(col);
                }

                if (row == col) {
                    diag += num;
                }
            }
        }

        System.out.println("Case #" + test + ": " + diag + " " + rowDup.size() + " " + colDup.size());
    }
}