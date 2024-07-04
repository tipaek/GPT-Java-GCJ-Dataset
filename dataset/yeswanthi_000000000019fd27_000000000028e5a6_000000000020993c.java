import java.util.*;
public class Main
{	 public static void main(String[] args)
    {
        int x,s;
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(x=0;x<=t;x++)
        {
        int n=sc.nextInt();
        int i,j,k,p;
        int a[][]=new int[n][n];
        s=0;
        int m=0,f=0;
        int c[]=new int[n];
        for(i=0;i<n;i++)
        {
            f=0;
            for(j=0;j<n;j++)
            {
            a[i][j]=sc.nextInt();
            c[j]=a[i][j];
            if(i==j)
            s=s+a[i][j];
            }
            Arrays.sort(c);
            for(k=0;k<n-1;k++)
            {
                if(c[k]==c[k+1])
                {
                f=1;
                break;
                }
            }
            if(f==1)
            m=m+1;
        }
        f=0;
       int  w=0;
        for(i=0;i<n;i++)
        {
            f=0;
            for(j=0;j<n;j++)
            {
                c[j]=a[j][i]; 
            }
            Arrays.sort(c);
            for(k=0;k<n-1;k++)
            {
                if(c[k]==c[k+1])
                {
                f=1;
                break;
                }
                
            }
            
        if(f==1)
        w=w+1;
        }
        System.out.println("Case #"+(x+1)+": "+s+" "+m+" "+w);
        }
	}
}
