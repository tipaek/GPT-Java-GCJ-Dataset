
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        ModScanner ms = new ModScanner();
        int t = ms.nextInt();
        int tc = 0;
        while(t-- >0) {
            int n = ms.nextInt();
            tc++;
            int[][] mat = new int[n][n];
            int r = 0;
            Set<Integer> unique = new HashSet<>();
            for (int i=0; i < n;i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = ms.nextInt();
                    unique.add(mat[i][j]);
                }
                if (unique.size() != n) {
                    r++;
                }
                unique.clear();
            }
            int c = 0;
            for (int i=0; i < n;i++) {
                for (int j = 0; j < n; j++) {
                    unique.add(mat[j][i]);
                }
                if (unique.size() != n) {
                    c++;
                }
                unique.clear();
            }
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += mat[i][i];
            }
            System.out.println("Case #"+tc+": "+ trace + " " + r + " "+c);
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