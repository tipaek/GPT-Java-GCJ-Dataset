import java.util.*;

class Solution {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int l=1;
		while(l<=t)
		{
		    int n=sc.nextInt();
		    int a[][]=new int[n][n];
		    int r=0,c=0,s=0,d=0;
		    int res=(n*(n+1))/2;
		    Set<Integer>hs;
		    for(int i=0;i<n;i++)
		    {
		        hs=new HashSet<Integer>();
		        for(int j=0;j<n;j++)
		        {
		            a[i][j]=sc.nextInt();
		            hs.add(a[i][j]);
		            if(i==j)
		             d+=a[i][j];
		        }
		        if(hs.size()!=n)
		         r++;
		    }
		    for(int i=0;i<n;i++)
		    {
		      hs=new HashSet<Integer>();
		        for(int j=0;j<n;j++)
		        {
		           hs.add(a[j][i]);
		        }
		       if(hs.size()!=n)
		         c++;
		    }
		    System.out.println("Case #"+l+": "+d+" "+r+" "+c);
		    l++;
		}
	}
}