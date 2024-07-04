import java.util.Scanner;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            int trace=0;
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    arr[j][k]=sc.nextInt();
                    if(j==k)
                    trace+=arr[j][k];
                }
            }
            int flgr=0,r=0,flgc=0,c=0;
            for(int j=0;j<n;j++)
            {
                flgr=0;
                flgc=0;
                for(int k=0;k<n-1;k++)
                {
                    if(flgr==0)
                    {
                    for(int l=k+1;l<n;l++)
                    {
                        if(arr[j][k]==arr[j][l])
                        {
                            flgr=1;
                            r++;
                            break;
                        }
                    }
                    }
                    if(flgc==0)
                    {
                    for(int l=k+1;l<n;l++)
                    {
                        if(arr[k][j]==arr[l][j])
                        {
                            flgc=1;
                            c++;
                            break;
                        }
                    }
                    }
                    if(flgr==1&&flgc==1)
                    break;
                }
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+r+" "+c);
        }
    }
}