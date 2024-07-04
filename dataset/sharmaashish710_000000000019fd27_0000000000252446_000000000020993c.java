
import java.io.*;
import java.util.*;
class Solution {
	public static void main (String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int k=0;k<t;k++)
		{
		    int n=in.nextInt();
		    int m[][]=new int[n][n];
		    int dsum=0,row=0,col=0;
		    Set<Integer> s=new HashSet<>();
		    for(int i=0;i<n;i++)
		    {
		        s.clear();
		        for(int j=0;j<n;j++)
		        {
		            m[i][j]=in.nextInt();
		            s.add(m[i][j]);
		            if(i==j)
		            {
		                dsum=dsum+m[i][j];
		            }
		        }
		        if(s.size()!=n)
		        {
		            row++;
		        }
		        
		    }
		    for(int i=0;i<n;i++)
		    {
		        s.clear();
		        for(int j=0;j<n;j++)
		        {
		            s.add(m[j][i]);
		        }
		        if(s.size()!=n)
		        {
		            col++;
		        }
		        
		    }
		    System.out.println("Case #"+(k+1)+": "+dsum+" "+row+" "+col);
		    
		}
	}
}