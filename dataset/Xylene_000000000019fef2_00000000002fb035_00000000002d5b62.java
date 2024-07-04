import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{	
   static long mod=(long)(1e+9 + 7);
   //static long mod=(long)998244353;
   
   static int[] sieve;
   static ArrayList<Integer> primes;
   static PrintWriter out;
   static fast s;
   static StringBuilder fans;
   
   static class Pair
   {
   	int val;
   	String str;
   	
   	public Pair(int x,String str)
   	{
   		this.val=x;
   		this.str=str;
   	}
   }
   
   public static Pair solve(int r,int c,int x,int y,HashMap<String,Pair> dp,int jump)
   {	
   	if(jump>=100 || r>=300 || c>=300 || r<=-300 || c<=-300)
   		{
   			if(r==x && c==y) return new Pair(0,new String(""));
   			return new Pair(Integer.MAX_VALUE/4,new String(""));
   		}
   	
   	if(r==x && c==y) return new Pair(0,new String(""));
   	
   	String key=new String(r+" "+c+" "+jump);
   	if(dp.containsKey(key)) return dp.get(key);
   	
   	int delta=(int)Math.pow(2, jump);
   	
   	Pair a1=solve(r+delta,c,x,y,dp,jump+1);
   	Pair a2=solve(r-delta,c,x,y,dp,jump+1);
   	Pair a3=solve(r,c+delta,x,y,dp,jump+1);
   	Pair a4=solve(r,c-delta,x,y,dp,jump+1);
   	
   	Pair ret=new Pair(0,"");
   	   	
   	int mini=Math.min(Math.min(a1.val,a2.val),Math.min(a3.val,a4.val));
   	ret.val=mini+1;
   	
   	if(mini==a1.val) ret.str="E"+a1.str;
   	else if(mini==a2.val) ret.str="W"+a2.str;
   	else if(mini==a3.val) ret.str="N"+a3.str;
   	else if(mini==a4.val) ret.str="S"+a4.str;
   	
   	dp.put(key, ret);
   	return ret;
   }
   
   public static void solve(int t)
   {
   	int x=s.nextInt();
   	int y=s.nextInt();
   	
   	HashMap<String,Pair> dp=new HashMap<String,Pair>();
   	
//   	int dp[][][]=new int[1005][1005][55];
//   	
//   	for(int i=0;i<dp.length;i++) for(int j=0;j<dp[0].length;j++) for(int k=0;k<dp[0][0].length;k++) dp[i][j][k]=-1;
//   	
   	Pair ans=solve(0,0,x,y,dp,0);
   	if(ans.val>=Integer.MAX_VALUE/4)
   		fans.append("Case #"+t+": IMPOSSIBLE\n");
   	else
   		{
   	   	fans.append("Case #"+t+": "+ans.str+"\n");	
   		}
   }
   
   public static void main(String[] args) throws java.lang.Exception
   {	  	
	     s = new fast();
	     out=new PrintWriter(System.out);
	     fans=new StringBuilder("");
		  
	     int t=s.nextInt();
	     int cnt=1;
	     
	     while(t>0)
	    	 {
	    		 solve(cnt++);
	    		 t--;
	    	 }
	    
	    out.println(fans);
	    out.close();
   }
  
 
 
static class fast {   
	
	   private InputStream i;
		private byte[]  buf = new byte[1024];
		private int curChar;
		
		private int numChars;
		
		//Return floor log2n
		public static long log2(long bits) // returns 0 for bits=0
			{
			    int log = 0;
			    if( ( bits & 0xffff0000 ) != 0 ) { bits >>>= 16; log = 16; }
			    if( bits >= 256 ) { bits >>>= 8; log += 8; }
			    if( bits >= 16  ) { bits >>>= 4; log += 4; }
			    if( bits >= 4   ) { bits >>>= 2; log += 2; }
			    return log + ( bits >>> 1 );
			}
		
		public static boolean next_permutation(int a[])
		   {
			   int i=0,j=0;int index=-1;	   
			   int n=a.length;
			   
			   for(i=0;i<n-1;i++)
				   if(a[i]<a[i+1]) index=i;
			   
			   if(index==-1) return false;
			   i=index;
 
			  
			   for(j=i+1;j<n && a[i]<a[j];j++);
 
			   int temp=a[i];
			   a[i]=a[j-1];
			   a[j-1]=temp;
			   	   
			   for(int p=i+1,q=n-1;p<q;p++,q--)
			   {
				   temp=a[p];
				   a[p]=a[q];
				   a[q]=temp;
			   }
			   
			   return true;
		   }
		   
		   
		public static void division(char ch[],int divisor)
		   {
			   int div=Character.getNumericValue(ch[0]); int mul=10;int remainder=0;
			   StringBuilder quotient=new StringBuilder("");
			   for(int i=1;i<ch.length;i++)
			   {
				   div=div*mul+Character.getNumericValue(ch[i]);	
				   if(div<divisor) {quotient.append("0");continue;}
				   quotient.append(div/divisor);
				   div=div%divisor;mul=10;
				   
			   } 
			   remainder=div;
			   while(quotient.charAt(0)=='0')quotient.deleteCharAt(0);	   
			   System.out.println(quotient+" "+remainder);	  
		   }
		
		public static void sieve(int size)
		{
			sieve=new int[size+1];
			
			primes=new ArrayList<Integer>();
			
			sieve[1]=1;
			
			for(int i=2;i*i<=size;i++)
			{
				if(sieve[i]==0)
				 {
					for(int j=i*i;j<size;j+=i) {sieve[j]=1;}
				 }
			}
			
			for(int i=2;i<=size;i++)
			{
				if(sieve[i]==0) primes.add(i);
			}
		}
		
		public static long pow(long n, long b, long MOD)
		   {
		       long x=1;long y=n; 
		       while(b > 0)
		       {
		           if(b%2 == 1)
		           {
		               x=x*y;
		               if(x>MOD) x=x%(MOD);
		           }
		           y = y*y;
		           if(y>MOD) y=y%(MOD); 
		           b >>= 1;
		       }
		       return x;
		   }
 
 
		public static long mod_inv(long n,long mod)
		{
			return pow(n,mod-2,mod);
		}
		
		//Returns index of highest number less than or equal to key
		 public static int upper(long[] a,int length,long key)
		 {
			    int low = 0;
		        int high = length-1;
		        int ans=-1;
		        
		        while (low <= high) {
		            int mid = (low + high) / 2;
		            if (key >= a[mid]) {
		                ans=mid;
		            	low = mid+1;
		            } else if(a[mid]>key){
		                high = mid - 1;
		            }
		        }
		        return ans;
		}
		
		//Returns index of least number greater than or equal to key
		 public static int lower(long[] a,int length,long key)
		 {
			    int low = 0;
		        int high = length-1;
		        int ans=-1;
		        
		        while (low <= high) {
		            int mid = (low + high) / 2;
		            if (key<=a[mid]) {
		                ans=mid;
		            	high = mid-1;
		            }
		            else{
		            		low=mid+1;
		            	}
		        }
		        return ans;
		} 
		   
		public long gcd(long r,long ans)
		{
			if(r==0) return ans;
			return gcd(ans%r,r);
		}
		public fast() {
			this(System.in);
		}
		public fast(InputStream is) {
			i = is;
		}
		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = i.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}
		public String nextString() {
     		int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
		public boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
 
	}	
}