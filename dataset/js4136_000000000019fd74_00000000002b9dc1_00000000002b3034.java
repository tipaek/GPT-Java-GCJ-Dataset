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
                if(p.length() >= first.length()){
                    int b = p.length()-1;
                    for(int k = first.length()-1; k>0; k--){
                        if(first.charAt(k) != p.charAt(b)){
                            test = true;
                            break;
                        }
                        b--;
                    }
                    first = p;
                }else if(p.length() < first.length()){
                    int b = first.length()-1;
                    for(int k = p.length()-1; k>0; k--){
                        if(p.charAt(k) != first.charAt(b)){
                            test = true;
                            break;
                        }
                        b--;
                    }
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