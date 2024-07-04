import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int MAX = 105;
    public static void main(String[] args) {
        Utility.FastReader fr = new Utility.FastReader();
        int t, n;
        t = fr.nextInt();
        boolean[][] used = new boolean[MAX][MAX];
        int[][] mat = new int[MAX][MAX];
        int test_num = 0;
        while(t-- > 0){
            test_num++;
            n = fr.nextInt();
            for(int i=1; i<=n; ++i){
                for(int j=1; j<=n; ++j){
                    used[i][j] = false;
                    mat[i][j] = fr.nextInt();
                }
            }
            int ele, r = 0, c = 0, s = 0;
            for(int i=1; i<=n; ++i){
                for(int j=1; j<=n; ++j){
                    ele = mat[i][j];
                    if(used[i][ele]){
                        r++;
                        break;
                    }
                    used[i][ele] = true;
                }
            }
            for(int i=1; i<=n; ++i){
                for(int j=1; j<=n; ++j) used[i][j] = false;
            }
            for(int i=1; i<=n; ++i){
                for(int j=1; j<=n; ++j){
                    ele = mat[j][i];
                    if(used[ele][i]){
                        c++;
                        break;
                    }
                    used[ele][i] = true;
                }
            }
            for(int i=1; i<=n; ++i) s += mat[i][i];
            System.out.println("Case #" + test_num +": "+s+" "+r+" "+c);
        }
    }

    static class Utility {
        static class FastReader {
            BufferedReader br;
            StringTokenizer st;

            public FastReader() {
                br = new BufferedReader(new
                        InputStreamReader(System.in));
            }

            String next() {
                while (st == null || !st.hasMoreElements()) {
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return st.nextToken();
            }

            int nextInt() {
                return Integer.parseInt(next());
            }

            long nextLong() {
                return Long.parseLong(next());
            }

            double nextDouble() {
                return Double.parseDouble(next());
            }

            String nextLine() {
                String str = "";
                try {
                    str = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return str;
            }
        }

        public static void main(String[] args) {
            FastReader s = new FastReader();
            int n = s.nextInt();
            int k = s.nextInt();
            int count = 0;
            while (n-- > 0) {
                int x = s.nextInt();
                if (x % k == 0)
                    count++;
            }
            System.out.println(count);
        }
    }
}
