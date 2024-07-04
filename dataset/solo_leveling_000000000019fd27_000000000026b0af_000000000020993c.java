import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		int k=0;
		while(t-->0)
		{int n=s.nextInt();
		k++;
		int a[][]=new int[n][n];
		int len=0;
		for(int i=0;i<n;i++)
		{for(int j=0;j<n;j++)
		{a[i][j]=s.nextInt();
		 if(i==j)
		 len+=a[i][j];
		}}
		int countx=0;
		int county=0;
		for(int i=0;i<n;i++)
		{HashSet<Integer>hs=new HashSet<>();
		for(int j=0;j<n;j++)
		{hs.add(a[i][j]);}
		if(hs.size()==n)
		{}
		else
		countx++;
		}
		for(int i=0;i<n;i++)
		{HashSet<Integer>hs=new HashSet<>();
		for(int j=0;j<n;j++)
		{hs.add(a[j][i]);}
		if(hs.size()==n)
		{}
		else
		county++;
		}
		System.out.println("Case #"+k+": "+len+" "+countx+" "+county);
		}
	}
}