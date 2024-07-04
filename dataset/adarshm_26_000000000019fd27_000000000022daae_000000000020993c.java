import java.io.InputStream;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int t = in.nextInt();
        int n, sum, r, c;
        int[][] mat;
        boolean rfnd, cfnd;
        HashSet<Integer> rset = new HashSet<>();
        for (int z = 0; z < t; z++) {
            n = in.nextInt();
            mat = new int[n][n];
            sum = r = c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = in.nextInt();
                    if(i == j) sum += mat[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                rset.clear();
                rfnd = false;
                for (int j = 0; j < n; j++) {
                    if(!rset.contains(mat[i][j]))
                        rset.add(mat[i][j]);
                    else {
                        rfnd = true;
                        break;
                    }
                }
                if(rfnd) r++;
            }
            for (int i = 0; i < n; i++) {
                rset.clear();
                cfnd = false;
                for (int j = 0; j < n; j++) {
                    if(!rset.contains(mat[j][i]))
                        rset.add(mat[j][i]);
                    else {
                        cfnd = true;
                        break;
                    }
                }
                if(cfnd) c++;
            }
            pw.println("Case #" + (z + 1) + ": " + sum + " " + r + " " + c);
        }
        pw.close();
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
            st = null;
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
