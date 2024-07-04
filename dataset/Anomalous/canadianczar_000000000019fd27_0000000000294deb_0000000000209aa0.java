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

        if ((n == 2 && k == 3) || k < n || k > n * n) {
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
        List<Integer> row = new ArrayList<>();
        int offset = (k % n == 0) ? k / n - 1 : 0;

        for (int i = 1; i <= n; i++) {
            row.add(i);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> rotatedRow = new ArrayList<>();
            offset = (offset + n) % n;
            rotatedRow.addAll(row.subList(offset, n));
            rotatedRow.addAll(row.subList(0, offset));
            matrix.add(rotatedRow);
            offset--;
        }

        for (int j = matrix.size() - 1; j >= 0; j--) {
            row = matrix.get(j);
            if (k == sum) {
                Collections.reverse(row);
            }
            for (int num : row) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }
}