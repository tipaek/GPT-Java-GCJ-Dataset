import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastReader sc=new FastReader();
		int T=sc.I();
		int test=0;
		while(test++<T)
		{
		    int n=sc.I();
		    		    System.out.print("Case #"+test+": ");
		    int[][] m=new int[n][3];
		    char[] c=new char[n];
		    for(int i=0;i<n;i++)
		    {
		        m[i][0]=sc.I();
		        m[i][1]=sc.I();
		        m[i][2]=i;
		    }
		    Arrays.sort(m,new Comparator<int[]>(){
		      public int compare(int[] o1,int[] o2)
		      {
		          if(o1[0]>o2[0])
		          return 1;
		          return -1;
		      }
		    });
		    StringBuffer sb=new StringBuffer();
		    int ce=0,je=0,f=0;
		    for(int i=0;i<n;i++)
		    {
		        int s=m[i][0];
		        int e=m[i][1];
		        if(ce<=s)
		        {
		           c[m[i][2]]='C';
		            ce=e;
		        }
		        else if(je<=s)
		        {
		            c[m[i][2]]='J';
		            je=e;
		        }
		        else{
		            f=1;
		            break;
		        }
		    }
		    if(f==1)
		    System.out.println("IMPOSSIBLE");
		    else
		    {
		    for(int i=0;i<n;i++)
		    System.out.print(c[i]);
		    System.out.println();
		    }
		    
		    

		}
	 }
	 static int modbinary(int[] b,int l,int r)
	 {
	     int n=r;
	     int m=(l+r)/2;
	     while(l<=r)
	     {
	         m=(l+r)/2;
	         if((m+1<=n&&b[m]>b[m+1])||m==n)
	         return m;
	         if(b[m]<b[l])
	         r=m-1;
	         else 
	         l=m+1;
	     }
	     return -1;
	 }
	 static int binarysearch(int x,int[] b,int l,int r)
	 {
	     if(l>r)
	     return -1;
	     int m=(l+r)/2;
	     if(x<b[l]||x>b[r])
	     return -1;
	     while(l<=r)
	     {
	         m=(l+r)/2;
	         if(b[m]==x)
	         return m;
	         if(b[m]>x)
	         r=m-1;
	         else
	         l=m+1;
	     }
	     return -1;
	 }
	 static int lower(int x,int b[],int n)
	 {
	     if(x<b[0])
	     return -1;
	     else if(x==b[0])
	     return 0;
	     if(x>=b[n-1])
	     return n-1;
	     int l=0,r=n-1,m=(l+r)/2;
	     while(l<=r)
	     {
	         m=(l+r)/2;
	         if(b[m]<=x&&b[m+1]>x)
	         return m;
	         else if(b[m]>x&&b[m-1]<=x)
	         return m-1;
	         if(b[m]>x)
	         r=m-1;
	         else if(b[m]<x)
	         l=m+1;
	     }
	     return -1;
	 }
	 static int upper(int x,int b[],int n)
	 {
	     if(x<=b[0])
	     return 0;
	     else if(x==b[n-1])
	     return n-1;
	     if(x>b[n-1])
	     return -1;
	     int l=0,r=n-1,m=(l+r)/2;
	     while(l<=r)
	     {
	         m=(l+r)/2;
	         if(b[m]<x&&b[m+1]>=x)
	         return m+1;
	         else if(b[m]>=x&&b[m-1]<x)
	         return m;
	         if(b[m]>x)
	         r=m-1;
	         else if(b[m]<x)
	         l=m+1;
	     }
	     return -1;
	 }
	 
	 static long power(long x, long y, long p) 
    { 
        // Initialize result 
        long res = 1;      
         
        // Update x if it is more   
        // than or equal to p 
        x = x % p;  
      
        while (y > 0) 
        { 
            // If y is odd, multiply x 
            // with result 
            if((y & 1)==1) 
                res = (res * x) % p; 
      
            // y must be even now 
            // y = y / 2 
            y = y >> 1;  
            x = (x * x) % p;  
        } 
        return res; 
    } 
	  static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int I() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long L() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double D() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    static int gcd(int a,int b)
		{
		    if(a%b==0)
		    return b;
		    return gcd(b,a%b);
		}
	static float power(float x, int y) 
    { 
        float temp; 
        if( y == 0) 
            return 1; 
        temp = power(x, y/2);  
          
        if (y%2 == 0) 
            return temp*temp; 
        else
        { 
            if(y > 0) 
                return x * temp * temp; 
            else
                return (temp * temp) / x; 
        } 
    } 
    static long pow(int a,int b)
    {
        long result=1;
        if(b==0)
        return 1;
        long x=a;
        while(b>0)
        {
            if(b%2!=0)
            result*=x;
            
            x=x*x;
            b=b/2;
        }
        return result;
    }
    
    static ArrayList<Integer> sieve(int n) 
    { 
        ArrayList<Integer> arr=new ArrayList<Integer>();
        boolean prime[] = new boolean[n+1]; 
        for(int i=2;i<n;i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <=n; p++) 
        { 
            if(prime[p] == true) 
            { 
                arr.add(p);
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
        return arr;
    } 
}