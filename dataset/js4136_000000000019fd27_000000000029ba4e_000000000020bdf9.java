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

    public static void main(String[] args) throws IOException
    {
        FastReader s=new FastReader();
        int t = s.nextInt();
        for(int i=0; i<t; i++){
            int n = s.nextInt();
            int arr[][] = new int[n][2];
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                arr[j][0] = s.nextInt();
                arr[j][1] = s.nextInt();
            }
            Arrays.sort(arr, (i1, i2) -> Integer.compare(i1[0], i2[0]));
            int endC =0, endJ =0;
            boolean invalid = false;
            for(int j=0; j<n;j++){
                int val[] = arr[j];
                if(val[0] >= endC){
                    endC = val[1];
                    sb.append("C");
                } else if(val[0] >= endJ){
                    endJ = val[1];
                    sb.append("J");
                } else{
                    invalid = true;
                    break;
                }
            }
            if(invalid){
                System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
            }
            System.out.println("Case #"+(i+1)+": "+sb.toString());
        }
    }

}