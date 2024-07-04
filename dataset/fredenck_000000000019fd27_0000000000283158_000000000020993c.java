
import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0; i<T; i++){
			int N = Integer.parseInt(br.readLine());
			int[][] mtrx = new int[N][N];
			int trace = 0;
			int rr = 0;
			int cr = 0;
			
			for (int j=0; j<N; j++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				ArrayList<Integer> soFarRow = new ArrayList<Integer>();
				boolean flag = true;
				
				for (int k=0; k<N; k++){
					int num = Integer.parseInt(st.nextToken());
					
					if (soFarRow.contains(num) && flag){
						rr++;
						flag = false;
					}
					mtrx[j][k] = num;
					
					if (j==k){
						trace += num;
					}
					soFarRow.add(num);
				}
			}
			
			for (int a=0; a<N; a++){
				ArrayList<Integer> soFarCol = new ArrayList<Integer>();
				for (int b=0; b<N; b++){
					int num = mtrx[b][a];//going down
					if (soFarCol.contains(num)){
						cr++;
					}
					soFarCol.add(num);
				}
			}
			if (rr>N){
				rr = N;
			}
			if (cr>N){
				cr = N;
			}
			System.out.println("Case #" + (i+1) + ": " + trace + " " + rr + " " + cr);
		}
		
		
//		out.close();
		br.close();
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " ns");
	}
}
