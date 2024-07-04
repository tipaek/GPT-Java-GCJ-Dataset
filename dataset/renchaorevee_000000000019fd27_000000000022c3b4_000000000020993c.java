public class Vestigium {
	public static void main(String[] args) {
		try {
			BufferedReader reader =
	                 new BufferedReader(new InputStreamReader(System.in));
			int numOfTestCases = Integer.parseInt(reader.readLine(), 10);
			for (int i = 0; i < numOfTestCases; i++) {
				int n = Integer.parseInt(reader.readLine(), 10);
				int[][] matrix = new int[n][n];
				for (int j = 0; j < n; j++) {
					String line = reader.readLine();
					String[] numbers = line.split(" ");
					for (int k = 0; k < n; k++) {
						matrix[j][k] = Integer.parseInt(numbers[k], 10);
					} 
				}
				int[] r = solveSingleCase(matrix);
				System.out.println("Case #"+(i+1)+": " + r[0] + " " + r[1] + " " + r[2]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int[] solveSingleCase(int[][] matrix) {
		int trace = 0;
		int l = matrix.length;
		for (int i = 0; i < l; i++) {
			trace += matrix[i][i];
		}
		
		int numOfRepeatedRow = 0;
		for (int i = 0; i < l; i++) {
			boolean[] repeated = new boolean[l+1];
			for (int j = 0; j < l; j++) {
				int n = matrix[i][j];
				if (repeated[n]) {
					numOfRepeatedRow++;
					break;
				} else {
					repeated[n] = true;
				}
			}
		}
		
		int numOfRepeatedCol = 0;
		for (int i = 0; i < l; i++) {
			boolean[] repeated = new boolean[l+1];
			for (int j = 0; j < l; j++) {
				int n = matrix[j][i];
				if (repeated[n]) {
					numOfRepeatedCol++;
					break;
				} else {
					repeated[n] = true;
				}
			}
		}
		
		return new int[] {trace, numOfRepeatedRow, numOfRepeatedCol};
	}
}
