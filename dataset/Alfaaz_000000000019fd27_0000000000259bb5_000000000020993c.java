import java.util.Scanner;

class A
{
    public static void main(String[] args)
    {
        Scanner x=new Scanner(System.in);
        int t=x.nextInt();
        for(int q=1;q<=t;q++)
        {
            int n=x.nextInt();
            int a[][]= new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                    a[i][j]=x.nextInt();
            }
        }
    }
}