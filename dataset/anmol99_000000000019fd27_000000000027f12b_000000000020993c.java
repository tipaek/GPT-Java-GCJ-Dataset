import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = s.nextInt();
        int U = T;
        while(T>0)
        {
            int N  = s.nextInt();
            int mat[][] = new int[N][N];
            int rc = 0,cc = 0,trace = 0;
            for(int i = 0;i<N;++i)
            {
                HashSet<Integer> hset = new HashSet<>();
                int flag = 0;
                for(int j = 0;j<N;++j)
                {
                    mat[i][j] = s.nextInt();
                    if(hset.contains(mat[i][j]) && flag == 0)
                    {
                        flag = 1;
                        rc++;
                    }
                    hset.add(mat[i][j]);
                    if(i == j)
                    {
                        trace+=mat[i][i];
                    }
                }
            }
            
            
            for(int i = 0;i<N;++i)
            {
                HashSet<Integer> hset = new HashSet<>();
                int flag = 0;
                for(int j = 0;j<N;++j)
                {
                    if(hset.contains(mat[j][i]) && flag == 0)
                    {
                        flag = 1;
                        cc++;
                    }
                    hset.add(mat[j][i]);
                }
            }
            
            
            System.out.println("Case #" + (U-T+1) + ": " + trace + " " + rc + " " + cc);
            
            T--;
        }
    }
}