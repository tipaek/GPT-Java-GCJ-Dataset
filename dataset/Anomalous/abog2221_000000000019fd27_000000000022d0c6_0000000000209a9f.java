import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt();
        
        for (int z = 1; z <= t; z++) {
            String str = sc.next();
            int len = str.length();
            int[] val = new int[len];
            int max = 0;
            
            for (int i = 0; i < len; i++) {
                val[i] = str.charAt(i) - '0';
                if (val[i] > max) {
                    max = val[i];
                }
            }
            
            int count = 0;
            for (int i = 0; i < max; i++) {
                for (int e = 0; e < str.length(); e++) {
                    if (e < val.length && val[e] == (max - i)) {
                        val[e]--;
                        String temp = str.substring(0, e + count) + "(" + str.charAt(e + count) + ")";
                        if (e < str.length() - 1) {
                            temp += str.substring(e + count + 1);
                        }
                        str = temp;
                        count += 2;
                    }
                }
                
                for (int e = 0; e < str.length() - 1; e++) {
                    if (str.substring(e, e + 2).equals(")(")) {
                        str = str.substring(0, e) + str.substring(e + 2);
                    }
                }
            }
            
            out.println("Case #" + z + ": " + str);
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