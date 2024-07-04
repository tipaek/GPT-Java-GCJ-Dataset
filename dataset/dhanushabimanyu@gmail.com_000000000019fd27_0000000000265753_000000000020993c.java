import java.util.Scanner;

public class Solution {

    static int[][] arr;

    public static int findrowdiff(int r, int n) {
        int d = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[r][i] == arr[r][j]) {
                    flag = false;
                    d=1;
                    break;
                }
            }
            if(flag==false)
                break;
        }
        return d;
    }

    public static int findcoldiff(int c, int n) {
        int d = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i][c] == arr[j][c]) {
                    flag = false;
                    d=1;
                    break;
                }
            }
            if(flag==false)
                break;
        }
        return d;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int k = 0, r = 0, c = 0;
            arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    arr[j][l] = s.nextInt();
                }
            }
            for (int j = 0; j < n; j++) {
                k += arr[j][j];
                r += findrowdiff(j, n);
                c += findcoldiff(j, n);
            }
            System.out.println(k + " " + r + " " + c);
        }

    }

}
