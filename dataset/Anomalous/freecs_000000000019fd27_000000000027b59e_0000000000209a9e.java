import java.util.*;
import java.io.*;

public class Solution {

    public void solve(int test, Scanner sc) {
        int t = sc.nextInt();
        int b = sc.nextInt();

        while (t > 0) {
            int sameI = -1;
            int diffI = -1;
            int[] arr = new int[b + 1];
            int len = (b + 1) / 2;
            int iter = 1;

            for (int i = 1; i <= len; i++) {
                if (iter % 10 == 1) {
                    handleSameIndexQuery(sc, sameI, arr, i, b);
                    iter++;
                    i--;
                } else if (iter % 10 == 2) {
                    handleDiffIndexQuery(sc, diffI, arr, i, b);
                    iter++;
                    i--;
                } else {
                    performBitQuery(sc, arr, i, b);
                    if (sameI < 0 && arr[i] == arr[b - i + 1]) {
                        sameI = i;
                    } else if (diffI < 0 && arr[i] != arr[b - i + 1]) {
                        diffI = i;
                    }
                    iter += 2;
                }
            }

            StringBuilder strBuild = new StringBuilder();
            for (int i = 1; i <= b; i++) {
                strBuild.append(arr[i]);
            }

            System.out.println(strBuild.toString());
            String response = sc.next();
            if (response.equals("N")) {
                return;
            }

            t--;
        }
    }

    private void handleSameIndexQuery(Scanner sc, int sameI, int[] arr, int i, int b) {
        if (sameI > 0) {
            System.out.println(sameI);
            int bit = sc.next().charAt(0) - '0';
            if (bit != arr[sameI]) {
                for (int j = sameI; j < i; j++) {
                    if (arr[j] == arr[b - j + 1]) {
                        arr[j] = 1 - arr[j];
                        arr[b - j + 1] = 1 - arr[b - j + 1];
                    }
                }
            }
        } else {
            System.out.println("1");
            sc.next();
        }
    }

    private void handleDiffIndexQuery(Scanner sc, int diffI, int[] arr, int i, int b) {
        if (diffI > 0) {
            System.out.println(diffI);
            int bit = sc.next().charAt(0) - '0';
            if (bit != arr[diffI]) {
                for (int j = diffI; j < i; j++) {
                    if (arr[j] != arr[b - j + 1]) {
                        arr[j] = 1 - arr[j];
                        arr[b - j + 1] = 1 - arr[b - j + 1];
                    }
                }
            }
        } else {
            System.out.println("1");
            sc.next();
        }
    }

    private void performBitQuery(Scanner sc, int[] arr, int i, int b) {
        System.out.println(i);
        arr[i] = sc.next().charAt(0) - '0';
        int sec = b - i + 1;
        System.out.println(sec);
        arr[sec] = sc.next().charAt(0) - '0';
    }

    public Solution() {
        Scanner sc = new Scanner(System.in);
        int tests = 1;

        for (int t = 1; t <= tests; t++) {
            solve(t, sc);
        }
    }

    public static void main(String[] args) {
        new Solution();
    }
}