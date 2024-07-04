import java.util.*;
import java.io.*;

public class Solution {
    public static String sequence(int[][] arr, int N) {
        int[] ar = new int[N];
        ar[0] = 1;

        for (int i = 1; i < N; i++) {
            int flag = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j][0] < arr[i][0] && arr[i][0] < arr[j][1] && arr[j][0] < arr[i][1] && arr[i][1] < arr[j][1]) {
                    flag--;
                }
            }
            if (flag == 1) {
                ar[i] = 0;
            } else if (flag == 0) {
                ar[i] = 1;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder seq = new StringBuilder("C");
        for (int k = 1; k < N; k++) {
            if (ar[k] == 1) {
                seq.append("C");
            } else {
                seq.append("J");
            }
        }
        return seq.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            int[][] arr = new int[N][2];
            for (int j = 0; j < N; j++) {
                arr[j][0] = in.nextInt();
                arr[j][1] = in.nextInt();
            }
            String seq = sequence(arr, N);
            System.out.println("Case #" + i + ": " + seq);
        }
    }
}