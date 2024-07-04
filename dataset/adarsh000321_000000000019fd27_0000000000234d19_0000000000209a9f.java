import java.awt.*;
import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int t=sc.nextInt();
        StringBuilder ans=new StringBuilder();
        for (int tst=1;tst<=t;tst++) {
            StringBuilder sb=new StringBuilder();
            String s=sc.next();
            int n=s.length();
            sb.append("Case #"+tst+": ");
            for (int i='1';i<=s.charAt(0);i++){
                sb.append('(');
            }
            for (int i=0;i+1<n;i++){
                sb.append(s.charAt(i));
                if (s.charAt(i)>s.charAt(i+1)){
                    for (int j=1;j<=s.charAt(i)-s.charAt(i+1);j++){
                        sb.append(')');
                    }
                }else if (s.charAt(i)<s.charAt(i+1)){
                    for (int j='1';j<=s.charAt(i);j++){
                        sb.append(')');
                    }
                    for (int j='1';j<=s.charAt(i+1);j++){
                        sb.append('(');
                    }
                }
            }
            sb.append(s.charAt(n-1));
            for (int i='1';i<=s.charAt(n-1);i++){
                sb.append(')');
            }
            sb.append("\n");
            ans.append(sb);
        }
        System.out.print(ans);
    }
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
}