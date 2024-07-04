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
	
	
	
	
	
public static void solve() throws IOException   {
Scanner sc = new Scanner(System.in);
int t= Integer.parseInt(sc.nextLine());
StringBuilder sb = new StringBuilder("");
StringBuilder r = new StringBuilder("");
for(int c=0;c<t;c++) {
	int n =Integer.parseInt(sc.nextLine());
	String [] tokens = new String[n];
	for(int i=0;i<n;i++) {
		tokens[i]= sc.nextLine();
	}
	sort(tokens,tokens.length);
	String confirm="";
	all:for(int i=0;i<tokens[tokens.length-1].length()-1;i++) {
		confirm=tokens[tokens.length-1].charAt(tokens[tokens.length-1].length()-1-i)+confirm;
		char x =tokens[tokens.length-1].charAt(tokens[tokens.length-1].length()-1-i);
		for(int j=0;j<tokens.length;j++) {
			if(tokens[j].length()-1>i) {
				if(tokens[j].charAt(tokens[j].length()-i-1)!=x) {
					confirm="*";
					break all;
				}
			}
		}
	}
	sb.append("Case #"+(c+1)+": "+confirm +"\n");
	
	
	
	
}
System.out.println(sb);
}
//static String match(String s1,String s2) {
//	String shorter="";
//	String longer="";
//	if(s1.length()>s2.length()) {
//		shorter=s2;
//		longer=s1;
//	}else {
//		shorter=s1;
//		longer=s2;
//	}
//	if(s1.length()!=s2.length() && shorter.charAt(shorter.length()-1)!='*' && shorter.charAt(0)!='*') return "";
//	for(int i=0;i<longer.length();i++) {
//		
//		
//		
//		
//		
//	}
//}
static void sort(String []s, int n) 
{ 
    for (int i=1 ;i<n; i++) 
    { 
        String temp = s[i]; 
  
        // Insert s[j] at its correct position 
        int j = i - 1; 
        while (j >= 0 && temp.length() < s[j].length()) 
        { 
            s[j+1] = s[j]; 
            j--; 
        } 
        s[j+1] = temp; 
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
