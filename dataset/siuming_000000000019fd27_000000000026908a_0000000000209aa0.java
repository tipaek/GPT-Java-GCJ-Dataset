import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    // private static boolean isValidSolution(int trace, int[][] matrix) {
    //     int dim = matrix.length;
    //     // check trace
    //     int trace2 = 0;
    //     for (int i = 0; i < dim; i++) {
    //         trace2 += matrix[i][i];
    //     }
    //     if (trace2 != trace) {
    //         return false;
    //     }

    //     // calculate num of duplicates
    //     List<Set<Integer>> rowElementSets = new ArrayList<>();
    //     List<Set<Integer>> colElementSets = new ArrayList<>();
    //     for (int i = 0; i < dim; i++) {
    //         rowElementSets.add(new HashSet<Integer>());
    //         colElementSets.add(new HashSet<Integer>());
    //     }
    //     for (int i = 0; i < dim; i++) {
    //         for (int j = 0; j < dim; j++) {
    //             if (rowElementSets.get(i).contains(matrix[i][j]) || colElementSets.get(j).contains(matrix[i][j])) {
    //                 return false;
    //             }
    //             rowElementSets.get(i).add(matrix[i][j]);
    //             colElementSets.get(j).add(matrix[i][j]);
    //         }
    //     }
    //     return true;
    // }

    private static boolean isValidMove(int[][] matrix, int row, int col, int num) {
        for (int i = 0; i < matrix.length; i++) {
            if ((matrix[i][col] == num) || (matrix[row][i] == num)) {
                return false;
            }
        }
        return true;
    }

    // private static void printSoln(List<int[]> soln) {
    //     soln.forEach(o -> System.out.print(Arrays.toString(o).concat(",")));
    //     System.out.println();
    // }

    private static List<List<Integer>> getAllPossibleDiag(int dim, int numMax, int trace) {
        // System.out.println(String.format("dim:%d numMax:%d trace:%d", dim, numMax, trace));
        if (dim == 1) {
            List<List<Integer>> retList = new ArrayList<>();
            List<Integer> node = new ArrayList<>();
            node.add(trace);
            retList.add(node);
            // System.out.print("hit base case: ");
            // System.out.println(retList);
            return retList;
        }

        List<List<Integer>> retSoln = new ArrayList<>();
        // for (int i = 1; i <= Math.min(trace - dim + 1, numMax); i++) {
        for (int i = 1; i <= trace - dim + 1; i++) {
            int temp = i;
            List<List<Integer>> subProbSoln = getAllPossibleDiag(dim - 1, numMax, trace - i);
            subProbSoln.forEach(diag -> {
                List<Integer> newDiag = new ArrayList<>();
                newDiag.addAll(diag);
                newDiag.add(temp);
                retSoln.add(newDiag);
            });
        }
        // System.out.println(retSoln);
        return retSoln;
    }

    private static boolean solveByBackTracking(int[][] matrix) {
        int dim = matrix.length;
        int row = -1; 
        int col = -1; 
        boolean isEmpty = true; 
        for (int i = 0; i < dim; i++) { 
            for (int j = 0; j < dim; j++) { 
                if (matrix[i][j] == 0) { 
                    row = i; 
                    col = j;
                    isEmpty = false;  
                    break; 
                } 
            } 
            if (!isEmpty) { 
                break; 
            }
        } 
        if (isEmpty) { 
            return true; 
        } 
      
        for (int num = 1; num <= dim; num++) { 
            if (isValidMove(matrix, row, col, num)) { 
                matrix[row][col] = num; 
                if (solveByBackTracking(matrix)) { 
                    return true; 
                } else {
                    matrix[row][col] = 0;
                } 
            } 
        }
        return false;
    }

    private static int[][] solve(int dim, int trace) {
        // System.out.println(String.format("%d %d", dim, trace));
        if (trace % dim == 0) {
            int diag = trace / dim;
            int[][] retMatrix = new int[dim][dim];
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    retMatrix[i][j] = (diag + i - j + dim) % (dim);
                    retMatrix[i][j] = (retMatrix[i][j] == 0) ? dim : retMatrix[i][j];
                }
            }
            return retMatrix;
        }

        // if (trace == dim * (dim + 1) / 2) {
        //     int[][] retMatrix = new int[dim][dim];
        //     for (int i = 0; i < dim; i++) {
        //         for (int j = 0; j < dim; j++) {
        //             retMatrix[i][j] = (i == j) ? i + 1 : 0;
        //         }
        //     }
        //     return solveByBackTracking(retMatrix) ? retMatrix : new int[0][0];
        // }

        // for (int i = 0; i < dim; i++) {
        //     for (int j = 0; j < dim; j++) {
        //         retMatrix[i][j] = (i == j) ? i + 1 : 0;
        //     }
        // }

        Set<List<Integer>> noDupDiags = new HashSet<>();
        getAllPossibleDiag(dim, dim, trace).forEach(diag -> {
            if (Collections.max(diag) <= dim) {
                Collections.sort(diag);
                noDupDiags.add(diag);
            }
        });

        // System.out.println(noDupDiags);

        for (List<Integer> diag: noDupDiags) {
            int[][] retMatrix = new int[dim][dim];
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    retMatrix[i][j] = (i == j) ? diag.get(i) : 0;
                }
            }
            if (solveByBackTracking(retMatrix)) {
                return retMatrix;
            }
        }
        return new int[0][0];
    }
    
    public static void main(String... args) {
    //     int dim = 4;
    //     int trace = 13;
    //     Set<List<Integer>> noDupDiags = new HashSet<>();
    //     getAllPossibleDiag(dim, dim, trace).forEach(diag -> {
    //         Collections.sort(diag);
    //         noDupDiags.add(diag);
    //     });
    //     System.out.println(getAllPossibleDiag(dim, dim, trace));
    //     System.out.println(noDupDiags);
    // }

    // public static void main2(String... args) {
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
                int[][] result = solve(dim[i], traces[i]);
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