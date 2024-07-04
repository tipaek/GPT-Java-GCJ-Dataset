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
	ArrayList<Pair> time= new ArrayList<Pair>();
	ArrayList<Pair> cameron = new 	ArrayList<Pair>();
	ArrayList<Pair> Jack = new 	ArrayList<Pair>();
	int total=sc.nextInt();
	for(int j=0;j<total;j++) {
		time.add(new Pair(sc.nextInt(),sc.nextInt()));
	}
	for(int  i=0;i<time.size();i++) {
		if(!containsOver(cameron, time.get(i))) {
			cameron.add(time.get(i));
			r.append("C");
		}
		else if(!containsOver(Jack, time.get(i))) {
			Jack.add(time.get(i));
			r.append("J");
		}
		else {
			r=new StringBuilder("IMPOSSIBLE");
		}
	}
	sb.append("Case #"+(c+1)+": " + r+"\n");
	r=new StringBuilder("");
	}
	System.out.println(sb);
}

public static boolean containsOver(ArrayList<Pair> a,Pair p) {
	for(int i=0;i<a.size();i++) {
		if(a.get(i).isOverLap(p)) return true;
	}
	return false;
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


class Pair {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + end;
		result = prime * result + start;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (end != other.end)
			return false;
		if (start != other.start)
			return false;
		return true;
	}
	int start;
	int end;
	public Pair(int s,int e) {
		start=s;
		end=e;
	}
	boolean isOverLap(Pair p) {
		if((p.start>this.start&&p.start<this.end)||(this.start>p.start&&this.start<p.end)) return true;
		return false;
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