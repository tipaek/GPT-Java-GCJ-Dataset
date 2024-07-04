
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution  {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int trace = 0;
			int nonUniqueRows = 0;
			int nonUniqueColumns = 0;
			int matrix = sc.nextInt();
			int[][] matrixArr = new int[matrix][matrix];
			for (int j = 0; j < matrix; j++) {
				Set<Integer> rowSet = new LinkedHashSet<>();
				boolean hasUniqueRow = true;
				
				for (int z = 0; z < matrix; z++) {
					Integer rowZ = Integer.valueOf(sc.nextInt());
					matrixArr[j][z] = Integer.valueOf(rowZ);
					if (rowSet.contains(rowZ) && hasUniqueRow) {
						nonUniqueRows++;
						hasUniqueRow = false;
					}
					rowSet.add(rowZ);
					if (j == z) {
						trace += rowZ;
					}
				}
				//System.out.println(rowSet);
			}
			for (int j = 0; j < matrix; j++) {
				Set<Integer> columnSet = new LinkedHashSet<>();
				boolean hasUniqueColumn = true;
				for (int z = 0; z < matrix; z++) {
					Integer columnZ = matrixArr[z][j];
					if (columnSet.contains(columnZ) && hasUniqueColumn) {
						nonUniqueColumns++;
						hasUniqueColumn = false;
					}
					columnSet.add(columnZ);
				}
				//System.out.println(columnSet);

			}
			System.out.println("Case #" + (i + 1) + ": " + trace + " " + nonUniqueRows + " " + nonUniqueColumns);
		}
		sc.close();
	}

}
