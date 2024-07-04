import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt();
        
        for (int z = 1; z <= t; z++) {
            String str = sc.next();
            StringBuilder res = new StringBuilder();
            int len = str.length();
            int[] val = new int[len];
            
            for (int i = 0; i < len; i++) {
                val[i] = str.charAt(i) - '0';
            }
            
            for (int i = 0; i < val[0]; i++) {
                res.append('(');
            }
            res.append(val[0]);
            
            for (int i = 1; i < len; i++) {
                int diff = val[i - 1] - val[i];
                if (diff > 0) {
                    for (int e = 0; e < diff; e++) {
                        res.append(')');
                    }
                } else {
                    for (int e = 0; e > diff; e--) {
                        res.append('(');
                    }
                }
                res.append(val[i]);
            }
            
            for (int i = 0; i < val[len - 1]; i++) {
                res.append(')');
            }
            
            out.println("Case #" + z + ": " + res.toString());
        }
        
        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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