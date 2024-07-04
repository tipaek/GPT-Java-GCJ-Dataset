import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;


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

        int t,x,y;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            x=sc.nextInt();
            y=sc.nextInt();
            String s=sc.next();
            int m=s.length();
            int flag=0;

            int xx=x;
            int yy=y;
            int sum=0;
            for(int j=0;j<m;j++)
            {
                char c=s.charAt(j);
                if(c=='N')
                    ++yy;
                else if(c=='S')
                    --yy;
                else if(c=='E')
                    ++xx;
                else if(c=='W')
                    --xx;

                sum=j+1;
                int cod=Math.abs(xx)+Math.abs(yy);

                if(sum>=cod)
                {
                    flag=1;
                    break;
                }
            }



            if(flag==1)
                System.out.println("Case #"+(i+1)+": "+sum);
            else
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");

        }


    }
}