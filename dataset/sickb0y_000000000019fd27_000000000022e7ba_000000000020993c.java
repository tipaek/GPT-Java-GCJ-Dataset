import java.util.*;
import java.io.*;

class vest{
	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader (System.in));
		int no_test;
		String notest;
		notest = input.readLine();
		String[] temp;
		if(notest == null)
			return;
		no_test = Integer.parseInt(notest);
		int k=0;
		while(k < no_test){
			String NN = input.readLine();
			int N = Integer.parseInt(NN);
			int[][] matrix = new int[N][N];
			for(int i =0; i < N;i++){
				NN = input.readLine();
				temp = new String[N];
				temp = NN.split(" ");
				for(int j=0;j<N;j++)
					matrix[i][j] = Integer.parseInt(temp[j]);
			}
			int rowcnt = 0;
			Set<Integer> set;
			for(int i=0;i<N;i++){
				set =  new HashSet<Integer>();
				for(int j=0;j<N;j++){
					if(set.add(matrix[i][j]) == false){
						rowcnt++;
						break;
					}
				}
			}
			int colcnt = 0;
			for(int i=0;i<N;i++){
				set =  new HashSet<Integer>();
				for(int j=0;j<N;j++){
					if(set.add(matrix[j][i]) == false){
						colcnt++;
						break;
					}
				}
			}
			int trace = 0;
			for(int i=0;i<N;i++)
				trace += matrix[i][i];
			System.out.println("Case #"+Integer.toString(k+1) + ": "+Integer.toString(trace)+ " "+Integer.toString(rowcnt)+ " "+Integer.toString(colcnt));
			k++;
		}
	}
	//private static String solve(double a){
	//	return "";
	//}
}