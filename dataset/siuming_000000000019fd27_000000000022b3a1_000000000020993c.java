import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static int[] solve(int dim, int[][] matrix) {
        // calculate trace
        int trace = 0;
        for (int i = 0; i < dim; i++) {
            trace += matrix[i][i];
        }

        // calculate num of duplicates
        List<Set<Integer>> rowElementSets = new ArrayList<>();
        List<Set<Integer>> colElementSets = new ArrayList<>();
        for (int i = 0; i < dim; i++) {
            rowElementSets.add(new HashSet<Integer>());
            colElementSets.add(new HashSet<Integer>());
        }
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                rowElementSets.get(i).add(matrix[i][j]);
                colElementSets.get(j).add(matrix[i][j]);
            }
        }

        int numDupRows = 0;
        int numDupCols = 0;
        for (int i = 0; i < dim; i++) {
            if (rowElementSets.get(i).size() < dim) {
                numDupRows += 1;
            }
            if (colElementSets.get(i).size() < dim) {
                numDupCols += 1;
            }
        }
        return new int[] {trace, numDupRows, numDupCols};
    }
    
    public static void main(String... args) {
        try {
            // BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int n = in.nextInt();
            int[] dim = new int[n];
            List<int[][]> matrices = new ArrayList<>();
			for (int i = 0; i < n; i++) {
                dim[i] = in.nextInt();
                matrices.add(new int[dim[i]][dim[i]]);
                for (int j = 0; j < dim[i]; j++) {
                    for (int k = 0; k < dim[i]; k++) {
                        matrices.get(i)[j][k] = in.nextInt(); // 2nd index tranverse horizontally (col index), 1st index tranverse vertically (row index)
                    }
                }
			}
			for (int i = 0; i < n; i++) {
				int[] result = solve(dim[i], matrices.get(i));
				System.out.println(String.format("Case #%d: %d %d %d", i + 1, result[0], result[1], result[2]));
			}
		}
		catch (Throwable e) {
			e.printStackTrace();
			System.exit(1);
		}
    }
}