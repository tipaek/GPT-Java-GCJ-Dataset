import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int inputs;
		Scanner sc = new Scanner(System.in);
		inputs = sc.nextInt();
		for(int i=0;i<inputs;i++) {
			int arraySize = sc.nextInt();
			int[][] arr1 = new int[arraySize][arraySize];
			for(int x=0;x<arraySize;x++) {
				for(int y=0;y<arraySize;y++) {
					arr1[x][y] = sc.nextInt();
				}
			}
			processArray(arr1, arraySize, i);
		}
		
	}

	private static void processArray(int[][] arr1, int arraySize, int caseNumber) {
		int diagonalSum = 0;
		int repeatedRows = 0;
		int repeatedCols = 0;
		caseNumber = caseNumber + 1;
		
		// diagonal sum
		for(int i=0;i<arraySize;i++) {
			diagonalSum += arr1[i][i];
		}
		
		// repeated rows
		Map<Integer, Integer> rowMap = new HashMap<>();
		for(int i=0;i<arraySize;i++) {
			for(int j=0;j<arraySize;j++) {
				if(rowMap.containsKey(arr1[i][j])) {
					repeatedRows++;
					break;
				} else {
					rowMap.put(arr1[i][j], 1);
				}
			}
			rowMap.clear();
		}
		rowMap.clear();
		//repeated cols
		
		for(int i=0;i<arraySize;i++) {
			for(int j=0;j<arraySize;j++) {
				if(rowMap.containsKey(arr1[j][i])) {
					repeatedCols++;
					break;
				} else {
					rowMap.put(arr1[j][i],1);
				}
			}
			rowMap.clear();
		}
		System.out.println("Case #"+caseNumber+": "+diagonalSum+" "+repeatedRows+" "+repeatedCols);
		
	}
}
