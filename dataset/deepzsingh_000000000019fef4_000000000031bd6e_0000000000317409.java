
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class  Solution {
    static Integer n, arr[];
    static long mod = 998244353;

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

    public static void main(String[] args) {
        FastReader sc=new FastReader();
        int t=sc.nextInt();
        int mm=0;
        while (t-->0) {
            int x=sc.nextInt(),y=sc.nextInt();
            String s=sc.next();
            int cnt=0;
            String st="";
            StringBuilder sb=new StringBuilder();
             if ( s.length()==1 && y>x)
            {
                sb.append(y-x);
               // break;
            }
            for (int i=0;i<s.length()-1;i++)
            {
                if (x==y && s.charAt(i)==s.charAt(i+1))
                {
                    sb.append(x);
                    break;
                }else if ( y>x && s.charAt(i)==s.charAt(i+1))
                {
                    sb.append(y-x);
                    break;
                }
                else {
                    sb.append("IMPOSSIBLE");
                    break;
                }
            }
            mm++;
            System.out.println("Case #"+mm+": "+sb.toString());



        }
    }
}
