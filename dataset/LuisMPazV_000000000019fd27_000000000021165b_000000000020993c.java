import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		int numberOfCases=Integer.parseInt(in.readLine().trim());
		
		for (int i = 0; i < numberOfCases; i++) {
			int N=Integer.parseInt(in.readLine());
			
			int[][] matrix=new int[N][N];
			
			int trace=0;
			int rows=0;
			for (int j = 0; j < matrix.length; j++) {
				StringTokenizer skt=new StringTokenizer(in.readLine());
				HashSet<Integer> set=new HashSet<Integer>();
				for (int k = 0; k < matrix.length; k++) {
					matrix[j][k]=Integer.parseInt(skt.nextToken());
					if(j==k) {
						trace+=matrix[j][k];
					}
					set.add(matrix[j][k]);
					
				}
				if(set.size()!=N) {
					rows++;
				}
				
			}
			
			int cols=validateCol(matrix, N);
			
			out.write("Case #"+(i+1)+": "+trace+" "+rows+" "+cols+"\n");
			
			
			
		}
		out.close();

	}
	
	static int validateCol(int[][] matrix, int N) {
		int cols=0;
		for (int i = 0; i < matrix.length; i++) {
			HashSet<Integer> set=new HashSet<Integer>();
			for (int j = 0; j < matrix.length; j++) {
				set.add(matrix[j][i]);
			}
			
			if(set.size()!=N) {
				cols++;
			}
		}
		return cols;
	}

}
