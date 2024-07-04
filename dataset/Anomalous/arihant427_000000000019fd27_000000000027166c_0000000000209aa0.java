import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int[][] input = new int[t][2];

        for (int i = 0; i < t; i++) {
            input[i][0] = scn.nextInt();
            input[i][1] = scn.nextInt();
        }

        for (int i = 0; i < t; i++) {
            int n = input[i][0];
            int m = input[i][1];
            if (m < n || n * n < m) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                continue;
            }

            int[][] finalArr = new int[n][n];
            int num = m / n;
            int remainder = m % n;

            for (int j = 0; j < n; j++) {
                finalArr[j][j] = num;
            }

            if (remainder <= n - num) {
                finalArr[0][0] += remainder;
            } else {
                for (int j = 0; j < n && remainder > 0; j++, remainder--) {
                    finalArr[j][j]++;
                }
            }

            Set<Integer> uniqueValues = new HashSet<>();
            for (int j = 0; j < n; j++) {
                uniqueValues.add(finalArr[j][j]);
            }

            if (uniqueValues.size() != 1 && (n - uniqueValues.size() + 1) >= (n % 2 == 0 ? n / 2 : n / 2 + 1)) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                continue;
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k) continue;

                    List<String> availableValues = new ArrayList<>();
                    for (int l = 1; l <= n; l++) {
                        availableValues.add(String.valueOf(l));
                    }

                    for (int l = 0; l < n; l++) {
                        availableValues.remove(String.valueOf(finalArr[j][l]));
                        availableValues.remove(String.valueOf(finalArr[l][k]));
                    }

                    if (availableValues.isEmpty()) {
                        System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                        System.exit(0);
                    } else {
                        finalArr[j][k] = Integer.parseInt(availableValues.get(0));
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": POSSIBLE");
            for (int[] row : finalArr) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
    }
}