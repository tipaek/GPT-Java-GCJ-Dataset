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

        int t,n,s=0;
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            s=0;
            n=sc.nextInt();
            int m[][]=new int[n][n];
            for(int j=0;j<n;j++)
                for(int k=0;k<n;k++)
                {
                    m[j][k]=sc.nextInt();
                    if(j==k)
                        s=s+m[j][k];
                }


                int f=0;
                int r=0,c=0;
            for(int j=0;j<n;j++) {
                int ind[]=new int[n];
                f=0;
                for (int k = 0; k < n; k++) {
                    ind[m[j][k] - 1] += 1;
                    if (ind[m[j][k] - 1] > 1)
                        f = 1;
                }
                if (f == 1)
                    ++r;
            }

            for(int j=0;j<n;j++) {
                int ind[]=new int[n];
                f=0;
                for (int k = 0; k < n; k++) {
                    ind[m[k][j] - 1] += 1;
                    if (ind[m[k][j] - 1] > 1)
                        f = 1;
                }
                if (f == 1)
                    ++c;
            }

            System.out.println("Case #"+(i+1)+": "+s+" "+r+" "+c);

        }



    }
}