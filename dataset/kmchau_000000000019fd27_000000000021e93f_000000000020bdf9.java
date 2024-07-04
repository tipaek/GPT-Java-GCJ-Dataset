import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //PrintWriter pw = new PrintWriter("output.txt");

        int maxCaseNum = in.nextInt();

        for (int caseIdx = 1; caseIdx <= maxCaseNum; caseIdx++) {
            //String[] array = line.split(" ");
//            long n = in.nextLong();
            int n = in.nextInt();
            TimeObj[] array = new TimeObj[n];

            for (int i = 0; i < n; i++) {
                array[i] = new TimeObj(i,in.nextInt(),in.nextInt()-1);
            }

            int[][] matrix = new int[2][24*60+1];
            String ansStr = "";
            for (int i = 0; i < array.length; i++) {
               TimeObj obj = array[i];
               boolean canJ = true, canC = true;
               for (int k = obj.startTime; k <= obj.endTime; k++) {
                    if (matrix[0][k] != 0) {
                        canJ = false;
                        break;
                    }
               }
                for (int k = obj.startTime; k <= obj.endTime; k++) {
                    if (matrix[1][k] != 0) {
                        canC = false;
                        break;
                    }
                }

                if (!canJ && !canC) {
                    ansStr = "IMPOSSIBLE";
                    break;
                }

                int rowIdx;
                if (canJ) {
                    ansStr+="J";
                    rowIdx = 0;
                }
                else {
                    ansStr+="C";
                    rowIdx = 1;
                }

                for (int k = obj.startTime; k <= obj.endTime; k++) {
                    matrix[rowIdx][k] = 1;
                }

            }

//            for (int i = 0; i < 2; i++) {
//                for (int j = 0; j < matrix[i].length; j++) {
//                    System.out.print(matrix[i][j] + " ");
//                }
//                System.out.println();
//            }


            String ans = "Case #" + caseIdx + ": " + ansStr;
            System.out.println(ans);

        }

        in.close();

    }

    static class TimeObj {
        private int pos;
        private int startTime;
        private int endTime;

        public TimeObj(int pos, int startTime, int endTime) {
            this.pos = pos;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "TimeObj{" +
                    "pos=" + pos +
                    ", startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }

    static long diagonal (long[][] matrix, int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }

}
