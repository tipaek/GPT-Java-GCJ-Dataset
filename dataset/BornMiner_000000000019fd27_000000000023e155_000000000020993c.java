import java.util.*;
public class google
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n = sc.nextInt();
            int a[][]=new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                    a[j][k]=sc.nextInt();
            }
            int tr=0;
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(j==k)
                        tr+=a[j][k];
                }
            }
            int r=0;
            int flag=0;
            for(int j=0;j<n;j++)
            {
                flag=0;
                for(int k=0;k<n;k++)
                {
                    for(int l=k+1;j<n;l++)
                    {
                        if(a[j][k]==a[j][l])
                        {
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1)
                        break;
                }
                if(flag==1)
                    r++;
            }
            int c=0;
            for(int j=0;j<n;j++)
            {
                flag=0;
                for(int k=0;k<n;k++)
                {
                    for(int l=k+1;l<n;l++)
                    {
                        if(a[k][j]==a[l][j])
                        {
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1)
                        break;
                }
                if(flag==1)
                    c++;
            }
            int p=i+1;
            System.out.println("Case #"+p+": "+tr+" "+r+" "+c);
        }
    }
}