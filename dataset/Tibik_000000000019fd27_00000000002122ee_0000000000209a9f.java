import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static StringTokenizer st;
    static BufferedReader br;
    static PrintWriter pw;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        run();
        pw.close();
    }

    private static void run() {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            String s = nextToken();
            ArrayList<Character> ans = new ArrayList<>(s.length() * 2);
            int now = 0;
            for (int j = 0; j < s.length(); j++) {
                int k = s.charAt(j) - '0';
                while (now < k) {
                    now++;
                    ans.add('(');
                }
                while (now > k) {
                    now--;
                    ans.add(')');
                }
                ans.add((char) (k + '0'));
            }
            while (now > 0) {
                now--;
                ans.add(')');
            }
            pw.print("Case #" + (i + 1) + ": ");
            for (int j = 0; j < ans.size(); j++) {
                pw.print(ans.get(j));
            }
            pw.println();
        }
    }
}
