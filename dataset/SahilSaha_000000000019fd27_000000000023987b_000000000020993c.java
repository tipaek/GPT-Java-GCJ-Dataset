import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[]) 
    {
         Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int k = 1; k <= t; ++k) 
        {
            int sumT = 0;
            int sr = 0;
            int sc = 0;
            int N = in.nextInt();
            int mat[][] = new int[N][N];
            
            for(int i=0; i<N; i++)
            {
                int flag = 0;
                List<Integer> cr = new ArrayList<>();
                for(int j=0; j<N; j++)
                {
                    mat[i][j] = in.nextInt();
                    if(cr.contains(mat[i][j]) && flag==0)
                    {
                        sr++;
                        flag = 1;
                    }
                    cr.add(mat[i][j]);
                    if(i==j)
                        sumT+=mat[i][j];
                }
            }
            for(int j=0; j<N; j++)
            {
                int flag = 0;
                List<Integer> cc = new ArrayList<>();
                for(int i=0; i<N; i++)
                {
                    if(cc.contains(mat[i][j]) && flag==0)
                    {
                        sc++;
                        flag = 1;
                    }
                    cc.add(mat[i][j]);
                }
            }
            System.out.println("Case #"+k+": "+sumT+" "+sr+" "+sc);
        }
    }
}