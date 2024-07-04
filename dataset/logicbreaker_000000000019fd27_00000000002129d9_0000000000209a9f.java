import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
public class Solution {
	public static void main(String [] args) throws IOException {
solve();
}
	
	
	
	
	
public static void solve() throws IOException {
Scanner sc = new Scanner(System.in);
int t= sc.nextInt();
StringBuilder sb = new StringBuilder("");
StringBuilder r = new StringBuilder("");

for(int c=0;c<t;c++) {
	int openSoFar=0;
	String s=sc.next();
	for(int i=0;i<s.length();i++) {
		int x= Integer.parseInt(s.charAt(i)+"");
		while(x>openSoFar) {
			r.append("(");
			openSoFar++;
		}
		while(x<openSoFar) {
			r.append(")");
			openSoFar--;
		}
		r.append(x+"");
	}
	while(openSoFar>0) {
		r.append(")");
		openSoFar--;
	}

	
	
	sb.append("Case #"+(c+1)+": " + r+"\n");
	r=new StringBuilder();
	
	}
//	sb.append("Case #"+(c+1)+": " + trace+" "+ r+" "+col+"\n");
	System.out.println(sb);
}



public static boolean containsDup(int [] a) {
	ArrayList<Integer> h = new ArrayList<Integer>();
	for(int i=0;i<a.length;i++) {
		if(h.contains(a[i])) {return true;}
		else {
			h.add(a[i]);
		}
	}
	return false;
	
}
public static int sumMat(int [][] a) {
	int sum=0;
	for(int i=0;i<a.length;i++) {
		for(int j=0;j<a[i].length;j++) {
			if(i==j) sum+=a[i][j];
		}
	}
	return sum;
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