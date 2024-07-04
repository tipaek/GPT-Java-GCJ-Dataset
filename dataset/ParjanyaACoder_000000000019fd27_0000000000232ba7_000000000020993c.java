import java.util.*;
class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int i,j,k,l=0,m,n,c=0,d=0,f=0,t,p;
        t=sc.nextInt();
        for(p=1;p<=t;p++)
        {
            n=sc.nextInt();m=n*(n-1)/2;c=0;d=0;f=0;l=0;
            int arr[][]=new int[n][n];
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                }
            }
            for(i=0;i<n;i++)
            {   l=0;
                for(j=0;j<n;j++)
                {
                    l=l+arr[i][j];
                }
                if(l!=m)
                c++;
            }
            for(i=0;i<n;i++)
            {   l=0;
                for(j=0;j<n;j++)
                {
                    l=l+arr[j][i];
                    
                }
                if(l!=m)
                d++;
            }
            for(i=0;i<n;i++)
            f=f+arr[i][i];
            System.out.println("Case #"+p+": "+f+" "+c+" "+d);
        
        }
    }
}