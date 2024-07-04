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

                int j = 0;
                while (sum < trace) {
                    arr[j]++;
                    sum++;
                    j++;
                }

                int[][] res = new int[size][size];

                for (int r = 0; r < size; r++) {
                    for (int c = 0; c < size; c++) {
                        if (c == r) {
                            res[r][c] = arr[r];
                        } else if (c > r) {
                            res[r][c] = (arr[r] + c - r) % size;
                        } else {
                            res[r][c] = (arr[r] - r + c) % size;
                            if (res[r][c] < 0) {
                                res[r][c] += size;
                            }
                        }
                    }
                }

                boolean possible = true;
                for (int c = 0; c < size; c++) {
                    sum = 0;
                    for (int r = 0; r < size; r++) {
                        sum += res[r][c] == 0 ? size : res[r][c];
                    }
                    if (sum != size * (size + 1) / 2) {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                    for (int r = 0; r < size; r++) {
                        for (int c = 0; c < size; c++) {
                            System.out.print((res[r][c] == 0 ? size : res[r][c]) + " ");
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