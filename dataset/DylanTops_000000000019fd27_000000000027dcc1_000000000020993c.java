import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tests = Integer.parseInt(scan.nextLine());
        for (int test = 1; test <= tests; test++) {
            int n = Integer.parseInt(scan.nextLine());
            int arr[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer ints = new StringTokenizer(scan.nextLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(ints.nextToken());
                }
            }
            int k = 0, r = 0, c = 0;
            for (int i = 0; i < n; i++) {
                k += arr[i][i];
            }
            for (int i = 0; i < n; i++) {
                boolean b = false;
                for (int j = 0; j < n; j++) {
                    for (int j2 = 0; j2 < n; j2++) {
                        if (j != j2 && arr[i][j] == arr[i][j2]) {
                            r++;
                            b = true;
                        }
                        if (b) {
                            break;
                        }
                    }
                    if (b) {
                        break;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                boolean b = false;
                for (int j = 0; j < n; j++) {
                    for (int j2 = 0; j2 < n; j2++) {
                        if (j != j2 && arr[j][i] == arr[j2][i]) {
                            c++;
                            b = true;
                        }
                        if (b) {
                            break;
                        }
                    }
                    if (b) {
                        break;
                    }
                }
            }
            System.out.println("Case #" + test + ": " + k + " " + r + " " + c);
        }
    }
}