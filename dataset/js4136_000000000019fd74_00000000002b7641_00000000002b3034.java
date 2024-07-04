import java.io.*;
import java.util.*;

public class Solution
{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class  Data{
        int start;
        int end ;
        int index;

        public Data(int start, int end, int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }

    }

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            boolean test = false;
            String first = s.nextLine();
            for(int j=1; j<n; j++){
                String p = s.nextLine();
                boolean check = p.charAt(0) =='*' && first.charAt(0)=='*';
                if(check &&p.length() > first.length() && p.contains(first.substring(1))){
                     first=p;
                } else if(check && first.length() > p.length() && first.contains(p.substring(1))){
                    first = first;
                } else{
                    test = true;
                    break;

                }
            }
            if(test){
                System.out.println("Case #"+ (i+1)+": "+ "*");
            } else {
                System.out.println("Case #"+ (i+1)+": "+ first.substring(1));
            }

        }
    }
}