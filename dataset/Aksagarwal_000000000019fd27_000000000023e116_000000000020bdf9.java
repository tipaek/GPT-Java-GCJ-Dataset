
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(reader.readLine());
            StringBuilder ans = new StringBuilder();
            int c = 0, j = 0;
            int[][] arr = new int[n][3];
            for (int i = 0; i < n; i++) {
                String[] str = reader.readLine().split(" ");
                arr[i][0] = Integer.parseInt(str[0]);
                arr[i][1] = Integer.parseInt(str[1]);
                arr[i][2] = i;
            }

            Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0]));
            char[] ansArr = new char[n];
            int i;
            for (i = 0; i < n; i++) {
                if (c <= arr[i][0]) {
                    c = arr[i][1];  ansArr[arr[i][2]] = 'C';
                } else if (j <= arr[i][0]) {
                    j = arr[i][1];  ansArr[arr[i][2]] = 'J';
                } else {
                    ans = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            if(i==n)
                ans = new StringBuilder(String.valueOf(ansArr));
            System.out.printf("Case #%d: %s\n", t, ans);

        }

    }

}
