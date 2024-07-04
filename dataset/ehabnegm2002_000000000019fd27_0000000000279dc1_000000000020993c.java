public class Solution {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		
		int cases = scanner.nextInt();
		
		for (int testCase = 1; testCase <= cases; testCase++) {
			int size = scanner.nextInt();
			
			int[][] matrix = new int[size][size];
			
			for (int row = 0; row < size; row++) {
				for (int column = 0; column < size; column++) {
					matrix[row][column] = scanner.nextInt();
				}
			}
			int[] output = calcLatinSquare(matrix, size);
			System.out.println("Case #" + testCase + ": " + output[0] + " " + output[1] + " " + output[2]);
		}
		
		scanner.close();
	}
	
	private static int[] calcLatinSquare(int[][] matrix, int size) {
		
		int[] result = new int[3];
		
		for (int row = 0; row < size; row++) {
			Set<Integer> rowSet = new HashSet<>();
			Set<Integer> columnSet = new HashSet<>();
			
			boolean rowDup = false;
			boolean colDup = false;
			
			for (int column = 0; column < size; column++) {
				
				// Count trace
				if (row == column)
					result[0] += matrix[row][column];
				
				// Count duplicate values in rows
				if (rowSet.contains(matrix[row][column]))
					rowDup = true;
				
				rowSet.add(matrix[row][column]);
				
				// Count duplicate values in columns
				if (columnSet.contains(matrix[column][row]))
					colDup = true;
				
				columnSet.add(matrix[column][row]);
			}
			
			if (rowDup)
				result[1]++;
			
			if (colDup)
				result[2]++;
		}
		return result;
	}
}