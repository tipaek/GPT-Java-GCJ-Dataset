
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) {
        FastReader fd = new FastReader();
        int t = fd.nextInt();
        for(int test = 1; test <= t; test++){
            int act = fd.nextInt();
            int count = 1;
            int[] start = new int[act];
            int[] end = new int[act];
            int jend = 0;
            int cend = 0;
            int jstart = 0;
            int cstart = 0;
            String opt = "";
            char lastAssign = 'J';
            for(int i = 0; i < act; i++){
                start[i] = fd.nextInt();
                end[i] = fd.nextInt();
            }
            jend = end[0];
            jstart = start[0];
            opt += lastAssign;
            for(int i = 1; i < act; i++){
                if(end[i] < jstart){
                    lastAssign = 'J';
                    count++;
                }
                else if(end[i] < cstart){
                    lastAssign = 'C';
                    count++;
                }
                else if(start[i] < jend){
                        if(start[i] >= cend){
                            lastAssign = 'C';
                            cend = end[i];
                            count++;
                        }
                }
                else if(start[i] < cend){
                    if( start[i] >= jend){
                        lastAssign = 'J';
                        jend = end[i];
                        count++;
                    }
                }

                else{
                    if(lastAssign == 'J'){jend = end[i];}
                    else{cend = end[i];}
                    count++;
                }
                opt += lastAssign;
            }
            if(count != act){
                System.out.println("Case #"+test+": IMPOSSIBLE");
                continue;
            }
            System.out.println("Case #"+test+": "+opt);
            opt = "";
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
