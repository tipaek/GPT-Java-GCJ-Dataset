import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Solution {
    class Time implements Comparable{
        int start;
        int end;
        int index;
        char assigned;
        public Time(int start, int end, int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Object o) {
            Time other = (Time) o;
            return other.start != this.start ?
                    this.start - other.start:
                    this.end - other.end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int readTestCases() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static int assignTasks(ArrayList<Time> schedule){
        Time cameronCurrent = new Solution().new Time(-1, -1, -1);
        Time jammieCurrent =  new Solution().new Time(-1, -1, -1);


        for (Time task: schedule){
            int start = task.start;
            int end = task.end;

            if(cameronCurrent.end <= start){
                task.assigned = 'C';
                cameronCurrent = task;
            }
            else if(jammieCurrent.end <= start){
                task.assigned = 'J';
                jammieCurrent = task;
            }
            else{
                return -1;
            }

        }
        return 1;
    }

    public static int[][] readMatrix() throws IOException {
        int size = Integer.parseInt(reader.readLine());
        int[][] mat = new int[size][size];
        for (int i = 0; i < size; i++){
            String rowString = reader.readLine();
            String[] row = rowString.split(" ");
            mat[i] = new int[]{Integer.parseInt(row[0]), Integer.parseInt(row[1])};
        }
        return mat;
    }

    public static void solveTest(int[][] time, int testCaseNo, StringBuilder ansSb){

        ArrayList<Time> schedule = new ArrayList<>();

        for (int i = 0; i < time.length; i++){
            int[] interval = time[i];
            schedule.add(new Solution().new Time(interval[0], interval[1], i));
        }
        Collections.sort(schedule);

        int l = assignTasks(schedule);
        if (l == -1){
            ansSb.append("Case #"+ testCaseNo + ": IMPOSSIBLE" + "\n");
            return;
        }

        char[] ans = new char[schedule.size()];

        for (Time job: schedule){
            ans[job.index] = job.assigned;
        }
        StringBuilder sb = new StringBuilder();
        for (char a: ans){
            sb.append(a);
        }
        ansSb.append("Case #"+ testCaseNo + ": " + sb.toString() + "\n");
    }



    public static void main(String[] args) throws IOException {
        int numberOfTestCases = readTestCases();
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= numberOfTestCases; i++){
            solveTest(readMatrix(), i, ans);
        }
        System.out.println(ans.toString());
    }
}
