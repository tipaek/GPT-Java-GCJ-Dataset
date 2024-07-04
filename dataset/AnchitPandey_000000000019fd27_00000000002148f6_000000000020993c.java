import java.io.*;
import java.util.*;

class Solution
{
    public static void main (String[] args)throws Exception
    {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(buff.readLine());
        for (int test=1; test<=testcase;test+=1)
        {
            int n = Integer.parseInt(buff.readLine());
            int[][] mat  = new int[n][n];
            for (int i = 0 ; i< n;i+=1)
            {
                String[] inp = buff.readLine().split("\\s+");
                for (int j =0; j< n;j+=1)
                    mat[i][j] = Integer.parseInt(inp[j]);
            }
            // trace
            int sum  =0;
            for (int i =0 ;i < n;i+=1)
            sum += mat [i][i];
            
            // rows 
            int r  =0; 
            for (int i =0 ;  i< n;i+=1)
            {
                HashMap<Integer, Integer> mapper =new HashMap<Integer, Integer>();
                for (int j =0 ; j< n;j+=1)
                {
                    if (!mapper.containsKey(mat[i][j]))
                    mapper.put (mat[i][j],1);
                    else
                    {
                        r+=1;
                        break;
                    }
                }
            }
            // columns
            int c  =0; 
            for (int i =0 ;  i< n;i+=1)
            {
                HashMap<Integer, Integer> mapper =new HashMap<Integer, Integer>();
                for (int j =0 ; j< n;j+=1)
                {
                    if (!mapper.containsKey(mat[j][i]))
                    mapper.put (mat[j][i],1);
                    else
                    {
                        c+=1;
                        break;
                    }
                }
            }
    
    System.out.println("Case #"+String.valueOf(test)+": "+String.valueOf(sum)+" "+ String.valueOf(r)+" "+String.valueOf(c));
                
        }
    }
}