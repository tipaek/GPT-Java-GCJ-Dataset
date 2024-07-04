import java.util.*;
public class Trace
{
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
       
        int n=ob.nextInt();
       
        int mat[][]=new int[n][n];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                mat[i][j]=ob.nextInt();
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        int trace=0;
        for(int i=0;i<n;i++)
        {
            trace=trace+mat[i][i];
        }
        System.out.println(trace);
    }
}