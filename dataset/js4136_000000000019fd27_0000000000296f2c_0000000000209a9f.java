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
            String str = s.nextLine();
            char arr[] = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            int count = Character.getNumericValue(arr[0]);
            for(int j=0; j<count; j++){
                sb.append("(");
            }
            for(char ch: arr){
                int val = Character.getNumericValue(ch);

                int diff = val-count;
                //System.out.println("diff...."+diff);
                if(diff <0){
                    diff = -diff;
                    for(int j=0; j<diff; j++){
                        sb.append(")");
                    }
                } else if(diff >0){
                    for(int j=0; j<diff; j++){
                        sb.append("(");
                    }
                }
                sb.append(ch);
                count = val;
            }

            for(int j=0; j<count; j++){
                sb.append(")");
            }
            //Case #1:
            System.out.println("Case #"+(i+1)+": "+sb.toString());
        }
    }

}