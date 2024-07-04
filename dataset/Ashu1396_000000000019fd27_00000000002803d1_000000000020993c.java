import java.util.*;
public class Test
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=1;i<=T;i++)
        {
            int k=0;
            int N=sc.nextInt();
            int[][] arr=new int[N][N];
            for(int j=0;j<N;j++)
            {
                for(int z=0;z<N;z++)
                {
                    arr[j][z]=sc.nextInt();
                    if(j==z)
                    {
                        k=k+arr[j][z];
                    }
                }
            }
            int r=0;
            int c=0;
            for(int j=0;j<N-1;j++)
            {
                for(int z=0;z<N-1;z++)
                {
                    if(arr[j][z]==arr[j][z+1])
                    {
                        r=r+1;
                        break;
                    }
                }
            }
            for(int z=0;z<N-1;z++)
            {
                for(int j=0;j<N-1;j++)
                {
                   if(arr[j][z]==arr[j+1][z])
                   {
                       c=c+1;
                       break;
                   }
                }
            }
            System.out.println("Case #"+i+": "+k+" "+r+" "+c);
        }
    }
}