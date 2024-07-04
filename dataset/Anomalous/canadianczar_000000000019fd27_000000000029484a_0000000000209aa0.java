import java.util.*;
import java.io.*;

class Solution {
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

    public static void solve(int testCase, int n, int k) {
        String result;
        int sumOfSeries = (n * (n + 1)) / 2;

        if ((n == 2 && k == 3) || k < n || k > n * n) {
            result = "IMPOSSIBLE";
        } else if (k % n == 0 || k == sumOfSeries) {
            result = "POSSIBLE";
        } else {
            result = "IMPOSSIBLE";
        }

        System.out.printf("Case #%d: %s\n", testCase, result);

        if (result.equals("IMPOSSIBLE")) return;

        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> initialList = new ArrayList<>();
        int offset = (k % n == 0) ? (k / n) - 1 : 0;

        for (int i = 1; i <= n; i++) {
            initialList.add(i);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> rotatedList = new ArrayList<>();
            offset = (offset + n) % n;
            rotatedList.addAll(initialList.subList(offset, initialList.size()));
            rotatedList.addAll(initialList.subList(0, offset));
            matrix.add(rotatedList);
            offset--;
        }

        if (k == sumOfSeries) {
            Collections.reverse(initialList);
        }

        for (List<Integer> row : matrix) {
            for (int value : row) {
                System.out.printf("%d ", value);
            }
            System.out.printf("\n");
        }
    }
}