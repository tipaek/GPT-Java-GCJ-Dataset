

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static FastReader sc=new FastReader();
    public static void main(String[] args)
    {

        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int res[]=solve(sc.nextInt());
            System.out.println("Case #"+i+": "+res[0]+" "+res[1]+" "+res[2]);
        }



    }


    static int[] solve(int N)
    {
        int res[]=new int[3];
        boolean list[]=new boolean[10];
        int rowc=0;
        int colc=0;
        int sum=0;
        // Input
        int matrix[][]=new int[N][N];
        for (int i=0; i<N; i++) {

            // Initialize list with false
            boolean flag=false;
            for(int k=0;k<10;k++)
            {
                list[k]=false;
            }



            for (int j=0; j<N; j++) {

                matrix[i][j]=sc.nextInt();

                if(!flag)
                    if(list[matrix[i][j]]==false)
                        list[matrix[i][j]]=true;
                    else
                        flag=true;





                if(i==j) // Compute Trace
                {
                    sum+=matrix[i][j];
                }


            }

            if(flag)
                rowc++;
        }


        for (int i = 0; i < N; i++) {

            boolean flag=false;
            for(int k=0;k<10;k++)
            {
                list[k]=false;
            }

            for (int j = 0; j < N; j++) {
                if(!flag)
                    if(list[matrix[j][i]]==false)
                        list[matrix[j][i]]=true;
                    else
                        flag=true;
            }

            if(flag)
                colc++;

        }



        res[0]=sum;
        res[1]=rowc;
        res[2]=colc;






        return res;
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





}
