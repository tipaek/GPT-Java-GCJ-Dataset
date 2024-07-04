import java.util.Scanner;
import java.io.*;

public class Solution {
    private static int[] start;
    private static int[] end;
    private static int[] cEnd;
    private static int[] jEnd;
    private static int[] cStart;
    private static int[] jStart;
    private static Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int T = Integer.parseInt(input.nextLine());
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= T; ++i) {
            int N = Integer.parseInt(input.nextLine());
            initializeArrays(N);
            for (int j = 0; j < N; j++) {
                addTime(input.nextLine(), j);
            }
            output.append(solve(i, N)).append("\n");
        }
        System.out.print(output);
    }

    private static void initializeArrays(int size) {
        start = new int[size];
        end = new int[size];
        cEnd = new int[size];
        jEnd = new int[size];
        cStart = new int[size];
        jStart = new int[size];
        for (int i = 0; i < size; i++) {
            cEnd[i] = -1;
            jEnd[i] = -1;
            cStart[i] = -1;
            jStart[i] = -1;
        }
    }

    private static void addTime(String time, int index) {
        String[] times = time.split(" ");
        start[index] = Integer.parseInt(times[0]);
        end[index] = Integer.parseInt(times[1]);
    }

    private static char assignActivity(int index) {
        if (isConflict(cEnd, cStart, index)) {
            if (isConflict(jEnd, jStart, index)) {
                return 'e';
            }
            addToSchedule(jEnd, end[index]);
            return 'J';
        }
        addToSchedule(cEnd, end[index]);
        return 'C';
    }

    private static boolean isConflict(int[] endTimes, int[] startTimes, int index) {
        for (int i = 0; endTimes[i] != -1; i++) {
            if ((endTimes[i] > start[index] && end[index] > startTimes[i]) || 
                (endTimes[i] < start[index] && end[index] < startTimes[i])) {
                return true;
            }
        }
        return false;
    }

    private static void addToSchedule(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                array[i] = value;
                break;
            }
        }
    }

    private static String solve(int caseNumber, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (start[i] >= 1440 || end[i] >= 1440) {
                return "Case #" + caseNumber + ": IMPOSSIBLE";
            }
        }
        cEnd[0] = end[0];
        cStart[0] = start[0];
        result.append('C');
        for (int j = 1; j < count; j++) {
            char activity = assignActivity(j);
            if (activity == 'e') {
                return "Case #" + caseNumber + ": IMPOSSIBLE";
            }
            result.append(activity);
        }
        return "Case #" + caseNumber + ": " + result.toString();
    }
}