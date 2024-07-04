import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String [] args) {
        Read read = new Read();
        Integer t = read.nextInt();

        for (int i = 1; i <= t; i++) {
            String str = read.next();
            StringBuilder ans = new StringBuilder();
            Integer depth = 0;

            for (int j = 0; j < str.length(); j++) {
                int num = str.charAt(j) - '0';
//                System.out.println(num);
                for (int k = 0; k < num - depth; k++) {
                    ans.append('(');
                }
                depth = num;
                ans.append(str.charAt(j));
                if(j + 1 < str.length()) {
                    Integer next = str.charAt(j + 1) - '0';
                    for (int k = 0; depth > 0 && k < num - next; k++) {
                        ans.append(')');
                        depth--;
                    }
                }
            }

            for (int j = 0; j < depth; j++) {
                ans.append(')');
            }

            System.out.println("Case #" + i + ": " + ans.toString());
        }
    }

    static class Read {

        BufferedReader br;
        StringTokenizer st;

        private Read() {
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
}
