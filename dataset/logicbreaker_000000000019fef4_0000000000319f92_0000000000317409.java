import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class Solution {
	public static void main ( String args [] ) throws IOException, InterruptedException {
	
	
			solve();}

public static void solve() throws IOException, InterruptedException {
Scanner sc = new Scanner(System.in);
int t=sc.nextInt();
StringBuilder sb = new StringBuilder("");

all:for(int c=0;c<t;c++) {
int x=sc.nextInt();
int y=sc.nextInt();
String M=sc.next();
int currX=x;
int currY=y;
int cycle=0;
if(x==0 && y==0) {
	sb.append("Case #"+(c+1)+": "+ 0+"\n");continue all;
}
for(int i=0;i<M.length();i++) {
	if(M.charAt(i)=='S') {
			currY--;
	}else if(M.charAt(i)=='N') {
		currY++;
	}else if(M.charAt(i)=='E') {
		currY++;
	}else if(M.charAt(i)=='W') {
		currY--;
	}
	cycle++;
	if(Math.abs(currX)+Math.abs(currY)<=cycle) {
		sb.append("Case #"+(c+1)+": "+ cycle+"\n");continue all;
	}
}
sb.append("Case #"+(c+1)+": "+ "IMPOSSIBLE"+"\n");
}
System.out.println(sb);








}	
	
	
	
	
	
	



















static void shuffle(int[] a)
{
	int n = a.length;
	for(int i = 0; i < n; i++)
	{
		int r = i + (int)(Math.random() * (n - i));
		int tmp = a[i];
		a[i] = a[r];
		a[r] = tmp;
	}
}




}

class Pair implements Comparable{
	int id;

	int sum;

	public Pair(int s,int e) {
		this.sum=e;
		this.id=s;
	}

	@Override
	public int compareTo(Object o) {
		if(this.sum>((Pair)o).sum) {
			return 1;
		}else if(this.sum<((Pair)o).sum) {
			return -1;
		}else if(this.sum==((Pair)o).sum) {
			if(this.id<((Pair)o).sum ) {
				return -1;
			}else {
				return 1;
			}
		}
		else return 1;
		
	}
}




class Scanner 
{
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public String next() throws IOException 
	{
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}
	
	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}
	
	public double nextDouble() throws IOException
	{
		String x = next();
		StringBuilder sb = new StringBuilder("0");
		double res = 0, f = 1;
		boolean dec = false, neg = false;
		int start = 0;
		if(x.charAt(0) == '-')
		{
			neg = true;
			start++;
		}
		for(int i = start; i < x.length(); i++)
			if(x.charAt(i) == '.')
			{
				res = Long.parseLong(sb.toString());
				sb = new StringBuilder("0");
				dec = true;
			}
			else
			{
				sb.append(x.charAt(i));
				if(dec)
					f *= 10;
			}
		res += Long.parseLong(sb.toString()) / f;
		return res * (neg?-1:1);
	}
	
	public boolean ready() throws IOException {return br.ready();}


}