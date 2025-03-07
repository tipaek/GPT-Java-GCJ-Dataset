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
int U=sc.nextInt();
HashSet<Character> found = new HashSet<Character>();
String arr [] = new String[10];
Pair [] match = new Pair[10000];
for(int i=0;i<10000;i++) {
	long x = sc.nextLong();
	String trans=sc.next();
	match[i]=new Pair(trans,x);
}
big:for(int num=1;num<=9;num++) {
for(int i=0;i<match.length;i++) {
	String s= match[i].letter;
	long number = match[i].number;
		if(!found.contains(s.charAt(0))  && countDig(number)==s.length() && (number+"").charAt(0) ==(num+"").charAt(0)) {
			found.add(s.charAt(0));
			arr[num]=s.charAt(0)+"";
			continue big;
		}	
}
}
for(int i=0;i<match.length;i++) {
	String s= match[i].letter;
	long number = match[i].number;
	for(int j=0;j<s.length();j++) {
		if(!found.contains(s.charAt(j))  && countDig(number)==s.length()) {
			arr[0]=s.charAt(j)+"";
			break;
		}	
	}
}
String res="";
for(int i=0;i<arr.length;i++) {
	res+=arr[i];
}
sb.append("Case #"+(c+1)+": "+ res+"\n");continue all;


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