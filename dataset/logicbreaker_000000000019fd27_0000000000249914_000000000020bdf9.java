import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
	boolean isBreak=false;
	int total=sc.nextInt();
	Pair[] time= new Pair[total];
	ArrayList<Pair> cameron = new 	ArrayList<Pair>();
	ArrayList<Pair> Jack = new 	ArrayList<Pair>();
	for(int j=0;j<total;j++) {
		time[j]=new Pair(sc.nextInt(),sc.nextInt(),j);
	}
	Arrays.sort(time);
	for(int  i=0;i<time.length;i++) {
		if(!containsOver(cameron, time[i])) {
			time[i].setDoer("C");
			cameron.add(time[i]);
		}
		else if(!containsOver(Jack, time[i])) {
			time[i].setDoer("J");
			Jack.add(time[i]);
		}
		else {
			r=new StringBuilder("IMPOSSIBLE");
			isBreak=true;
			break;
		}
	}
	
	if(!isBreak) {
		Arrays.sort(time);
		for(int i=0;i<time.length;i++) {
			r.append(time[i].doer);
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


class Pair implements Comparable{
	@Override
	public String toString() {
		return "Pair [start=" + start + ", end=" + end + "]";
	}

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
	int order;
	String doer;
	public void setDoer(String doer) {
		this.doer = doer;
	}

	public Pair(int s,int e,int o) {
		start=s;
		end=e;
		order=o;
		doer="";
	}
	boolean isOverLap(Pair p) {
		if((p.start>this.start&&p.start<this.end)||(this.start>p.start&&this.start<p.end)||(p.start==this.start)) return true;
		return false;
	}
	@Override
	public int compareTo(Object o) {
		if(this.doer=="") {
		Pair p=(Pair)o;
		if(this.start>p.start) {
			return 1;
		}
		else if(this.start<p.start) {
			return -1;
		}
		else {
			return 0;
		}
	}else {
		Pair p=(Pair)o;
		if(this.order>p.order) {
			return 1;
		}
		else if(this.order<p.order) {
			return -1;
		}
		else {
			return 0;
		}
	}
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