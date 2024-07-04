import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
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
				catch (IOException e) 
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
	} 
	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int i,j,k,t= fs.nextInt();
		for(i=0;i<t;i++){
			int N = fs.nextInt();
			int a[][] = new int[N][N];
			for(j=0;j<N;j++){
				for(k=0;k<N;k++){
					a[j][k]=fs.nextInt();
				}
			}
			int rCount = 0, cCount=0;
			for(j=0;j<N;j++){
				boolean[] rFlag = new boolean[N];
				for(k=0;k<N;k++){
					int ind = a[j][k];
					if(rFlag[ind-1]){
						rCount++;
						break;
					}
					rFlag[ind-1]=true;
				}
			}
			for(j=0;j<N;j++){
				boolean[] lFlag = new boolean[N];
				for(k=0;k<N;k++){
					int ind = a[k][j];
					if(lFlag[ind-1]){
						cCount++;
						break;
					}
					lFlag[ind-1]=true;
				}
			}
			int trace=0;
			for(j=0;j<N;j++){
				trace+=a[j][j];
			}
			System.out.println("Case #"+(i+1)+": "+trace+" "+rCount+" "+cCount);
		}
	}
	public static int minHoursNeeded(int[] a, int b){
		int i, j, k, min=Integer.MAX_VALUE;
		int sum=0;
		for(i=0; i<a.length;i++){
			if((sum+a[i])>b){
				break;
			}
			sum+=a[i];
		}	
		return i;
	}
}
