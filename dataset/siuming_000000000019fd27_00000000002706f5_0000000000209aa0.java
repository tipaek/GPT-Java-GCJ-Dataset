import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static boolean isValidSolution(int trace, Integer[][] matrix) {
        int dim = matrix.length;
        // check trace
        int trace2 = 0;
        for (int i = 0; i < dim; i++) {
            trace2 += matrix[i][i];
        }
        if (trace2 != trace) {
            return false;
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
                if (rowElementSets.get(i).contains(matrix[i][j]) || colElementSets.get(j).contains(matrix[i][j])) {
                    return false;
                }
                rowElementSets.get(i).add(matrix[i][j]);
                colElementSets.get(j).add(matrix[i][j]);
            }
        }
        return true;
    }

    private static Integer[][] solve(int dim, int trace) {
        // System.out.println(String.format("%d %d", dim, trace));
        long start = System.currentTimeMillis();
        Integer[][] ret = new Integer[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                ret[i][j] = j + 1;
            }
        }
        while ((System.currentTimeMillis() - start) / 1000F < 9.5) {
            for (int i = 0; i < dim; i++) {
                List<Integer> l = Arrays.asList(ret[i]);
                Collections.shuffle(l);
                ret[i] = l.toArray(new Integer[0]);
            }
            if (isValidSolution(trace, ret)) {
                return ret;
            }
        }
        return new Integer[0][0];
    }
    
    public static void main(String... args) {
        try {
            // BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int n = in.nextInt();
            int[] dim = new int[n];
            int[] traces = new int[n];
			for (int i = 0; i < n; i++) {
                dim[i] = in.nextInt();
                traces[i] = in.nextInt();
			}
			for (int i = 0; i < n; i++) {
                // long start = System.currentTimeMillis();
                Integer[][] result = solve(dim[i], traces[i]);
                // float elapsedTimeSec = (System.currentTimeMillis() - start) / 1000F;
                // System.out.println(String.format("time used: %.3f", elapsedTimeSec));
                // System.out.println(isValidSolution(traces[i], result));
                if (result.length == 0) {
                    System.out.println(String.format("Case #%d: IMPOSSIBLE", i + 1));
                } else {
                    System.out.println(String.format("Case #%d: POSSIBLE", i + 1));
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < result.length; j++) {
                        for (int k = 0; k < result[0].length; k++) {
                            sb.append(result[j][k]);  // 1st idx=row idx, 2nd idx=col idx
                            sb.append((k == result[0].length - 1) ? ((j == result.length - 1) ? "" : '\n') : ' ');
                        }
                    }
                    System.out.println(sb.toString());
                }
			}
		}
		catch (Throwable e) {
			e.printStackTrace();
			System.exit(1);
		}
    }
}