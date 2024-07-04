import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int k = 1; k <= t; ++k) {
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            for(int i = 0; i < n; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
            }
            Arrays.sort(arr, (int[] a1, int[] a2) -> {
                if(a1[0] == a2[0])
                    return a1[1] - a2[1];
                return a1[0] - a2[0];
            });

            int c = 0, j = 0;
            StringBuilder ans = new StringBuilder();
            boolean impossible = false;
            for(int i = 0; i < n; i++) {
                if(c < j) {
                    if(c <= arr[i][0]) {
                        c = arr[i][1];
                        ans.append('C');
                    } else {
                        impossible = true;
                        break;
                    }
                } else {
                    if(j <= arr[i][0]) {
                        j = arr[i][1];
                        ans.append('J');
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }
            if(impossible)
                ans = new StringBuilder("IMPOSSIBLE");
            System.out.println("Case #" + k + ": " + ans);
        }
    }
}