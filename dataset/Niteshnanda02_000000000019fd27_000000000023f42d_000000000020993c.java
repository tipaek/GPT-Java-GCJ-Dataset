
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = s.nextInt();
        for (int k = 1; k <= t; k++) {
            int n = s.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.nextInt();
                }
            }
            String ans = check(arr, n);
            System.out.println("case #" + k + ": " + ans);
        }
    }

    private static String check(int[][] arr, int n) {
        String a = "";
        int s = 0, r = 0, c = 0;
        for (int i = 0; i < n; i++) {
            s += arr[i][i];
            Set<Integer> setr = new HashSet<>();
            Set<Integer> setc = new HashSet<>();
            for (int j = 0; j < n; j++) {
                //row
                int vr = arr[i][j];
                setr.add(vr);
                //col
                int vc = arr[j][i];
                setc.add(vc);
            }
            if (setr.size() != n)
                r++;
            if (setc.size() != n)
                c++;
        }
        a = s + " " + r + " " + c;
        return a;
    }
}
