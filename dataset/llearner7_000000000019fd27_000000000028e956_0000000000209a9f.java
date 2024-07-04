
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        ModScanner ms = new ModScanner();
        int t = ms.nextInt();
        int tc = 0;
        while(t-- >0) {
            String s = ms.nextToken();
            tc++;
            StringBuilder sb = new StringBuilder();
            int open = 0;
            for (int i=0;i<s.length();i++) {
                int curr = s.charAt(i) - '0';
                if (curr > open) {
                    open = curr - open;
                    for (int j = 0; j < open; j++) {
                        sb.append('(');
                    }
                    open = curr;
                } else if (curr < open){
                    open = open - curr;
                    for (int j = 0; j < open; j++) {
                        sb.append(')');
                    }
                    open = curr;
                }
                sb.append(s.charAt(i));
            }
            for (int i = 0; i < open; i++) {
                sb.append(')');
            }
            System.out.println("Case #"+tc+": "+ sb);
        }
    }
}


class ModScanner {
    BufferedReader br;
    StringTokenizer st;

    public ModScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String nextToken() throws Exception {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());

        }
        return st.nextToken();
    }

    String nextString() throws Exception {
        return br.readLine();
    }


    int nextInt() throws Exception, Exception {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}
