import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Trace {
	
	public static void main(String[] args){ 
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.hasNext() ? scanner.nextInt() : 0;
		for(int t=1; t<=testCase; t++){
			int n =	scanner.hasNext() ? scanner.nextInt() : 0;
			int sum = 0;
			int rowCount = 0;
			int columnCount = 0;
			int[][] matrix = new int[n][n];
			for(int i=0 ; i<n ; i++){
				Map<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
				boolean isRowCounted = false;
				for(int j=0; j<n; j++){
					matrix[i][j] = scanner.hasNext() ? scanner.nextInt() : 0;
					if(i == j){
						sum = sum + matrix[i][j];
					}
					if(!isRowCounted && rowMap.containsKey(matrix[i][j])){
						rowCount = rowCount +1;
						isRowCounted = true;
					} else{
						if(!isRowCounted){
							rowMap.put(matrix[i][j], 1);
						}
					}
				}
			}
			for(int i=0 ; i<n ; i++){
				Map<Integer, Integer> ColumnMap = new HashMap<Integer, Integer>();
				boolean isColumnCounted = false;
				for(int j=0; j<n; j++){
					if(!isColumnCounted && ColumnMap.containsKey(matrix[j][i])){
						columnCount = columnCount +1;
						isColumnCounted = true;
					} else{
						if(!isColumnCounted){
							ColumnMap.put(matrix[j][i], 1);
						}
					}
				}
			}
			System.out.println("Case #" + t + " : " + sum + " " + rowCount + " " + columnCount);
		}
		 
	}

}
