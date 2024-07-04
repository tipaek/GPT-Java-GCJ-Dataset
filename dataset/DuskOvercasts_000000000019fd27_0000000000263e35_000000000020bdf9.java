import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            for(int q=1;q<=t;q++)
            {
                int n=sc.nextInt();
                int ar[][]=new int[2][n];
                int ar1[][]=new int[2][n];
                for(int i=0;i<n;i++)
                {
                    ar[0][i]=sc.nextInt();
                    ar[1][i]=sc.nextInt();
                }
                for(int i=0;i<n;i++)
                {
                    ar1[0][i]=ar[0][i];
                    ar1[1][i]=ar[1][i];
                }
                for(int i=0;i<n;i++)
                {
                    for(int j=i;j<n;j++)
                    {
                        if(ar[0][i]>ar[0][j])
                        {
                            int p=ar[0][i];
                            ar[0][i]=ar[0][j];
                            ar[0][j]=p;
                            p=ar[1][i];
                            ar[1][i]=ar[1][j];
                            ar[1][j]=p;
                        }
                    }
                }
                char arr[]=new char[n];
                char arr1[]=new char[n];
                int c=ar[1][0];int j=0;
                arr[0]='C';
                int i;
                for(i=1;i<n;i++)
                {
                    if(ar[0][i]>=c)
                    {
                        c=ar[1][i];
                        arr[i]='C';
                    }
                    else if(ar[0][i]>=j)
                    {
                        j=ar[1][i];
                        arr[i]='J';
                    }
                    else
                    break;
                }
                boolean ch[]=new boolean[n];
                for(int k=0;k<n;k++)
                ch[k]=false;
                if(i==n)
                {
                    for(int a=0;a<n;a++)
                    {
                        for(int b=0;b<n;b++)
                        {
                            if(ar1[0][a]==ar[0][b] && ar1[1][a]==ar[1][b] && ch[b]==false)
                            {
                                ch[b]=true;
                                arr1[a]=arr[b];
                            }
                        }
                    }
                    System.out.print("Case #"+q+": ");
                    for(int k=0;k<n;k++)
                    System.out.print(arr1[k]);
                    System.out.println();
                }
                else
                System.out.println("Case #"+q+": IMPOSSIBLE");
            }
        }
        catch(Exception e)
        {
            return;
        }
    }
}