import java.util.*;
import java.io.*;

public class Solution {
    private static void solution(int[][] matrix, int caseNumber) {
        int k = 0, n = matrix.length;
        HashSet<Integer> repeatRows = new HashSet<>(), repeatColumns = new HashSet<>();
        ArrayList<HashSet<Integer>> rowNums = new ArrayList<>(n), colNums = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            rowNums.add(new HashSet<>());
            colNums.add(new HashSet<>());
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) k+= matrix[i][j];
                if(rowNums.get(i).contains(matrix[i][j])) repeatRows.add(i);
                else rowNums.get(i).add(matrix[i][j]);
                if(colNums.get(j).contains(matrix[i][j])) repeatColumns.add(j);
                else colNums.get(j).add(matrix[i][j]);
            }
        }
        System.out.println(String.format("Case #%d: %d %d %d", caseNumber, k, repeatRows.size(), repeatColumns.size()));
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for(int i = 1; i <= t; ++i) {
            int n = in.nextInt(); in.nextLine();
            int[][] matrix = new int[n][n];
            for(int r = 0; r < n; ++r) {
                for(int c = 0; c < n; ++c) matrix[r][c] = in.nextInt();
                in.nextLine();
            }
            solution(matrix, i);
        }
    }
} 