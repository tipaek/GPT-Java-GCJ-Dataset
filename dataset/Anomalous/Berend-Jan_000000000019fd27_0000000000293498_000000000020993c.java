import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = in.nextInt();
            boolean[][] rowCheck = new boolean[N][N];
            boolean[][] colCheck = new boolean[N][N];
            boolean[] rowDuplicate = new boolean[N];
            boolean[] colDuplicate = new boolean[N];
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int num = in.nextInt();
                    if (i == j) {
                        trace += num;
                    }
                    if (rowCheck[i][num - 1]) {
                        if (!rowDuplicate[i]) {
                            rowDuplicate[i] = true;
                            rowRepeats++;
                        }
                    } else {
                        rowCheck[i][num - 1] = true;
                    }
                    if (colCheck[j][num - 1]) {
                        if (!colDuplicate[j]) {
                            colDuplicate[j] = true;
                            colRepeats++;
                        }
                    } else {
                        colCheck[j][num - 1] = true;
                    }
                }
            }
            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        in.close();
    }
}