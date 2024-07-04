import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tt = 0; tt < t; tt++) {
            int n = sc.nextInt(), k = sc.nextInt();
            List<Integer> counts = new ArrayList<>();
            for(int i = 0; i <=n; i++) counts.add(0);
            int[][] matrix = calculateMatrix(n, k, counts, 0, new HashSet<>(), new HashSet<>());
            if(matrix.length == 0) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", tt+1));
            } else {
                StringBuilder result = new StringBuilder().append(String.format("Case #%d: POSSIBLE\n", tt+1));
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        result.append(matrix[i][j]);
                        if(j < n-1) result.append(" ");
                    }
                    result.append('\n');
                }
                System.out.print(result);
            }
        }
    }

    private static int[][] calculateMatrix(int n, int k, List<Integer> counts, int total, Set<Integer> forbiddenNums, Set<List<Integer>> tried) {
        if(k < 0 || tried.contains(counts) || (total == n && k > 0)) {
            tried.add(new ArrayList<>(counts));
            return new int[0][];
        }

        if(k == 0 && total == n) {
            if(forbiddenNums.size() == 0) {
                int[][] matrix = new int[n][n];
                BitSet[] rowValues = new BitSet[n];
                BitSet[] columnValues = new BitSet[n];
                int row = 0;
                for(int i = 0; i < n; i++) {
                    rowValues[i] = new BitSet(n+1);
                    columnValues[i] = new BitSet(n+1);
                }

                for(int i = 1; i <= n; i++) {
                    while (counts.get(i) > 0) {
                        matrix[row][row] = i;
                        rowValues[row].set(i);
                        columnValues[row++].set(i);

                        counts.set(i, counts.get(i)-1);
                    }
                }
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < i; j++) {
                        for(int w = 1; w <=n; w++) {
                            if(!rowValues[i].get(w) && !columnValues[j].get(w)) {
                                rowValues[i].set(w);
                                columnValues[j].set(w);
                                matrix[i][j] = w;
                                break;
                            }
                        }
                    }
                }
                for(int i = 0; i < n; i++) {
                    for(int j = i+1; j < n; j++) {
                        for(int w = 1; w <=n; w++) {
                            if(!rowValues[i].get(w) && !columnValues[j].get(w)) {
                                rowValues[i].set(w);
                                columnValues[j].set(w);
                                matrix[i][j] = w;
                                break;
                            }
                        }
                    }
                }
                return matrix;
            } else {
                tried.add(new ArrayList<>(counts));
                return new int[0][];
            }
        }

        for(int i = 1; i <= n; i++) {
            counts.set(i, counts.get(i)+1);
            total++;
            if(counts.get(i) == n-1) forbiddenNums.add(i);
            if(counts.get(i) == n) forbiddenNums.remove(i);
            int[][] matrix = calculateMatrix(n, k-i, counts, total, forbiddenNums, tried);
            if(matrix.length > 0) return matrix;
            tried.add(new ArrayList<>(counts));
            if(counts.get(i) == n-1) forbiddenNums.remove(i);
            if(counts.get(i) == n) forbiddenNums.add(i);
            counts.set(i, counts.get(i)-1);
            total--;
        }

        tried.add(new ArrayList<>(counts));
        return new int[0][];
    }
}
