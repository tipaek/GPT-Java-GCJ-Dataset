import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        
        for (int currentTest = 1; currentTest <= numberOfTests; currentTest++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            solve(currentTest, n, k);
        }
        
        scanner.close();
    }

    public static void solve(int testNumber, int n, int k) {
        String result;
        int sum = (n * (n + 1)) / 2;
        
        if ((n == 2 && k == 3) || k < n || k > n * n) {
            result = "IMPOSSIBLE";
        } else if (k % n == 0 || k == sum) {
            result = "POSSIBLE";
        } else {
            result = "IMPOSSIBLE";
        }
        
        System.out.printf("Case #%d: %s%n", testNumber, result);
        
        if (result.equals("IMPOSSIBLE")) return; 
        
        // Print square
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> initialList = new ArrayList<>();
        int offset = (k % n == 0) ? k / n - 1 : 0;
        
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
        
        for (int j = matrix.size() - 1; j >= 0; j--) {
            List<Integer> row = matrix.get(j);
            if (k == sum) Collections.reverse(row);
            
            for (int i = 0; i < row.size(); i++) {
                if (i == row.size() - 1) {
                    System.out.printf("%d%n", row.get(i));
                } else {
                    System.out.printf("%d ", row.get(i));
                }
            }
        }
    }
}