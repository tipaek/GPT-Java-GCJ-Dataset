import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        int N = in.nextInt();

        int testCase[][] = new int[N][N];
        for (int i = 0; i < T; ++i) {

            for (int y = 0; y < (N-1); y++){
                int count = 0;
                while(in.hasNext() && count != 4)
                {
                    if(in.hasNextInt()){
                        System.out.println(in.nextInt());
                        testCase[y][count] = in.nextInt();
                        count++;
                    }else{
                        in.next();
                    }

                }
            }

            doVestigium(testCase, i+1);
        }
    }

    private static void doVestigium(int[][] testCase, int number) {
        int[] output = {0, 0, 0};
        for (int i = 0; i < testCase[0].length; i++) {
            int row[] = new int[testCase.length];
            int column[] = new int[testCase.length];

            for (int j = 0; j < testCase.length; j++) {
                row[j] = testCase[i][j];
                column[j] = testCase[j][i];
            }

            for (int j = 0; j < 1; j++) {
                output[0] += testCase[i][i];
            }

            for (int y = 0; y < row.length; y++) {
                boolean same = false;
                for (int z = y + 1; z < row.length; z++) {
                    if (row[y] == row[z]) {
                        same = true;
                    }
                }

                if (same) {
                    output[1]++;
                    break;
                }
            }

            for (int y = 0; y < column.length; y++) {
                boolean same = false;
                for (int z = y + 1; z < column.length; z++) {
                    if (column[y] == column[z]) {
                        if (column[y] == column[z]) {
                            same = true;
                        }
                    }
                }
                if (same) {
                    output[2]++;
                    break;
                }
            }
        }

        System.out.println("Case #" + number + " " + output[0] + " " + output[1] + " " + output[2] + " ");
    }
}