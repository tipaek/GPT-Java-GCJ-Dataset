import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.math.BigInteger;


class Solution 
{   
	static int count=0;
	static int a=1;
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

		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 

		long nextLong() 
		{ 
			return Long.parseLong(next()); 
		} 

		double nextDouble() 
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
		void shuffleArrayII(Integer[] brr){
			int n = brr.length;
			Random rnd = new Random();
			for(int i=0; i<n; ++i){
				int tmp = brr[i];
				int randomPos = i + rnd.nextInt(n-i);
				brr[i] = brr[randomPos];
				brr[randomPos] = tmp;
			}   
		}
		void shuffleArrayI(int[] brr){
			int n = brr.length;
			Random rnd = new Random();
			for(int i=0; i<n; ++i){
				int tmp = brr[i];
				int randomPos = i + rnd.nextInt(n-i);
				brr[i] = brr[randomPos];
				brr[randomPos] = tmp;
			}   
		}

		void shuffleArrayL(long[] arr){
			int n = arr.length;
			Random rnd = new Random();
			for(int i=0; i<n; ++i){
				long tmp = arr[i];
				int randomPos = i + rnd.nextInt(n-i);
				arr[i] = arr[randomPos];
				arr[randomPos] = tmp;
			}   
		}
		void input(int []a,int n){
			for(int i=0;i<n;i++) {
				a[i]=nextInt();
			}
		}
	} 

	public static void main(String[] args) 
	{ 
		FastReader s=new FastReader(); 
		int tc=s.nextInt();
		while(tc-->0) {
			count=0;
			int x=s.nextInt();
			int y=s.nextInt();
			int lx=Math.abs(x);
			int ly=Math.abs(y);
			String ans="";
			recursion(0,0,x,y,lx,ly,1,ans);
			if(count<1)
				System.out.println("Case #"+a+": IMPOSSIBLE");
			a++;
		}
		
	}

	private static void recursion(int i, int j, int x, int y,int lx,int ly, int k, String ans) {
		
		if(i==x && j==y) {
			System.out.println("Case #"+a+": "+ ans);
			count++;
			return;
		}
		
		if(i>2*lx ||i<-2*lx || j>2*ly || j<-2*ly)
			return ;
		if(count<1) {
		recursion(i, j+(int)Math.pow(2, k-1), x, y,lx,ly, k+1, ans+"N");
		recursion(i, j-(int)Math.pow(2, k-1), x, y,lx,ly, k+1, ans+"S");
		recursion(i+(int)Math.pow(2, k-1), j, x, y,lx,ly, k+1, ans+"E");
		recursion(i-(int)Math.pow(2, k-1), j, x, y,lx,ly, k+1, ans+"W");
		}
		
	}

}