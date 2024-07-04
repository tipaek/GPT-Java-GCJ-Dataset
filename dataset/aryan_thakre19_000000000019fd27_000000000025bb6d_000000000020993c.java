import java.util.*;

public class Main
{
    
    
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int i,j,k=0;
        String S = "Case #";
        
        while(t-- > 0)
        {
            int N = s.nextInt();
            int[] row = new int[N];
            int[] col = new int[N];
            int[][] mat = new int[N][N];
            for(i=0;i<N;i++)
            {
                for(j=0;j<N;j++)
                {
                    mat[i][j] = s.nextInt();
                    if(i == j)
                    k += mat[i][j];
                    
                    
                }
            }
            
            /*int r=0;
            for(i=0;i<N;i++)
            {
                for(j=0;j<N;j++)
                {
                    if(check(row,mat[i][j]) == false)
                    {
                        
                    }
                }
            }*/
            String str = Integer.toString(t);
            S = S+str;
            
            System.out.println(S + "" + k);
            
            
            
            
            
            
        }
    }
    
    public static boolean check(int[] r,int e)
    {
        int i,flag=0;
        for(i=0;i<r.length;i++)
        {
            if(r[i] == e)
            {
                flag = 1;
                break;
            }
            
        }
        
        if(flag == 1)
        return true;
        
        else
        return false;
    }
}