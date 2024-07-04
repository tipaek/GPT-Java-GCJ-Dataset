import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int t_i = 1; t_i <= test; ++t_i) {
            int ans = 0, key = 0;
            String sans = "";
            int n = Integer.parseInt(br.readLine());
            String sarr[] = new String[n];
            int arr[] = new int[n];

            for (int i = 0; i < n; ++i) {
                sarr[i] = br.readLine();
                arr[i] = sarr[i].length() - 1;
                if (ans < arr[i]) {
                    sans = sarr[i].substring(1, arr[i] + 1);
                    ans = arr[i];
                    key = i;
                }
            }
            boolean flag = true;
            for (int j = 1; j < ans; ++j) {
                char ch = sarr[key].charAt(arr[key]);
                for (int i = 0; i < n; ++i) {
                    if (sarr[i].charAt(arr[i]) == '*') {

                    } else if (sarr[i].charAt(arr[i]) == ch) {
                        arr[i]--;
                    } else {
                        // sb.append("\n" + sarr[i] + " at " + arr[i] + "\n");
                        flag = false;
                        break;
                    }
                }
                if (!flag)
                    break;
            }

            if (!flag)
                sans = "*";
            sb.append("Case #" + t_i + ": " + sans + "\n");
        }

        System.out.print(sb.toString());
    }
}