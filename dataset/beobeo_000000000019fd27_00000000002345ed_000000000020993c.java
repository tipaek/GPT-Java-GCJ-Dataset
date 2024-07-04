import java.util.*;

public class Solution {
    
    public static int[] getResult(int[][] matrix) {
        int[] result = new int[3];
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        result[0] = trace;
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> check = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (!check.isEmpty() && check.contains(matrix[i][j])) {
                    row++;
                    break;
                }
                check.add(matrix[i][j]);
            }   
        }
        result[1] = row;
        
        int column = 0;
        for (int j = 0; j < matrix.length; j++) {
            Set<Integer> check = new HashSet<>();
            for (int i = 0; i < matrix.length; i++) {
                if (!check.isEmpty() && check.contains(matrix[i][j])) {
                    column++;
                    break;
                }
                check.add(matrix[i][j]);
            }
        }
        result[2] = column;
            
        return result;
    }
    
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int size = scanner.nextInt();
			int[][] matrix = new int[size][size];
			for (int j = 0; j < size; j++) {
			    for (int k = 0; k < size; k++) {
			        matrix[j][k] = scanner.nextInt(); 
			    }
			}
			int[] result = getResult(matrix);
			System.out.println("Case #" + (i + 1) + ": " + result[0] + " " + result[1] + " " + result[2]);
		}
	}
}