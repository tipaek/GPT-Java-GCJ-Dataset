import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static boolean isValidSolution(int trace, List<List<Integer>> matrix) {
        int dim = matrix.size();
        // check trace
        int trace2 = 0;
        for (int i = 0; i < dim; i++) {
            trace2 += matrix.get(i).get(i);
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
                if (rowElementSets.get(i).contains(matrix.get(i).get(j)) || colElementSets.get(j).contains(matrix.get(i).get(j))) {
                    return false;
                }
                rowElementSets.get(i).add(matrix.get(i).get(j));
                colElementSets.get(j).add(matrix.get(i).get(j));
            }
        }
        return true;
    }

    private static List<List<Integer>> solve(int dim, int trace, double timeLimit) {
        // System.out.println(String.format("%d %d", dim, trace));
        long start = System.currentTimeMillis();
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < dim; i++) {
            ret.add(new ArrayList<>());
            for (int j = 0; j < dim; j++) {
                ret.get(i).add(j + 1);
            }
        }
        while ((System.currentTimeMillis() - start) / 1000F < timeLimit) {
            for (int i = 0; i < dim; i++) {
                Collections.shuffle(ret.get(i));
            }
            if (isValidSolution(trace, ret)) {
                return ret;
            }
        }
        return new ArrayList<>();
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
                List<List<Integer>> result = solve(dim[i], traces[i], 20. / n);
                // float elapsedTimeSec = (System.currentTimeMillis() - start) / 1000F;
                // System.out.println(String.format("time used: %.3f", elapsedTimeSec));
                // System.out.println(isValidSolution(traces[i], result));
                if (result.size() == 0) {
                    System.out.println(String.format("Case #%d: IMPOSSIBLE", i + 1));
                } else {
                    System.out.println(String.format("Case #%d: POSSIBLE", i + 1));
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < dim[i]; j++) {
                        for (int k = 0; k < dim[i]; k++) {
                            sb.append(result.get(j).get(k));  // 1st idx=row idx, 2nd idx=col idx
                            sb.append((k == dim[i] - 1) ? ((j == dim[i] - 1) ? "" : '\n') : ' ');
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