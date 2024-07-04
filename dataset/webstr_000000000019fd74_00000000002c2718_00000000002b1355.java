import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t1 = in.nextInt();
        for (int t = 1; t <= t1; t++) {
            int r = in.nextInt();
            int c = in.nextInt();
            int[][] arr = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            long s = calc(arr, r, c);

            while (goTurn(arr, r, c)) {
                s += calc(arr, r, c);
            }


            System.out.println("Case #" + t + ": " + s);
        }
    }

    public static boolean goTurn(int[][] arr, int r, int c) {
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();

        boolean isChanged = false;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] > 0) {
                    int k = 1;
                    int z = 0;
                    int count = 0;
                    while (i - k >= 0) {
                        if (arr[i - k][j] > 0) {
                            z += arr[i - k][j];
                            count++;
                            break;
                        } else {
                            k++;
                        }
                    }
                    k = 1;
                    while (i + k < r) {
                        if (arr[i + k][j] > 0) {
                            z += arr[i + k][j];
                            count++;
                            break;
                        } else {
                            k++;
                        }
                    }
                    k = 1;
                    while (j - k >= 0) {
                        if (arr[i][j - k] > 0) {
                            z += arr[i][j - k];
                            count++;
                            break;
                        } else {
                            k++;
                        }
                    }
                    k = 1;
                    while (j + k < c) {
                        if (arr[i][j + k] > 0) {
                            z += arr[i][j + k];
                            count++;
                            break;
                        } else {
                            k++;
                        }
                    }
                    if (count > 0 && count * arr[i][j] < z) {
                        isChanged = true;
                        res1.add(i);
                        res2.add(j);
                    }
                }
            }
        }

        for (int i = 0; i < res1.size(); i++) {
            arr[res1.get(i)][res2.get(i)] = -1;
        }
        return isChanged;
    }

    public static long calc(int[][] arr, int r, int c) {
        long res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] > 0) {
                    res += arr[i][j];
                }
            }
        }
        return res;
    }
}