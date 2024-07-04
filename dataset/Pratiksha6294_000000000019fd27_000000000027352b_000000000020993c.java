import java.util.*;
public class trace
{
    static void trace(int t,int[][] M,int N)
    {
        int k=0,r=0,c=0;
        Set<Integer> set= new HashSet<Integer>();
        for(int i=0;i<N;i++)
        {
            k+=M[i][i];
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                set.add(M[i][j]);
            }
            if(N!=(set.size())){
              r+=1;}
            
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                set.add(M[j][i]);
            }
            if(N!=(set.size())){
              c+=1;}
            
        }
        System.out.println("Case #"+t+": "+k+" "+r+" "+c);
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++)
        {
            int N= in.nextInt();
            int[][] M = new int[N][N];
            for(int j=0;j<N;j++)
            {
                for(int k=0;k<N;k++)
                M[j][k]=in.nextInt();
            }
        }
        trace((i+1),M,N);
    }
}