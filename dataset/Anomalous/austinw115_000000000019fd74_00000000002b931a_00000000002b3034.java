import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String[] arr = new String[N];
            String longest = "*";

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                String P = st.nextToken();
                if (P.length() > longest.length()) {
                    longest = P;
                }
                arr[j] = P;
            }

            String ans = longest;

            for (String s1 : arr) {
                if (!s1.equals(longest)) {
                    if (s1.length() > 1) {
                        s1 = s1.substring(1);
                    }

                    if (!longest.contains(s1)) {
                        ans = "*";
                        break;
                    }
                }
            }

            pw.println("Case #" + i + ": " + ans);
        }
        pw.close();
    }
}