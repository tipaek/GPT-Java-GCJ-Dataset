
import java.util.*;
import java.io.*;

public class Solution {

    private static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final int START = 0;
    private static final int END = 1;
    private static final int INDEX = 2;
    private static final int PERSON = 3;
    private static final int PROPERTIES = 4;


    public static void main(String[] args) {
        int tests = scanner.nextInt();
        for (int i = 0; i < tests; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve(scanner.nextInt());
        }
    }

    private static void solve(int numOfMeetings) {
        int[][] meetings = new int[numOfMeetings][PROPERTIES];
        for (int i = 0; i < numOfMeetings; i++) fill(i ,meetings[i], scanner.nextInt(), scanner.nextInt());
        StringBuffer output = new StringBuffer();
        ArrayList<int[]> scheduleJamie = new ArrayList<>();
        ArrayList<int[]> scheduleCameron = new ArrayList<>();
        Arrays.sort(meetings, Comparator.comparingDouble(o -> o[START]));
        for (int[] meeting : meetings) {
            if(checkSchedule(meeting, scheduleJamie)) meeting[PERSON] = 100;
            else if (checkSchedule(meeting, scheduleCameron)) meeting[PERSON] = 1000;
            else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
        Arrays.sort(meetings, Comparator.comparingDouble(o -> o[INDEX]));
        for (int[] meeting : meetings) {
            if(meeting[PERSON] == 100) output.append('J');
            else output.append('C');
        }
        System.out.println(output.toString());
    }

    private static void fill(int index, int[] meeting, int start, int end) {
        meeting[START] = start;
        meeting[END] = end;
        meeting[INDEX] = index;
    }

    private static boolean checkSchedule(int[] meeting, ArrayList<int[]> schedule) {
        for (int[] task : schedule) {
            if (   ((meeting[START] <= task[START]) &&
                    (meeting[END] >= task[END])) ||
                    ((meeting[START] >= task[START]) && (meeting[START] < task[END])) ||
                    ((meeting[END] > task[START]) && (meeting[END] <= task[END]))    )
                return false;
        }
        schedule.add(meeting);
        return true;
    }
}