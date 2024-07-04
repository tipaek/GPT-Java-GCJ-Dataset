import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Solution {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out  =new  PrintWriter(System.out);
		int T= Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			long sum=0;
			int rows=0;
			int cols=0;
			int N = Integer.parseInt(br.readLine());
			int [][]matrix=new int[N][N];
			for(int i=0;i<N;i++){
				String []cur = br.readLine().split(" ");
				int freqCur []= new int[N+1];
				boolean flag=true;
				for(int j=0;j<N;j++){
					matrix[i][j]=Integer.parseInt(cur[j]);
					if(i==j)
						sum+=matrix[i][j];
					freqCur[matrix[i][j]]++;
					if(flag&&freqCur[matrix[i][j]]==2){
						rows++;
						flag=false;
					}
				}
			}
			
//			for(int i=0;i<N;i++){
//				for(int j=0;j<N;j++){
//					System.out.print(matrix[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			
			
		
			for(int i=0;i<N;i++){
				int freqCur[]= new int[N+1];
				boolean flag=true;
				for(int j=0;j<N;j++){
					freqCur[matrix[j][i]]++;
					if(flag&&freqCur[matrix[j][i]]==2){
						cols++;
						flag=false;
					}
				}
			}
			if(t==T-1){
				out.print("Case #"+(t+1)+": "+sum+" "+rows+" "+cols);
			}
			else
				out.println("Case #"+(t+1)+": "+sum+" "+rows+" "+cols);
		}
		out.close();
		out.flush();
	
	}

}
