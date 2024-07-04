//sks.it2012@
import java.util.*;
import java.io.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.math.BigDecimal;
 
class Solution {
	
	int c;
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	long mod=1000000007l;
	long mod1=163577857l;
	long[] fact;
	int[] array;
	long[] infact;
	int[][] index;
	HashMap[] hm;
	HashMap[] mul;
	HashMap[] div;
	int[] arr;
	int[] value;
	//typedef long long int ll;
int MAXN = 100007;
int MAXLN = 17;
//using namespace std;
int[] depth;//=new [MAXN];
int[][] par;//[MAXLN][MAXN];
Vector[] adj;//[MAXN];
int n, q, u, v, sz;
	//https://www.facebook.com/418862728547392/videos/421384398295225/
	
	void solve() throws Exception
	{
		int t=ni();
		for(int i1=1;i1<=t;i1++)
		{
			int u=ni();
			long[] a1=new long[10000];
			String[] s=new String[10000];
			for(int i=0;i<10000;i++)
			{
				a1[i]=nl();
				s[i]=ns();
				
			}
			char[] a=new char[10];
			int start=0;
			MergeSort ob=new MergeSort();
			n=10000;
			ob.sort(a1,s,0,n-1);
			Boolean[] b=new Boolean[1000];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<s[i].length();j++)
				{
					if(!b[(int)s[i].charAt(j)])
					{
						a[start]=s[i].charAt(j);
						start++;
						b[(int)s[i].charAt(j)]=true;
					}
				}
			}
			out.print(Case(i1));
			for(int i=0;i<10;i++)out.print(a[i]);
			out.println();
		}
		
	}
	int distance(int a,int b)
	{
		if(a<0)a=-a;
		if(b<0)b=-b;
		return a+b;
		
	}
	long ncr(int a,int b)
	{
		long temp=fact[a];
		temp=(temp*infact[b])%mod1;
		temp=(temp*infact[a-b])%mod1;
		return temp;
	}
	long power1(long a,int x)
	{
		String s=Integer.toBinaryString(x);
		long temp=1;
	for(int i=s.length()-1;i>=0;i--)
	{
		if(s.charAt(i)=='1')
		{
			temp=(temp*a)%mod1;
			
		}
		a=(a*a)%mod1;
	}
return temp;	
	}
  void initialize(int n)
  {
   depth=new int[MAXN];
   par=new int[MAXLN][MAXN];
adj=new Vector[n];//
for(int i=0;i<n;i++)adj[i]=new Vector<Integer>();
  }
	void addEdge(int a,int b)
	{
	        adj[b].add(a);
            adj[a].add(b);
	}
	void dfs(int cur, int prev, int _depth) {
    depth[cur] = _depth;
    par[0][cur] = prev;
    for(int i = 0; i < adj[cur].size(); i++) {
        if((int)(adj[cur].get(i))!= prev) {
            dfs((int)adj[cur].get(i), cur, _depth+1);
        }
    }
}

// dynamic programming for finding the LCA
void LCAPreprocess() {
    for(int i = 1; i < MAXLN; i++) {
        for(int j = 0; j < n; j++) {
            // if the parent of the below level exist
            // then parent of level i is equal to the
            // parent of the parent of the level-1
            // Please get the feel of the dp here 
            // otherwise you will not get the picture
            if(par[i-1][j]!=-1)
                par[i][j] = par[i-1][par[i-1][j]];
        }
    }
}

// function to give the LCA of two edges
int LCA(int u, int v) {

    // we want the u to be at the lower level
    if(depth[u] < depth[v])
	{
		
		int a=u;
		u=v;
		v=a;
	}

    // we want to make the two nodes to be at the same level
    int diff = depth[u]-depth[v];

    for(int i = 0; i < MAXLN; i++)
        if(((diff>>i)&1)==1) u = par[i][u];

    // if the node which are the same level are same then it is lca
    if(u == v) return u;

    // if the parent of both the nodes are not same then jump to that level
    for(int i = MAXLN-1; i>=0; i--)
        if(par[i][u]!= par[i][v])
		{ u = par[i][u];
    		v = par[i][v];
		}

    // return the immediate parent to the given node
    return par[0][u];
}

	
  
	
	String Case(int test)
	{
		return "Case #"+test+": ";
	}
	
	
	long power(long a,int x)
	{
		String s=Integer.toBinaryString(x);
		long temp=1;
	for(int i=s.length()-1;i>=0;i--)
	{
		if(s.charAt(i)=='1')
		{
			temp=(temp*a)%mod;
			
		}
		a=(a*a)%mod;
	}
return temp;	
	}
	int min(int a,int b)
	{
	if(a>b)return b;
		return a;
	}
	int max(int a,int b)
	{
	if(a>b)return a;
		return b;
	}
	int mi(int a,int n)
	{
	if(a<0)return n-a;
		return a;
	}
	int plus(int a,int n)
	{
	if(a>n-1)
	{
	return a-n;
	}
		return a;
	}
	long gcd(long a,long b)
 {
	 if(a<0)a=-a;
	 if(b<0)b=-b;
 if (b == 0) return a;
 else return gcd(b, a% b);
	 }
	long term(long a,long b,int k)
	{
	return (b-a)/k+1;
	}
	
	String CAse(int i)
	{
	return "Case #"+i+":";
	}
	boolean check1(int k,int rate)
	{
	if(k>=rate)return true;
		return false;
	}
	
	
   
 
    
   int[] polyFWHT(int[] P, boolean inverse) {
    for (int len = 1; 2 * len <= degree(P); len <<= 1) {
        for (int i = 0; i < degree(P); i += 2 * len) {
            for (int j = 0; j < len; j++) {
               int u = P[i + j];
               int v = P[i + len + j];
                P[i + j] = u + v;
			   //if(i+j==0)out.println(P[i+j]);
                P[i + len + j] = u - v;
				//if(i+j+len==0)out.println(P[i+j+len]);
				
            }
        }
    }
    
    if (inverse) {
        for (int i = 0; i < degree(P); i++)
            P[i] = P[i] / degree(P);
    }

    return P;
}
	int degree(int[] p){return p.length-1;}
    
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }				  

long max(long a,long b)
{
	if(a>b)return a;
return b;
}
long min(long a,long b)
{
	if(a>b)return b;
return a;
}
 
 
 
	
	
	
	
	void run() throws Exception
	{
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
	}
	
	public static void main(String[] args) throws Exception { new Solution().run(); }
	
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	
	private int readByte()
	{
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
	private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
	
	private double nd() { return Double.parseDouble(ns()); }
	private char nc() { return (char)skip(); }
	
	private String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	private int[] na(int n)
	{
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}
	
	private int ni()
	{
		int num = 0, b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private long nl()
	{
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}
 class MergeSort 
{ 
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    void merge(long arr[], String[] s,int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        long L[] = new long [n1]; 
        long R[] = new long [n2]; 
		String L1[] = new String [n1]; 
        String R1[] = new String [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
		{
            L[i] = arr[l + i]; 
		    L1[i]=s[l+i];
		}
        for (int j=0; j<n2; ++j) 
		{
            R[j] = arr[m + 1+ j]; 
  
         R1[j]=s[m+1+j];
		}
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
				s[k]=L1[i];
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
				s[k]=R1[j];
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
			s[k]=L1[i];
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
			s[k]=R1[j];
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(long arr[],String[] s, int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr,s, l, m); 
            sort(arr ,s, m+1, r); 
  
            // Merge the sorted halves 
            merge(arr,s, l, m, r); 
        } 
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    // Driver method 
   
}
 class Complex
 {
 int real;int image;
 }
  
  

 


//This code is contributed by Ankur Narain Verma
