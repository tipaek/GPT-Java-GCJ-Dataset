import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int mid = k / n;
            List<List<Integer>> matrix = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                List<Integer> row = new ArrayList<>(n);
                for (int j = 0; j < n; j++) {
                    int p = n - i;
                    int value = ((p + j) % n) + mid;
                    if (value > n) {
                        value -= n;
                    }
                    row.add(value);
                }
                matrix.add(row);
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix.get(i).get(i);
            }

            if (trace == k) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                for (List<Integer> row : matrix) {
                    for (int value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
}