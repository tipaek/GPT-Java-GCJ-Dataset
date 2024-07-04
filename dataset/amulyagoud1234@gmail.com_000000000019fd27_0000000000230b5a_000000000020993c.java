import java.utiil.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int sum=0;
        for(int p=1;p<=t;p++)
        {
            int n=s.nextInt();
            int[][] a=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=s.nextInt();
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(i==j)
                    {
                        sum=sum+a[i][j];
                    }
                }
            }
            System.out.println(sum);
        }
    }
}