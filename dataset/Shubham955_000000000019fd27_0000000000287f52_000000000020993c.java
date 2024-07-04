import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        int h=1;
        while(h<=t)
        {
            int k=0,n=scan.nextInt();
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=scan.nextInt();
                    if(i==j)
                    {
                        k+=arr[i][j];
                    }
                }
            }
            int r=0,c=0;
            for(int i=0;i<n-1;i++)
            {
                for(int j=0;j<n-1;j++)
                {
                    if(arr[i][j]==arr[i+1][j])
                    {
                    r++;
                    break;
                    }
                    
                }
            }
            for(int j=0;j<n-1;j++)
            {
                for(int i=0;i<n-1;i++)
                {
                    if(arr[i][j]==arr[i][j+1])
                    {
                    c++;
                    break;
                    }
                }
            }
            System.out.println("Case #"+h+": "+k+" "+r+" "+c);
            h++;
        }
    }
}