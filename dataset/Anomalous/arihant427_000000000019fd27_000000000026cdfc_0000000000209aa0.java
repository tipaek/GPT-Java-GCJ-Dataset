import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            
            if (m < n || n * n < m) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }
            
            int[][] finalArr = new int[n][n];
            int num = m / n;
            int remainder = m % n;
            
            for (int j = 0; j < n; j++) {
                finalArr[j][j] = num + (remainder > 0 ? 1 : 0);
                remainder--;
            }

            Set<Integer> uniqueNumbers = new HashSet<>();
            for (int j = 0; j < n; j++) {
                uniqueNumbers.add(finalArr[j][j]);
            }

            int requiredUniqueNumbers = (n % 2 == 0) ? n / 2 : n / 2 + 1;
            if (uniqueNumbers.size() > 1 && (n - uniqueNumbers.size() + 1) >= requiredUniqueNumbers) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            for (int j = 0; j < n; j++) {
                for (int j2 = 0; j2 < n; j2++) {
                    if (j == j2) continue;

                    List<String> availableNumbers = new ArrayList<>();
                    for (int k = 1; k <= n; k++) {
                        availableNumbers.add(String.valueOf(k));
                    }

                    for (int k = 0; k < n; k++) {
                        availableNumbers.remove(String.valueOf(finalArr[j][k]));
                        availableNumbers.remove(String.valueOf(finalArr[k][j2]));
                    }

                    if (availableNumbers.isEmpty()) {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        System.exit(0);
                    } else {
                        finalArr[j][j2] = Integer.parseInt(availableNumbers.get(0));
                    }
                }
            }

            System.out.println("Case #" + i + ": POSSIBLE");
            for (int[] row : finalArr) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
    }
}