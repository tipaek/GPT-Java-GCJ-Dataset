/* package codechef; // don't place package name! */

import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args)
	{
		Scanner in=new Scanner(System.in);
	int t=in.nextInt();
	int u=0;
	while(t--!=0)
	{
	    u=u+1;
	    int n=in.nextInt();
	    int a[][]=new int[n][2];;
	    for(int i=0;i<n;i++)
	    {
	        for(int j=0;j<2;j++)
	        {
	            a[i][j]=in.nextInt();
	        }
	    }
	    int j[][]=new int[n][2];
	    int c[][]=new int[n][2];
	    j[0][0]=a[0][0];
	    j[0][1]=a[0][1];
	    c[0][0]=-1;
	    c[0][1]=-1;
	    int m=1;
	    String s="";int q=0;
	    int v=0;
	    System.out.print("Case #"+u+": ");
	    for(int i=1;i<n;i++)
	    {
	        int l=0;
	        for(int k=0;k<m;k++)
	        {
	            if(!((j[k][0]<a[i][0] && a[i][0]<j[k][1]) || (j[k][0]<a[i][1] && a[i][1]<j[k][1])))
	            l++;
	        }
	        if(l==m)
	        {
                j[m][0]=a[i][0];
                j[m][1]=a[i][1];
                m++;
            }
            else
            {
                j[m][0]=-1;
                j[m][1]=-1;
                c[v][0]=a[i][0];
                c[v][1]=a[i][1];
                m++;v++;
            }
	    }
	    int f=0;
	    for(int i=0;i<n;i++)
	    {
	        for(int k=i+1;k<n;k++)
	        {
	            if(((c[i][0]<c[k][0] && c[k][0]<c[i][1]) || (c[i][0]<c[k][1] && c[k][1]<c[i][1])))
	            {
	                System.out.print("IMPOSSIBLE");
	                f=1;break;
	            }
	        }
	        if(f==1)
	        break;
	    }
	    if(f==0)
	    {
	        for(int i=0;i<n;i++)
	        {
	            if(j[i][0]==-1)
	            System.out.print("C");
	            else
	            System.out.print("J");
	        }
	    }
	    System.out.println();
	}
}
}