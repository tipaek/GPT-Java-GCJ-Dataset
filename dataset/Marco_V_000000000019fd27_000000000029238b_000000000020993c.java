import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());

		
		for(int i=0;i<n;i++) {
			
			int size = Integer.parseInt(br.readLine());
			
			int[][] matrix = new int[size][size];
			
			for(int j=0;j<size;j++) {
				
				String[] line = br.readLine().split(" ");
				for(int k=0;k<line.length;k++) {
					matrix[j][k]=Integer.parseInt(line[k]);
				}
			}
			
			int trace = findTrace(matrix);
			int rRows = 0;
			int rColumns = 0;
			
			for(int j=0;j<size;j++) {
				if(findRepeatedNumber(matrix[j])) {
					rRows++;
				}
				int column[] = new int[size];
				
				for(int k=0;k<size;k++) {
					column[k]=matrix[k][j];
				}
				if(findRepeatedNumber(column)) {
					rColumns++;
				}
			}
		
			bw.write("case #"+(i+1)+":"+" "+trace+" "+rRows+" "+rColumns+"\n");
		}
		
		
		br.close();
		bw.close();
	}
	
	public static int findTrace(int[][] m) {
		int trace=0;
		
		for(int i=0;i<m.length;i++) {
			trace+=m[i][i];
		}	
		return trace;
	}
	
	public static boolean findRepeatedNumber(int[]row) {
		for(int i=0;i<row.length;i++) {
			
			for(int j=i+1;j<row.length;j++) {
				if(row[i]==row[j]) {
					return true;
				}
			}
		}
		return false;
	}
}	