import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int numberTests;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line = br.readLine();
            numberTests = Integer.valueOf(line);
            for (int i = 0; i < numberTests; i++) {
                int N = Integer.valueOf(br.readLine());
                int[][] matrix = new int[N][N];
                
                for (int lines = 0; lines < N; lines++) {
                    int col = 0;
                    for (String numStr : br.readLine().split(" ")) {
                        int num = Integer.valueOf(numStr);
                        matrix[lines][col] = num;
                        col++;
                    }
                }
                processMatrix(i+1, N, matrix);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processMatrix(int testNumber, int N, int[][] m) {
        boolean[] rows = new boolean[N], cols = new boolean[N];
        List<HashSet<Integer>> colsSeen = new ArrayList<>(N);
        List<HashSet<Integer>> rowsSeen = new ArrayList<>(N);
        int trace = 0;

        for (int i = 0; i < N; i++) {
            colsSeen.add(new HashSet<>());
            rowsSeen.add(new HashSet<>());
            rows[i] = false;
            cols[i] = false;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) 
                    trace += m[i][j];

                int num = m[i][j];
                if (!rowsSeen.get(i).contains(num)) {
                    rowsSeen.get(i).add(num);
                } else {
                    rows[i] = true;
                }

                if (!colsSeen.get(j).contains(num)) {
                    colsSeen.get(j).add(num);
                } else {
                    cols[j] = true;
                }
            }
        }

        int r = 0, c = 0;
        for (int i = 0; i < N; i++) {
            if (rows[i])
                r++;
            if (cols[i])
                c++;
        }

        System.out.println("Case #" + testNumber + ": " + trace + " " + r + " " + c);
    }
}