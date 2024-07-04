import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int size = sc.nextInt();
            int trace = sc.nextInt();

            if (trace <= size * size) {
                int[] arr = new int[size];
                int sum = 0;

                for (int j = 0; j < size; j++) {
                    arr[j] = trace / size;
                    sum += arr[j];
                }

                for (int j = 0; sum < trace; j = (j + 1) % size) {
                    arr[j]++;
                    sum++;
                }

                int[][] res = new int[size][size];
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        if (k == j) {
                            res[j][k] = arr[j];
                        } else if (k > j) {
                            res[j][k] = (arr[j] + k - j) % size;
                        } else {
                            res[j][k] = (arr[j] - j + k) % size;
                            if (res[j][k] < 0) res[j][k] += size;
                        }
                    }
                }

                boolean isPossible = true;
                for (int j = 0; j < size; j++) {
                    sum = 0;
                    for (int k = 0; k < size; k++) {
                        sum += res[k][j] == 0 ? size : res[k][j];
                    }
                    if (sum != size * (size + 1) / 2) {
                        isPossible = false;
                        break;
                    }
                }

                System.out.println("Case #" + (i + 1) + ": " + (isPossible ? "POSSIBLE" : "IMPOSSIBLE"));
                if (isPossible) {
                    for (int[] row : res) {
                        for (int val : row) {
                            System.out.print(val == 0 ? size : val);
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}