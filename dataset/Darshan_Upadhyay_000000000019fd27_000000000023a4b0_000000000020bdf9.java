import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.Comparator;


class Solution {
    public static void main(String[] args) throws IOException {

        FastReader sc=new FastReader();
        int n =sc.nextInt();
        int i=0,k=0;

        for (k=0;k<n;k++)
        {
            String out="";
            boolean possible=true;
            boolean cfree=true;
            boolean jfree=true;
            int cind=-1;
            int jind=-1;
            int activities=sc.nextInt();
            int timings[][]=new int[activities][2];
            for (i=0;i<activities;i++)
            {
                timings[i][0]=sc.nextInt();
                timings[i][1]=sc.nextInt();
            }
            Arrays.sort(timings, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }
            });
            for (i=0;i<activities;i++)
            {
                int current=timings[i][0];

                if (cind==-1 || timings[cind][1]<=current)
                {
                    out+="C";
                    cind=i;

                }
                else if (jind==-1 || timings[jind][1]<=current)
                {

                    out+="J";
                    jind=i;
                }
                else
                {
                    possible=false;
                    break;
                }

            }


            if (possible)
            {
                System.out.println("Case #"+(k+1)+": "+out);
            }
            else {
                System.out.println("Case #" + (k + 1) + ": IMPOSSIBLE");
            }

        }

        //System.out.println("Case #"+(k+1)+": "+a+" "+b);
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