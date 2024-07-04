import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[][] input = new int[t][2];

        for (int i = 0; i < t; i++) {
            input[i][0] = scanner.nextInt();
            input[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < t; i++) {
            int n = input[i][0];
            int m = input[i][1];
            if (m < n || n * n < m) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                int[][] finalArr = new int[n][n];
                int num = m / n;
                int remainder = m % n;

                for (int j = 0; j < n; j++) {
                    finalArr[j][j] = num;
                }

                if (remainder > 0) {
                    if (remainder <= (n - num)) {
                        finalArr[0][0] += remainder;
                    } else {
                        for (int j = 0; j < remainder; j++) {
                            finalArr[j][j]++;
                        }
                    }
                }

                Set<Integer> uniqueValues = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    uniqueValues.add(finalArr[j][j]);
                }

                if (uniqueValues.size() != 1 && (n - uniqueValues.size() + 1) >= (n % 2 == 0 ? n / 2 : n / 2 + 1)) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                } else {
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n; k++) {
                            if (j != k && finalArr[j][k] == 0) {
                                List<Integer> possibleValues = new ArrayList<>();
                                for (int l = 1; l <= n; l++) {
                                    possibleValues.add(l);
                                }

                                for (int l = 0; l < n; l++) {
                                    possibleValues.remove((Integer) finalArr[j][l]);
                                    possibleValues.remove((Integer) finalArr[l][k]);
                                }

                                if (possibleValues.isEmpty()) {
                                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                                    return;
                                } else {
                                    finalArr[j][k] = possibleValues.get(0);
                                }
                            }
                        }
                    }

                    System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                    for (int[] row : finalArr) {
                        for (int value : row) {
                            System.out.print(value + " ");
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}