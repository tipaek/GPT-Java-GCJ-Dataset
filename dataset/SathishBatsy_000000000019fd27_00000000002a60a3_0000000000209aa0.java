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
			int K =fs.nextInt();
			
			indi(N,K,i+1);
		}
	}
	public static void indi(int N, int K, int ind){
		int [] order = new int[N];
		for(int t=0;t<N;t++){
			order[t]=t+1;
		}
		if(N==2){
			if(K%N==0){
				int div = K/N;
				System.out.println("Case #"+(ind)+": POSSIBLE");
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						System.out.print((order[(j+div-1+N-i+N)%N])+" ");
					}if(i!=N-1){
					System.out.println();
					}
				}
			}
			else{
				System.out.println("Case #"+(ind)+": IMPOSSIBLE");
			}
		}
		else if(N%2==1){
			if(K%N==0){
				int div = K/N;
				System.out.println("Case #"+(ind)+": POSSIBLE");
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						System.out.print((order[(j+div-1+N-i+N)%N])+" ");
					}
					if(i!=N-1){
						System.out.println();
						}
				}
			}
			else if(K==((N*(N+1))/2)){
				System.out.println("Case #"+(ind)+": POSSIBLE");
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						System.out.print((order[(i-j+N)%N])+" ");
					}
					if(i!=N-1){
						System.out.println();
						}
				}
			}
			else{
				System.out.println("Case #"+(ind)+": IMPOSSIBLE");
				//imp
			}
		}
		else{
			int firstHalf = ((N/2)*((N/2)+1))/2;
			int secondHalf = firstHalf+((N/2)*(N/2));
			if(K%N==0){
				int div = K/N;
				System.out.println("Case #"+(ind)+": POSSIBLE");
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						System.out.print((order[(j+div-1+N-i+N)%N])+" ");
					}
					if(i!=N-1){
						System.out.println();
						}
				}
				
			}
			else if(K%2==0 && ((K/2)>=firstHalf && (K/2)<=secondHalf)){
				int temp = ((K/2)-firstHalf)/(N/2);
				if(temp>N/2){
					temp = N/2;
				}
				int l=1+temp;
				int r=(N/2)+temp;
				int tot = firstHalf + ((N/2)*temp);
				int diff = (K/2)-tot;
				boolean flag[] = new boolean[N+1];
				int[] odd = new int[N/2];
				int lTe = l;
				for(int i=0; i<odd.length;i++){
					odd[i]=lTe++;
				}
				if(diff > 0){
					int newSwap = r+1-diff;
					odd[newSwap-l]=r+1;
				}
				for(int i=0; i<odd.length;i++){
					flag[odd[i]]=true;
				}
				int[] even = new int[N/2];
				int cnt=0;
				for(int i=1;i<=N;i++){
					if(!flag[i]){
						even[cnt++]=i;
					}
				}
				cnt=0;
				int[] out = new int[N];
				for(int i=0;i<(N/2);i++){
					out[cnt++]=odd[i];
					out[cnt++]=even[i];
				}
				System.out.println("Case #"+(ind)+": POSSIBLE");
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						System.out.print((out[(j+i)%N])+" ");
					}
					if(i!=N-1){
						System.out.println();
						}
				}
			}
			else{
				System.out.println("Case #"+(ind)+": IMPOSSIBLE");
				//imp
			}
		}
		
	}
}
