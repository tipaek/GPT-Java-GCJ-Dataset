import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            solve(testCase, n, k);
        }

        scanner.close();
    }

    private static void solve(int testCase, int n, int k) {
        String result;
        int sum = (n * (n + 1)) / 2;

        if ((n == 2 && k == 3) || k < n || k > n * n) {
            result = "IMPOSSIBLE";
        } else if (k % n == 0 || k == sum) {
            result = "POSSIBLE";
        } else {
            result = "IMPOSSIBLE";
        }

        System.out.printf("Case #%d: %s\n", testCase, result);

        if ("IMPOSSIBLE".equals(result)) {
            return;
        }

        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> baseList = new ArrayList<>();
        int offset = (k % n == 0) ? (k / n - 1) : 0;

        for (int i = 1; i <= n; i++) {
            baseList.add(i);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> rotatedList = new ArrayList<>();
            offset = (offset + n) % n;
            rotatedList.addAll(baseList.subList(offset, baseList.size()));
            rotatedList.addAll(baseList.subList(0, offset));
            matrix.add(rotatedList);
            offset--;
        }

        for (int i = matrix.size() - 1; i >= 0; i--) {
            List<Integer> row = matrix.get(i);
            if (k == sum) {
                Collections.reverse(row);
            }

            for (int j = 0; j < row.size(); j++) {
                if (j == row.size() - 1) {
                    System.out.printf("%d\n", row.get(j));
                } else {
                    System.out.printf("%d ", row.get(j));
                }
            }
        }
    }
}