import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String ag[])
    {
        Scanner sc=new Scanner(System.in);
        int i,j,k;
        int T=sc.nextInt();
        k=1;
        while(T-- >0)
        {
            int N=sc.nextInt();
            int arr[][]=new int[N][N];
            for(i=0;i<N;i++)
            {
                for(j=0;j<N;j++)
                arr[i][j]=sc.nextInt();
            }
            int sum=0;
            for(i=0;i<N;i++)
            sum+=arr[i][i];
            
            int row=0;
            int col=0;
            for(i=0;i<N;i++)
            {
                HashSet<Integer> hs=new HashSet<>();
                for(j=0;j<N;j++)
                {
                    if(hs.contains(arr[i][j]))
                    {
                        row++;
                        break;
                    }
                    hs.add(arr[i][j]);
                }
            }
            for(i=0;i<N;i++)
            {
                HashSet<Integer> hs=new HashSet<>();
                for(j=0;j<N;j++)
                {
                    if(hs.contains(arr[j][i]))
                    {
                        col++;
                        break;
                    }
                    hs.add(arr[j][i]);
                }
            }
            System.out.println("Case #"+k+": "+sum+" "+row+" "+col);
            k++;
        }
    }
}