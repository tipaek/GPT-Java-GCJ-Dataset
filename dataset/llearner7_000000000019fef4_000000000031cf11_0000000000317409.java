import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        ModScanner ms = new ModScanner();
        int t = ms.nextInt();
        int tc = 0;
        while (t-- > 0) {
            tc++;
            int x = ms.nextInt();
            int y = ms.nextInt();
            String m = ms.nextToken();
            String str;
            char[] M = m.toCharArray();
            int ans = -1;
            if (x == 0 && y == 0) {
                ans = 0;
            } else {
                for (int i = 0; i < M.length; i++) {
                    if (M[i] == 'N') {
                        y++;
                    } else if (M[i] == 'S') {
                        y--;
                    }  else if (M[i] == 'E') {
                        x++;
                    }  else if (M[i] == 'W') {
                        x--;
                    }
                    if (Math.abs(x) + Math.abs(y) <= (i+1)) {
                        ans = (i+1);
                        break;
                    }
                }
            }
            if (ans != -1) {
                System.out.println("Case #"+tc+": "+ans);
            } else {
                System.out.println("Case #"+tc+": IMPOSSIBLE");
            }
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