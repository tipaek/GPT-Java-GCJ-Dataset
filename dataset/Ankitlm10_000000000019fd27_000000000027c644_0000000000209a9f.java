import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {


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
        FastReader sc = new FastReader();
        int tcs = sc.nextInt();
        for (int p = 0; p < tcs; p++) {
            String s = sc.next();
            StringBuilder ans  = new StringBuilder("");
            int opening = 0;
            for(int i=0;i<s.length();i++)
            {
                int curr =s.charAt(i)-'0';
                if(opening<curr)
                {
                    for(int j = opening+1 ; j<=curr ; j++)
                        ans.append("(");
                }

                else if(opening>curr)
            {
                for(int j = opening-1 ; j>=curr ; j--)
                    ans.append(")");
            }
                ans.append(s.charAt(i));
                opening = curr;
            }
            for(int j = opening ; j>=1 ; j--)
                ans.append(")");

            System.out.println("Case #"+(p+1)+": "+ans);
        }

    }
}