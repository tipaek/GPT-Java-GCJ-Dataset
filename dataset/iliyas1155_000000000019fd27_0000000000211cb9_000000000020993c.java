import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();
        for(int testCase=1; testCase<=cases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            Map<Integer, Set<Integer>> rowMap = new HashMap<>();
            Map<Integer, Set<Integer>> colMap = new HashMap<>();
            int k = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    Set<Integer> row = rowMap.computeIfAbsent(i, v->new HashSet<>());
                    Set<Integer> col = colMap.computeIfAbsent(j, v->new HashSet<>());
                    matrix[i][j] = scanner.nextInt();
                    if(i==j) k += matrix[i][j];
                    row.add(matrix[i][j]);
                    col.add(matrix[i][j]);
                }
            }
            int r = 0, c = 0;
            for(int i=0; i<n; i++) {
                r += rowMap.get(i).size()==n ? 0 : 1;
                c += colMap.get(i).size()==n ? 0 : 1;
            }
            System.out.println("Case #" + testCase + ": " + k + " " + r + " " + c);
        }
    }
}
