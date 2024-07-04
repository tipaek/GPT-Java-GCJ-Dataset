import java.util.*;
import java.io.*;
/* Name of the class has to be "Main" only if the class is public. */

public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
	   
	Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t= sc.nextInt();
	int p;
		for(p=1;p<=t;++p)
		{
		    int i,j;
		    int n=sc.nextInt();
		    int a[][]=new int [n][n];
		    for(i=0;i<n;i++)
		    {
		        for(j=0;j<n;j++)
		        {
		            a[i][j]=sc.nextInt();
		        }
		    }
		    int trace=0;
		    for(i=0;i<n;i++)
		    trace+=a[i][i];
		    HashSet<Integer> h1=new HashSet<Integer>();
		    HashSet<Integer> h2=new HashSet<Integer>();

		    int r=0;
		    for(i=0;i<n;i++){
		        for(j=0;j<n;j++)
		    {
		        if(h1.contains(a[i][j]))
		        {
		            r++;
		            break;
		        }
		        else
		        h1.add(a[i][j]);
		    }
		    h1.clear();
		    }
		    int c=0;
             for(i=0;i<n;i++){
		        for(j=0;j<n;j++)
		    {
		        if(h2.contains(a[j][i]))
		        {
		            c++;
		            break;
		        }
		        else
		        h2.add(a[j][i]);
		    }
		    h2.clear();
		    }
		    System.out.println("Case #"+p+": "+trace+" "+r+" "+c);
		}
		System.exit(0);
	}
}
		    
		    
		    
		    
		    