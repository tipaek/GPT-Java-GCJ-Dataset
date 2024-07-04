import java.util.*;
import java.io.*;
public class Solution  {

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) {
        int caseNum = in.nextInt();
        for(int i = 0; i < caseNum;i++) {
            calculate(i+1);
        }
    }

    private static void calculate(int caseNum) {
        int lineCount = in.nextInt();
        int[][] dpCols = new int[lineCount][lineCount];
        int[][] dpRows = new int[lineCount][lineCount];

        int[] rows = new int[lineCount];
        int[] cols = new int[lineCount];
        int resRows = 0;
        int resCols = 0;
        int trace = 0;

        for(int i = 0;i < lineCount;i++) {
            String line = in.nextLine();
            for(int j = 0; j < lineCount;j++) {

                int num = in.nextInt();
                if(i == j) trace += num;

                if(dpRows[i][num-1] == 0) {
                    dpRows[i][num-1] = 1;
                } else {
                    if(rows[i] == 0) {
                        rows[i] = 1;
                        resRows++;
                    }
                }

                if(dpCols[j][num-1] == 0) {
                    dpCols[j][num-1] = 1;
                } else {
                    if(cols[j] == 0) {
                        cols[j] = 1;
                        resCols++;
                    }
                }
            }
        }

        System.out.println("Case #" + caseNum + ": " + trace + " " + resRows + " " + resCols);
    }
}
