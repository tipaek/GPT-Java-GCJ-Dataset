import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
 
public class Vestigium{
 
	public static void main(String args[]) throws Exception{
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		new Vestigium().solve(br,pw);
		br.close();
		pw.flush();
		pw.close();
		System.exit(0);
	}
 
	void solve(BufferedReader br,PrintWriter pw) throws Exception{
		
		int T = Integer.parseInt(br.readLine());	
		for(int i = 0;i < T;i++){
			int N = Integer.parseInt(br.readLine());
			int M[][] = new int[N][N];
			for(int j = 0;j < N;j++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = 0;k < N;k++){
					
					M[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int trace = 0;
			for(int j = 0;j < N;j++){
				trace += M[j][j];
			}
			int rowsum[][] = new int[N][N];
			for(int j = 0;j < N;j++){
				for(int k = 0;k < N;k++){
					rowsum[j][M[j][k] - 1]++;
				}
			}
			int colsum[][] = new int[N][N];
			for(int j = 0;j < N;j++){
				for(int k = 0;k < N;k++){
					colsum[j][M[k][j] - 1]++;
				}
			}
			int r = 0;
			for(int j = 0;j < N;j++){
				for(int k = 0;k < N;k++){
					if(rowsum[j][k] > 1){
						r++;
						break;
					}
				}
			}
			
			int c = 0;
			for(int j = 0;j < N;j++){
				for(int k = 0;k < N;k++){
					if(colsum[j][k] > 1){
						c++;
						break;
					}
				}
			}
			pw.println("Case #" + (i+1) + ": "+trace+" "+ r+" "+ c);
			
		}
		
		
		

	}
}


