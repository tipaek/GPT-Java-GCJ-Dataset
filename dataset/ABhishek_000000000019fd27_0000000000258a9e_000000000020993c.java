import java.util.*;
class Hello
{
    public static void main(String argf[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int k=0;k<T;k++){
            int N=sc.nextInt();
        int r=0;
        int c=0;
        int count=0;
        
        int[][] M=new int[N][N];
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                M[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(i==j)
                count++;
                
            }
        }
            for(int i=0;i<N-1;i++)
            {
                for(int j=0;j<N-1;j++)
                {
                    if(M[i][j]==M[i][j+1])
                    c++;
                    if(M[i][j]==M[i+1][j])
                    r++;
                }
            }
            System.out.println("Case #"+k+": "+count+" "+ r+" "+c);
        
        }
    }
}