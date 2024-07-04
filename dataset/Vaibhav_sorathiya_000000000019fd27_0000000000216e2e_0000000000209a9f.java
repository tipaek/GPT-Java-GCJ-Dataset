import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) {
        FastReader fd = new FastReader();
        int t = fd.nextInt();
        for(int test = 1; test <= t; test++){
            String s = fd.next();
            int totalBrac = 0;
            int opened = 0;
            int closed = 0;
            StringBuilder opt = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                int val = Integer.parseInt(String.valueOf(s.charAt(i)));
                if(val > opened){
                        while(opened != val){
                            opt.append("(");
                            opened++;
                            closed++;
                        }

                    }else{

                    while (closed != val){
                            opt.append(")");
                            closed--;
                            opened--;
                        }
                    }

                opt.append(val);
            }
            while(closed > 0){
                opt.append(")");
                closed--;
            }
            System.out.println("Case #"+test+": "+opt);

        }
    }
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
                catch (IOException e)
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
}
