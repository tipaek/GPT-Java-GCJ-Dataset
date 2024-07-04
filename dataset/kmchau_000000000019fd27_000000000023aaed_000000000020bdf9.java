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
                array[i] = new TimeObj(i,in.nextInt(),in.nextInt());
            }

            Arrays.sort(array);

//            for (int i = 0; i < array.length; i++) {
//                System.out.println(array[i]);
//            }
//            System.out.println();

            int cMax = -1;
            int jMax = -1;

            String ansStr = "";
            for (int i = 0; i < array.length; i++) {
                TimeObj timeObj = array[i];

                if (timeObj.startTime >= cMax) {
                    cMax = timeObj.endTime;
                    timeObj.person = "C";
                }
                else if (timeObj.startTime >= jMax) {
                    jMax = timeObj.endTime;
                    timeObj.person = "J";
                }
                else {
                    ansStr = "IMPOSSIBLE";
                    break;
                }
            }

            if (ansStr.isEmpty()) {
                Arrays.sort(array, (a,b) -> a.pos.compareTo(b.pos));
                for (int i = 0; i < array.length; i++) {
                    ansStr+=array[i].person;
                }
            }

//            for (int i = 0; i < array.length; i++) {
//                System.out.println(array[i]);
//            }


            String ans = "Case #" + caseIdx + ": " + ansStr;
            System.out.println(ans);

        }

        in.close();

    }

    static class TimeObj implements Comparable<TimeObj> {
        private Integer pos;
        private Integer startTime;
        private Integer endTime;
        private String person;

        public TimeObj(Integer pos, Integer startTime, Integer endTime) {
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
                    ", person='" + person + '\'' +
                    '}';
        }

        @Override
        public int compareTo(TimeObj o) {
            if (this.startTime == o.startTime) {
                return this.endTime.compareTo(o.endTime);
            }

            return this.startTime.compareTo(o.startTime);
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
