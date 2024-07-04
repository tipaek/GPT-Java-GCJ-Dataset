package Solution1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.StringTokenizer;

//Do not change the name of class.

class Solution 
{
    public static void main(String[] args)
    {
        FastReader fr = new FastReader();
        
        int t;
        t=fr.nextInt();
        
        for(int k=0;k<t;k++)
        {
            int n;
            
            n=fr.nextInt();
            int mat[][]=new int[n][n];
            int j,trace=0,re_row,re_col=0,row_count=0,col_count=0;
            int[] temp=new int[n];


            
            for(int i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    mat[i][j]=fr.nextInt();
                    
                }
                trace=trace+mat[i][i];
            }
            
            for(int i = 0; i < n; i++){
                for( j = 0; j < n; j++){
                    temp[j] = mat[i][j];
                }
                if(duplicate(temp)){
                    row_count++;
                }
            }
            
            
            for(j = 0; j < n; j++){
                for(int i = 0; i < n; i++){
                    temp[i] = mat[i][j];
                }
                if(duplicate(temp)){
                    col_count++;
                }
            }

        System.out.println("Case #"+(k+1)+": "+trace+" "+row_count+" "+col_count);
        
        }
       
        
    }
    
    
    private static boolean duplicate(int[] temp) 
    {
       
        boolean flag = false;
         for(int i = 0; i < temp.length; i++)
            {
                for(int j = 0; j < temp.length; j++)
                {
                    if((temp[i] == (temp[j])) && (i != j))
                    {
                        return true;
                    }
                }
            }
            return false;
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
