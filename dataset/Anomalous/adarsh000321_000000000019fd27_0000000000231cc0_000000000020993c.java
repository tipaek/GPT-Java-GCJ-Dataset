import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        for (int tst = 1; tst <= t; tst++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            long sum = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i == j) {
                        sum += arr[i][j];
                    }
                }
            }
            
            int r = 0;
            for (int i = 0; i < n; i++) {
                boolean[] vis = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (vis[arr[i][j]]) {
                        r++;
                        break;
                    } else {
                        vis[arr[i][j]] = true;
                    }
                }
            }
            
            int c = 0;
            for (int i = 0; i < n; i++) {
                boolean[] vis = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (vis[arr[j][i]]) {
                        c++;
                        break;
                    } else {
                        vis[arr[j][i]] = true;
                    }
                }
            }
            
            sb.append("Case #").append(tst).append(": ").append(sum).append(" ").append(r).append(" ").append(c).append("\n");
        }
        
        System.out.println(sb);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
}