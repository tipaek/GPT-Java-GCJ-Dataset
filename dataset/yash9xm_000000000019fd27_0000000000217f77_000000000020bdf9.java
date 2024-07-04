import java.util.*;
import java.io.*;

public class Solution
{
	static void fill(int a[],int i,int n)
    {
		for(;i<=n;i++)a[i]=1;
	}
    
    static void solve(Scanner sc, int testcase)
    {
		int a[] = new int[1442];
		int b[] = new int[1442];
		
		int n = sc.nextInt();
		
		Pair[] p = new Pair[n];
		
		for(int i=0;i<n;i++)
		{
			int s = sc.nextInt(), e =sc.nextInt();
			p[i] = new Pair(s,e,i);	
		}
		
		char ans[] = new char[n];
		Arrays.sort(p,new SortPair());
			
		for(int j=0;j<n;j++)
		{
			int s = p[j].a;
			int e = p[j].b;
			int in = p[j].in;
			
			
			if(a[s]!=1)
			{
				fill(a,s,e-1);
				ans[p[j].in]='C';
			}
			else if(b[s]!=1)
			{
				fill(b,s,e-1);		
				ans[p[j].in]='J';
			}
			else
			{
				System.out.println("Case #"+testcase+": IMPOSSIBLE");
				return;
			}
		}

		System.out.println("Case #"+testcase+": "+new String(ans));
	}
   
    static class SortPair implements Comparator<Pair> 
	{ 
		public int compare(Pair a, Pair b) 
		{ 
			if(a.a != b.a)
				return a.a - b.a;
			return a.b - b.b;
		} 
	} 
	
    static class Pair
    {
		int a,b,in;
		Pair(int aa, int bb,int ii)
		{
			a = aa;
			b = bb;
			in=ii;
		} 
		public String toString()
		{
			return "["+a+" "+b+"]";
		}
	}
  
    public static void main(String args[])
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        
        for(int j=1;j<=t;j++)
        {
			solve(sc,j);
        }
    }
}
