
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
   static   Integer arr[];
   static int b[];
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

        FastReader sc = new FastReader();

        int t=sc.nextInt();
        int x=0;
        while (t-->0)
        {
            int n = sc.nextInt();
            String st[] = new String[n];
            for(int i=0;i<n;i++)
            {
                st[i]=sc.next();
            }
            int maxLength = 0;
            String longestString = null;
            for (String s : st)
            {
                if (s.length() > maxLength)
                {
                    maxLength = s.length();
                    longestString = s;
                }
            }
            boolean flag = false;
            longestString = longestString.substring(1, longestString.length());
            for(int i=n-1;i>=0;i--)
            {
                int k = 0;
                int lo = longestString.length()-1;
                for(int j=st[i].length()-1;j>=1;j--)
                {
                    if(longestString.charAt(lo)!=st[i].charAt(j))
                    {
                        k = -1;
                        break;
                    }
                    lo--;
                }
                if(k==-1)
                {
                    flag = true;
                }
            }
            x++;
            if(!flag)
            {
                System.out.println("Case #"+(x)+": "+longestString);
            }
            else
            {
                System.out.println("Case #"+(x)+": *");
            }
        }
    }
}