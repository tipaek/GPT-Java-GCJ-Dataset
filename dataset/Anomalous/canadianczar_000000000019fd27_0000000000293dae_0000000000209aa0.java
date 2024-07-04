import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        for (int test = 1; test <= numberOfTests; test++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            solve(test, n, k);
        }
        scanner.close();
    }

    public static void solve(int test, int n, int k) {
        String result;
        int sum = (n * (n + 1)) / 2;

        if (n == 2 && k == 3) {
            result = "IMPOSSIBLE";
        } else if (k % n == 0 || k == sum) {
            result = "POSSIBLE";
        } else {
            result = "IMPOSSIBLE";
        }

        System.out.printf("Case #%d: %s\n", test, result);

        if (result.equals("IMPOSSIBLE")) {
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
            int actualOffset = (offset + n) % n;
            rotatedList.addAll(baseList.subList(actualOffset, n));
            rotatedList.addAll(baseList.subList(0, actualOffset));
            matrix.add(rotatedList);
            offset--;
        }

        if (k == sum) {
            Collections.reverse(baseList);
        }

        for (List<Integer> row : matrix) {
            for (int num : row) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }
}