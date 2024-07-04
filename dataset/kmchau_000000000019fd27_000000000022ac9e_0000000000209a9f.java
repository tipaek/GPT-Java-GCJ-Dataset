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
            String str = in.next();
            String[] array = str.split("");

            int firstDigit = Integer.valueOf(array[0]);
            int lastDigit = Integer.valueOf(array[array.length-1]);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < firstDigit; i++) {
                sb.append("(");
            }

            for (int i = 0; i < array.length - 1; i++) {
                int d1 = Integer.valueOf(array[i]);
                int d2 = Integer.valueOf(array[i+1]);

                sb.append(d1);

                if (d1 > d2) {
                    int diff = d1 - d2;
                    for (int j = 0; j < diff; j++) {
                        sb.append(")");
                    }
                }
                else if (d2 > d1) {
                    int diff = d2 - d1;
                    for (int j = 0; j < diff; j++) {
                        sb.append("(");
                    }
                }
            }

            sb.append(lastDigit);
            for (int i = 0; i < lastDigit; i++) {
                sb.append(")");
            }

//            System.out.println(sb.toString());


            String ans = "Case #" + caseIdx + ": " + sb.toString();
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
