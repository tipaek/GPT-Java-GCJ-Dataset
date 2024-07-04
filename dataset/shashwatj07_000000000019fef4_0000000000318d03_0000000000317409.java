/* package codechef; // don't place package name! */

import java.util.*;

import java.io.*;
import java.math.*;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	static int arr[]=new int[1000];
	static int top=-1;
	public static void main (String[] args) throws IOException
	{
//		Reader s=new Reader();
		  PrintWriter pt=new PrintWriter(System.out);
		  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		  int T=s.nextInt();
		  int T=Integer.parseInt(br.readLine());
//		  int T=1;
		  for(int A=1;A<=T;A++)
		  {
			  StringTokenizer st=new StringTokenizer(br.readLine(), " ");
			  int x=Integer.parseInt(st.nextToken());
			  int y=Integer.parseInt(st.nextToken());
			  char ch[]=st.nextToken().toCharArray();
			  int a=x,b=y;
			  int ans=-1;
			  boolean flag=false;
			  for(int i=0;i<ch.length;i++) {
				  if(ch[i]=='S')
					  y--;
				  else if(ch[i]=='N')
					  y++;
				  else if(ch[i]=='E')
					  x++;
				  else
					  x--;
				  int p=Math.abs(x);
				  int q=Math.abs(y);
				  if(p+q<=i+1) {
					  ans=i+1;
					  flag =true;
					  break;
				  }
				  
			  }
			  
			  
			  pt.print("Case #"+A+": ");
			  if(flag) {
				  pt.println(ans);
			  }
			  else
				  pt.println("IMPOSSIBLE");
		  }
		  pt.close();
	}
	static void push(int n) {
		arr[++top]=n;
	}
	static int pop() {
		return arr[top--];
	}
	static void print(long arr[], int n) {
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	static long fix(long a,long n)
	{
		if(a>0)
			return a%n;
		else
		{
			while(a<=0)
				a+=(-a/n+1)*n;
			return a%n;
		}
	}
	static void add(StringBuffer sb, int x, int y)
	{
		if(x>0)
		{
			for(int i=0;i<x;i++)
				sb.append("R");
		}
		else
		{
			for(int i=0;i<-x;i++)
				sb.append("L");
		}
		if(y>0)
		{
			for(int i=0;i<y;i++)
				sb.append("D");
		}
		else
		{
			for(int i=0;i<-y;i++)
				sb.append("U");
		}
	}
	static void pa(int a[])
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		
	}
	static void pa(long a[])
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		
	}
	static void reverseArray(int arr[], 
            int start, int end) 
	{ 
		int temp; 
		   
		while (start < end) 
		{ 
		    temp = arr[start];  
		    arr[start] = arr[end]; 
		    arr[end] = temp; 
		    start++; 
		    end--; 
		}  
	}     
	static boolean isp(String s) {
		int l=s.length();
		for(int i=0;i<l/2;i++)
		{
			if(s.charAt(i)!=s.charAt(l-i-1))
				return false;
		}
		return true;
	}
	static long nc2(long n, long m) {
		return (n*(n-1)/2)%m;
	}
	static long c(long a) {
		return a*(a+1)/2;
	}
	static int next(int[] arr, int target)  
    {  
        int start = 0, end = arr.length - 1;  
    
        int ans = -1;  
        while (start <= end) {  
            int mid = (start + end) / 2;  
    
            // Move to right side if target is  
            // greater.  
            if (arr[mid] <= target) {  
                start = mid + 1;  
            }  
    
            // Move left side.  
            else {  
                ans = mid;  
                end = mid - 1;  
            }  
        }  
        return ans;  
    }  
	static String toString(char [] c)
	{
		StringBuffer b=new StringBuffer("");
		for(int i=0;i<c.length;i++)
			b.append(c[i]);
		return b.toString();
	}
	static long power(long x, long y, long p) 
    { 
        long res = 1; 
        x = x % p; 
                      
        while (y > 0) 
        { 
            if (y % 2 == 1) 
                res = (res * x) % p; 
            y = y >> 1;
            x = (x * x) % p; 
        } 
        return  res; 
    } 
    static long modInverse(long n, long p) 
    { 
        return power(n, p-2, p); 
    } 
    static long nCrModP(long n, long r, 
                                    long p) 
    { 
        if (r == 0) 
            return 1; 
        long[] fac = new long[(int) (n+1)]; 
        fac[0] = 1; 
        for (int i = 1 ;i <= n; i++) 
            fac[i] = fac[i-1] * i % p; 
        return (fac[(int) n]* modInverse(fac[(int) r], p) 
                % p * modInverse(fac[(int) (n-r)], p) 
                                    % p) % p; 
    } 
	static String rev(String str)
	{
		return new StringBuffer(str).reverse().toString();
	}

	static boolean search(int arr[], int n, int x) 
    { 
        for(int i=0;i<n;i++)
        	if(arr[i]==x)
        		return true;
        return false;
    }

	static long fastpow(long x, long y, long m)  
    { 
        if (y == 0) 
            return 1; 
          
        long p = fastpow(x, y / 2, m) % m; 
        p = (p * p) % m; 
      
        if (y % 2 == 0) 
            return p; 
        else
            return (x * p) % m; 
    } 
	
	static boolean isPerfectSquare(long l)
	{
		return Math.pow((long)Math.sqrt(l),2)==l;
	}
	
	
	static void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
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
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    static void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
    static class Pair implements Comparable<Pair>{
        int a;
        int b;
        Pair(int a,int b){
            this.a=a;
 
            this.b=b;
        }   
        public int compareTo(Pair p){
            if(a>p.a)
                return 1;
            if(a==p.a)
                return (b-p.b);
            return -1;
        }
    }
	static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 
}