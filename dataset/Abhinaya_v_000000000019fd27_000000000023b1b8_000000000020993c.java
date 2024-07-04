import java.util.*;
class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int ti[][]=new int[t][3];
        int h=0;
        while(h<t)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            int i=0,j=0;
            try{
            for(i=0;i<n;i++)
            {
                for(int k=0;k<n;k++)
                {
                    j=sc.nextInt();
                    if(j>n&&j<=0)
                        throw new ArithmeticException();
                    arr[i][k]=j;
                }
            }
            }
            catch(Exception e)
            {
                continue;
            }
            int count=0;
            for(i=0;i<n;i++)
            {
                for(j=0;j<n-1;j++)
                {
                    if(arr[i][j]==arr[i][j+1])
                    {
                        count+=1;
                        break;
                    }
                }
            }
            ti[h][1]=count;
            count=0;
            for(j=0;j<n;j++)
            {
                for(i=0;i<n-1;i++)
                {
                    if(arr[i][j]==arr[i+1][j])
                    {
                        count+=1;
                        break;
                    }
                }
            }
            ti[h][2]=count;
            count=0;
            for(int k=0;k<n;k++)
            {
                count+=arr[k][k];
            }
            ti[h][0]=count;
            h++;
        }
        for(int i=0;i<t;i++)
        {
            System.out.print("Case #"+(i+1)+":");
            for(int j=0;j<3;j++)
            {
                System.out.print(ti[i][j]+" ");
            }
            System.out.println();
        }
    }
}