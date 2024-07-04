import java.util.*;
class Latin
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int i=1; i<=t; i++)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            int tr=0, r=0, c=0;
            //input array
            for (int j=0; j<n; j++)
            {
                for (int k=0; k<n; k++)
                {
                    arr[j][k]=sc.nextInt();
                    if (j==k)
                    {
                        tr=tr+arr[j][k];
                    }
                }
            }
            //find r and c
            for (int j=0; j<n; j++)
            {
                int coun1=0, coun2=0;
                for (int k=0; k<n-1; k++)
                {
                    for (int l=k+1; l<n; l++)
                    {
                        if (arr[j][k]==arr[j][l])
                        {
                            coun1++;
                        }
                        if (arr[k][j]==arr[l][j])
                        {
                            coun2++;
                        }
                    }
                }
                if (coun1!=0)
                {
                    r++;
                }
                if (coun2!=0)
                {
                    c++;
                }
            }
            System.out.println("Case #"+i+": "+tr+" "+r+" "+c);
        }
    }
}