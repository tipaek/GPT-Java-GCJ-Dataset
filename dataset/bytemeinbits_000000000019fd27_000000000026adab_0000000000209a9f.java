import java.io.*;
import java.util.*;

public class Solution {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException  e) {
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
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        int test = 0;
        while(++test <= t) {
            String[] s = fr.nextLine().split("");
            String res = "";
            int leftParen = 0;
            Map<Integer, String> left = new HashMap<>();
            left.put(0, "");
            Map<Integer, String> right = new HashMap<>();
            right.put(0, "");
            String dumbLeft = "";
            String dumbRight = "";
            for(int i = 1; i<10; i++) {
                dumbLeft += "(";
                dumbRight += ")";
                left.put(i, dumbLeft);
                right.put(i, dumbRight);
            }
//            res += left.get(leftParen);

            for(int i = 0; i < s.length; i++) {
                int num = Integer.parseInt(s[i]);
//                System.out.println("num " + num + " res " + res + " left paren" + leftParen + " left.get(leftParen) " + left.get(leftParen));
                if(leftParen < num) {
                    res += left.get(num - leftParen);
                } else if(leftParen > num) {
                    res += right.get(leftParen - num );
                }
                leftParen = num;
                res += num;
            }

            res += right.get(leftParen);

            System.out.println("Case #" + test + ": " + res);
        }
    }
}