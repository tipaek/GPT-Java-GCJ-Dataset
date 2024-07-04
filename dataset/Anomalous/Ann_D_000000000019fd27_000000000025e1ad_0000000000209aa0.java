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

                if (sum < trace) {
                    int j = 0;
                    while (sum < trace) {
                        arr[j]++;
                        sum++;
                        j++;
                    }
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
                        }
                    }
                }

                boolean isPossible = true;
                for (int j = 0; j < size; j++) {
                    sum = 0;
                    for (int k = 0; k < size; k++) {
                        sum += res[k][j];
                    }
                    if (sum != size * (size + 1) / 2) {
                        isPossible = false;
                        break;
                    }
                }

                if (isPossible) {
                    System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                    for (int j = 0; j < size; j++) {
                        for (int k = 0; k < size; k++) {
                            System.out.print(res[j][k] == 0 ? 5 : res[j][k]);
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                }

            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}