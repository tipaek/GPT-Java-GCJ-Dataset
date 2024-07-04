import java.io.*;
import java.util.*;

public class Solution {
    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;

    public void doCase(int caseNumber) throws Exception {
        String line = in.readLine();
        Scanner scan = new Scanner(line);
        int N = scan.nextInt();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            line = in.readLine();
            scan = new Scanner(line);
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        int rowCount = 0;
        int colCount = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowCount++;
                    break;
                }
            }
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (!colSet.add(matrix[j][i])) {
                    colCount++;
                    break;
                }
            }
        }
        System.out.println(trace + " " + rowCount + " " + colCount);
    }

    public void run() throws Exception {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            out.print("Case #" + i + ": ");
            doCase(i);
        }
    }

    public static void main(String[] args) throws Exception {
        new Vestigium().run();
    }

}
