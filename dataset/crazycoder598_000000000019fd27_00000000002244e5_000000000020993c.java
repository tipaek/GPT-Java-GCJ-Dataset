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
 
class Solution
{
	
	int c;
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	long mod=1000000007l;
	BinaryTree[] ba;
	BinaryTree[] ba1;
	BinaryTree[] ba2;
	int[] array;
	//https://www.facebook.com/418862728547392/videos/421384398295225/
	
	void solve() throws Exception
	{
		int t=ni();
		for(int ca=1;ca<=t;ca++)
		{
			int n=ni();
			int trace=0;
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					a[i][j]=ni();
					if(i==j)trace=trace+a[i][j];
					
				}
			}
			int[][] col=new int[n][n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					col[i][j]=a[j][i];
				}
			}
		//printArray(a[][0]);
		int countrow=0;
		int countcol=0;
		for(int i=0;i<n;i++)
		{
			if(!vestigium(a[i],n))countrow++;
			if(!vestigium(col[i],n))countcol++;
		}
		out.println("Case #"+(ca)+": "+trace+" "+countrow+" "+countcol);
			
			
			
		}
	}
	void printArray(int[] a)
	{
		for(int i=0;i<a.length;i++)
			out.println(a[i]);
	}
	boolean vestigium(int[] a,int n)
	{
		int[] b=new int[n+1];
		for(int i=0;i<n;i++)
		{
			b[a[i]]++;
			if(b[a[i]]>1)return false;
			
		}
		return true;
		
	}
	String rplc(String s,char a,char x)
	{String temp="";
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)==a)temp=temp+x;
		else temp=temp+s.charAt(i);
		return temp;
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
			a=(a*a)%mod;
		}
	}
return temp;	
	}
	int treeCheckInRange(int x,int y,TreeMap<Integer,Integer>[] tm,int i)
	{
		if(i==tm.length)return y-x;
		if(tm[i].get(x)!=null)return treeCheckInRange( x, y, tm, i+1);
		if(tm[i].get(y)!=null)return treeCheckInRange( x, y, tm, i+1);
		if(tm[i].higherKey(x)!=null&&(int)tm[i].higherKey(x)<y)return treeCheckInRange( x, y, tm, i+1);
		Integer lwky=tm[i].lowerKey(x);
		Integer hgky=tm[i].higherKey(y);
		if(lwky==null) return treeCheckInRange( x, (int)hgky, tm, i+1);
		if(hgky==null)return treeCheckInRange( (int)lwky, y, tm, i+1);
		if(x-(int)lwky==(int)hgky-y)
		{
			int m1=treeCheckInRange( (int)lwky, y, tm, i+1),m2=treeCheckInRange( x, (int)hgky, tm, i+1);
			if(m1<m2)return m1;
			else return m2;
			
			
		}
		if(x-(int)lwky>(int)hgky-y) return treeCheckInRange( x, (int)hgky, tm, i+1);
		
		return treeCheckInRange( (int)lwky, y, tm, i+1);
		
		
		
	}
	
	void treeAdd(TreeMap t,int a)
	{
		if(t.get(a)==null)t.put(a,1);
		else t.put(a,(int)t.get(a)+1);
		
	}
	
	A binary(int a,int b,int c,int less ,int great,LinkedList<Integer> lg,LinkedList<Integer>ll)
	{
		int mid=a+b;
		mid=mid/2;
		if(mid<c)
		{
			
		less++;
			ll.add(mid);
			return binary(mid+1,b,c,less,great,lg,ll);
		}
		if(mid>c)
		{
		great++;
			lg.add(mid);
			return binary(a,mid-1,c,less,great,lg,ll);
		}
		A ff=new A();
		ff.a=less;
		ff.b=great;
		return ff;
		
	}
	int nu(TreeMap<Integer,Integer> tm,int a,int[] b)
	{
	int count=tm.get(a)-b[a];
		if(b[a]==1)tm.remove(a);
		else tm.put(a,b[a]-1);
		b[a]--;
		return count;
	}
	int number(int a,int n)
	{
	double temp=a/n;
		int t=(int)temp;
		if(temp-t>=.5)return a;
		int x=(int)((temp-t)*n);
	 temp=((a+x-1)*n)/100;
		if(temp-(int)temp>=.5)return a+x-1;
		 temp=((a+x)*n)/100;
		if(temp-(int)temp>=.5)return a+x;
		return a+x+1;
		
	}
	
 int maxSumIS( int arr[], int n )
    {
        int i, j, max = 0;
        int msis[] = new int[n];
 
        /* Initialize msis values for all indexes */
        for ( i = 0; i < n; i++ )
            msis[i] = arr[i];
 
        /* Compute maximum sum values in bottom up manner */
        for ( i = 1; i < n; i++ )
            for ( j = 0; j < i; j++ )
                if ( arr[i] > arr[j] &&
                     msis[i] < msis[j] + arr[i])
                    msis[i] = msis[j] + arr[i];
 
        /* Pick maximum of all msis values */
        for ( i = 0; i < n; i++ )
		{
			
            if ( max < msis[i] )
                max = msis[i];
		out.println(msis[i]);
		}
		      
 
        return max;
    }
	 int minCoins(int coins[], int m, int V)
	{
		// table[i] will be storing 
		// the minimum number of coins
		// required for i value. So 
		// table[V] will have result
		int table[] = new int[V + 1];

		// Base case (If given value V is 0)
		table[0] = 0;

		// Initialize all table values as Infinite
		for (int i = 1; i <= V; i++)
		table[i] = Integer.MAX_VALUE;
//System.out.println(Integer.MAX_VALUE);
		// Compute minimum coins required for all
		// values from 1 to V
		for (int i = 1; i <= V; i++)
		{
			// Go through all coins smaller than i
			for (int j = 0; j < m; j++)
			if (coins[j] <= i)
			{
				int sub_res = table[i - coins[j]];
				if (sub_res != Integer.MAX_VALUE 
					&& sub_res + 1 < table[i])
					table[i] = sub_res + 1;
						
				
			}
			
		}
		return table[V];
		
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
	
	String Case(int i)
	{
	return "Case #"+i+":";
	}
	boolean check1(int k,int rate)
	{
	if(k>=rate)return true;
		return false;
	}
	boolean check(TreeMap tm,int a,int x)
	{
		//print(tm);
		Map.Entry<Integer,Integer> en;
	while(a>0)
	{
		//out.println(a);
	en=tm.firstEntry();
	if(en.getKey()>=x)return false;
		else 
		{
		if(en.getValue()>=a){
			if(en.getValue()==a){
			a=0;
				add1(tm,en.getKey()+1,en.getValue());
				tm.remove(en.getKey());
			}
			else
			{
			
				tm.put(en.getKey(),en.getValue()-a);
				add1(tm,en.getKey()+1,a);
				a=0;
			}
			
			}
			else
			{
			a=a-en.getValue();
				add1(tm,en.getKey()+1,en.getValue());
				tm.remove(en.getKey());
				//print(tm);
			}
			
		}
	}
		//print(tm);
		
	 return true;	
		
	}
	void print(TreeMap<Integer,Integer> tm)
	{
	Map.Entry<Integer,Integer> en;
		Integer c=-1;
		
		while((en=tm.higherEntry(c))!=null)
		{
		out.println(en.getKey()+" "+en.getValue());
			c=en.getKey();
		}
		out.println();
	}
	void add(TreeMap<Integer,Integer> tm,int a,int d)
	{
	Integer c;
		if((c=tm.get(a))!=null)tm.put(a,(int)c+1+d);
		else tm.put(a,1+d);
	}
	void add1(TreeMap<Integer,Integer> tm,int a,int d)
	{
	Integer c;
		if((c=tm.get(a))!=null)tm.put(a,(int)c+d);
		else tm.put(a,d);
	}
	void remove(TreeMap<Integer,Integer> tm,int a)
	{
	
	Integer c;
		if((c=tm.get(a))!=0)tm.put(a,(int)c-1);
		else tm.remove(a);
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
 
 
 void quick(int[] d,int[] b,int[] a,int first,int last)
{
	if(first<last){
	int pivot=d[first];
int end=last;
int start=first;
int t1=end,t2=start;
while(t1>t2){	
for(t1=end;t1>=start;t1--)
{
if(d[t1]<pivot)
{	
d[t1]=d[t1]+d[start];
d[start]=d[t1]-d[start];
d[t1]=d[t1]-d[start];
b[t1]=b[t1]+b[start];
b[start]=b[t1]-b[start];
b[t1]=b[t1]-b[start];
a[t1]=a[t1]+a[start];
a[start]=a[t1]-a[start];
a[t1]=a[t1]-a[start];
end=t1;
 
break;
 
}
else{end=t1;}
 
}
 
if(t1!=start-1){	
for(t2=start;t2<=end;t2++)
{
if(d[t2]>pivot)
{
d[t2]=d[t2]+d[end];
d[end]=d[t2]-d[end];
d[t2]=d[t2]-d[end];
b[t2]=b[t2]+b[end];
b[end]=b[t2]-b[end];
b[t2]=b[t2]-b[end];
a[t2]=a[t2]+a[end];
a[end]=a[t2]-a[end];
a[t2]=a[t2]-a[end];
start=t2;
 
break;
}
else{start=t2;}
}
 
}
}
quick(d,b,a,first,start-1);
quick(d,b,a,start+1,last);
	}
}
	char f(long n,long k)
	{
		if(k==n/2l)return 'a';
		if(k>n/2l)
		{
			long num=k-n/2l;
			long number=n/2l-1l;
			 number=number-num+1l;
			return reverse(f(n/2l,number));
			
		}
		else
		{
			long num=n/2l-k;
			long number=n/2l-1l;
			number=number-num+1l;
			return f(n/2l,number);
			
		}
		
	}
	
	char reverse(char a)
	{
		if(a=='a')return 'c';
		return 'a';
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
 
 class A
 {
 int a;int b;
 }
 
class MergeSort
{
	static int k1;
	static int[] arr;
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[],int t[],int s[],int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L1[] = new int [n1];
        int R1[] = new int [n2];
		int L2[] = new int [n1];
        int R2[] = new int [n2];
		int L3[] = new int [n1];
        int R3[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
		{  L1[i] = arr[l + i];
		
		 L2[i] = t[l + i];
		  L3[i] = s[l + i];
		}
        for (int j=0; j<n2; ++j)
           {  R1[j] = arr[m + 1 + j];
		
		 R2[j] = t[m + 1 + j];
		  R3[j] = s[m + 1+ j];
		}
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L1[i] <= R1[j])
            {
                arr[k] = L1[i];
				t[k]=L2[i];
				s[k]=L3[i];
                i++;
            }
            else
            {
                arr[k] = R1[j];
				t[k]=R2[j];
				s[k]=R3[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L1[i];
				t[k]=L2[i];
				s[k]=L3[i];
                i++;
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (j < n2)
        {
            
				arr[k] =R1[j];
				t[k]=R2[j];
				s[k]=R3[j];
                j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[],int t[],int s[],int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            sort(arr,t,s,l, m);
            sort(arr ,t,s, m+1, r);
 
            // Merge the sorted halves
            merge(arr,t,s,l, m, r);
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
}
class MergeSortDouble
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(double arr[],int[] a,int[] b, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        double L[] = new double [n1];
        double R[] = new double [n2];
		int L1[] = new int [n1];
        int R1[] = new int [n2];
		int L2[] = new int [n1];
        int R2[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
		{
            L[i] = arr[l + i];
			 L1[i] = a[l + i];
			 L2[i] = b[l + i];
		
		}
        for (int j=0; j<n2; ++j)
		{
            R[j] = arr[m + 1+ j];
			R1[j] = a[m + 1+ j];
			R2[j] = b[m + 1+ j];
		
		
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
				a[k] = L1[i];
				b[k] = L2[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
				 a[k] = R1[j];
				 b[k] = R2[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
			a[k] = L1[i];
			b[k] = L2[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
			a[k] = R1[j];
			b[k] = R2[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(double arr[],int[] a,int[] b, int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            sort(arr,a,b, l, m);
            sort(arr ,a,b, m+1, r);
 
            // Merge the sorted halves
            merge(arr,a,b, l, m, r);
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
class BinaryTree
{
	int key;
BinaryTree right;
	BinaryTree left;

}
 class Permutation
{
	int k=0;
	String[] s=new String[1000];
	public String[] function()
	{
	return s;
	}
	
    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r)
    {
        if (l == r){
            s[k]=str;
		k++;
		}
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
 
    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
 
}
// Java Program to show segment tree operations like construction,
// query and update

class SegmentTree 
{
    int st[]; // The array that stores segment tree nodes
 
    /* Constructor to construct segment tree from given array. This
       constructor  allocates memory for segment tree and calls
       constructSTUtil() to  fill the allocated memory */
    SegmentTree(int arr[], int n)
    {
        // Allocate memory for segment tree
        //Height of segment tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
 
        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
 
        st = new int[max_size]; // Memory allocation
 
        constructSTUtil(arr, 0, n - 1, 0);
    }
 
    // A utility function to get the middle index from corner indexes.
    int getMid(int s, int e) {
        return s + (e - s) / 2;
    }
 
    /*  A recursive function to get the sum of values in given range
        of the array.  The following are parameters for this function.
 
      st    --> Pointer to segment tree
      si    --> Index of current node in the segment tree. Initially
                0 is passed as root is always at index 0
      ss & se  --> Starting and ending indexes of the segment represented
                    by current node, i.e., st[si]
      qs & qe  --> Starting and ending indexes of query range */
    int getSumUtil(int ss, int se, int qs, int qe, int si)
    {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (qs <= ss && qe >= se)
            return st[si];
 
        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return 0;
 
        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
                getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }
 
    /* A recursive function to update the nodes which have the given 
       index in their range. The following are parameters
        st, si, ss and se are same as getSumUtil()
        i    --> index of the element to be updated. This index is in
                 input array.
       diff --> Value to be added to all nodes which have i in range */
    void updateValueUtil(int ss, int se, int i, int diff, int si)
    {
        // Base Case: If the input index lies outside the range of 
        // this segment
        if (i < ss || i > se)
            return;
 
        // If the input index is in range of this node, then update the
        // value of the node and its children
        st[si] = st[si] + diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }
 
    // The function to update a value in input array and segment tree.
   // It uses updateValueUtil() to update the value in segment tree
    void updateValue(int arr[], int n, int i, int new_val)
    {
        // Check for erroneous input index
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }
 
        // Get the difference between new value and old value
        int diff = new_val - arr[i];
 
        // Update the value in array
        arr[i] = new_val;
 
        // Update the values of nodes in segment tree
        updateValueUtil(0, n - 1, i, diff, 0);
    }
 
    // Return sum of elements in range from index qs (quey start) to
   // qe (query end).  It mainly uses getSumUtil()
    int getSum(int n, int qs, int qe)
    {
        // Check for erroneous input values
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSumUtil(0, n - 1, qs, qe, 0);
    }
 
    // A recursive function that constructs Segment Tree for array[ss..se].
    // si is index of current node in segment tree st
    int constructSTUtil(int arr[], int ss, int se, int si)
    {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }
 
        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        int mid = getMid(ss, se);
        st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) +
                 constructSTUtil(arr, mid + 1, se, si * 2 + 2);
        return st[si];
    }
 
    // Driver program to test above functions
   
}
//This code is contributed by Ankur Narain Verma
