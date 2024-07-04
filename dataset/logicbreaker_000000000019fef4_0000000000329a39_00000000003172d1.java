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
public static int countDig(long num) {
	int count=0;
    while(num != 0)
    {
      
        num /= 10;
        ++count;
    }

    return count;
}

public static void solve() throws IOException, InterruptedException {
Scanner sc = new Scanner(System.in);
int t=sc.nextInt();
StringBuilder sb = new StringBuilder("");


all:for(int c=0;c<t;c++) {
int n=sc.nextInt();
int d=sc.nextInt();
long slices [] = new long[n];
int cost[] = new int[n];
int countfreq[] = new int[n];
for(int i=0;i<n;i++) {
	slices[i]=sc.nextLong();
}
if(n==1) {
	sb.append("Case #"+(c+1)+": " +(d-1)+"\n");continue all;
}
int count =0;
big:for(int i=0;i<slices.length;i++) {
	countfreq[i]++;
	count=1;
	for(int j=0;j<slices.length ;j++) {
		if(j!=i) {
		if(slices[i]==slices[j]) {
			count++;
		}
		if(d==count) {
			countfreq[i]=d;
			continue big;
		}}
	}
	if(count<d) {
		countfreq[i]=count;
	}	
}
for(int i=0;i<countfreq.length;i++) {
	if(countfreq[i]==d) {
			sb.append("Case #"+(c+1)+": " +0+"\n");continue all;
	}
}
big:for(int i=0;i<slices.length;i++) {
	count=countfreq[i];
	for(int j=0;j<slices.length;j++) {
		if(j!=i) {
		if(slices[j]/slices[i]==2) {
			count+=2;
			cost[i]++;
		}
		if(d==count) {
			countfreq[i]=d;
			continue big;
		}}
	}
	if(count<d) {
		countfreq[i]=count;
	}	
}
int minCost=Integer.MAX_VALUE;
boolean foundD=false;
for(int i=0;i<countfreq.length;i++) {
	if(countfreq[i]==d) {
			foundD=true;
			if(cost[i]<minCost) {
				minCost=cost[i];
			}
	}
}
if(foundD) {
sb.append("Case #"+(c+1)+": " +minCost+"\n");continue all;}
big:for(int i=0;i<slices.length;i++) {
	count=countfreq[i];
	for(int j=0;j<slices.length ;j++) {
		if(j!=i) {
		long curr = slices[j];
		while(curr>=slices[i]) {
			curr-=slices[i];
			count++;
			cost[i]++;
			if(d==count) {
				countfreq[i]=d;
				continue big;
			}
		}
		if(d==count) {
			countfreq[i]=d;
			continue big;
		}
	}
	}
	if(count<d) {
		countfreq[i]=count;
	}	
}
minCost=Integer.MAX_VALUE;
foundD=false;
for(int i=0;i<countfreq.length;i++) {
	if(countfreq[i]==d) {
			foundD=true;
			if(cost[i]<minCost) {
				minCost=cost[i];
			}
	}
}
if(foundD) {
sb.append("Case #"+(c+1)+": " +minCost+"\n");continue all;}
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

@SuppressWarnings("rawtypes")
class Pair implements Comparable{
	String letter;
	long number;

	public Pair(String l,long n) {
		this.letter=l;
		this.number=n;
	}

	@Override
	public int compareTo(Object o) {
		Pair p = (Pair)o;
		if(this.number<p.number) return -1;
		if(this.number>p.number) return 1;
		return 0;
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