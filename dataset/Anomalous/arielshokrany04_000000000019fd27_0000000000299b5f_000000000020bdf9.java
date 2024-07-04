import java.util.Scanner;
import java.io.*;

class Solution {
    private static int[] start;
    private static int[] end;
    private static int[] cEnd;
    private static int[] jEnd;
    private static int[] cStart;
    private static int[] jStart;
    private static final Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

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

    private static void initializeArrays(int N) {
        start = new int[N];
        end = new int[N];
        cEnd = new int[N];
        jEnd = new int[N];
        cStart = new int[N];
        jStart = new int[N];
        for (int j = 0; j < N; j++) {
            cEnd[j] = -1;
            jEnd[j] = -1;
            cStart[j] = -1;
            jStart[j] = -1;
        }
    }

    private static void addTime(String time, int index) {
        String[] times = time.split(" ");
        start[index] = Integer.parseInt(times[0]);
        end[index] = Integer.parseInt(times[1]);
    }

    private static char assignTask(int index) {
        if (canAssignToCameron(index)) {
            add(cEnd, end[index]);
            return 'C';
        } else if (canAssignToJamie(index)) {
            add(jEnd, end[index]);
            return 'J';
        } else {
            return 'e';
        }
    }

    private static boolean canAssignToCameron(int index) {
        for (int i = 0; cEnd[i] != -1; i++) {
            if (isOverlapping(cStart[i], cEnd[i], start[index], end[index])) {
                return false;
            }
        }
        return true;
    }

    private static boolean canAssignToJamie(int index) {
        for (int i = 0; jEnd[i] != -1; i++) {
            if (isOverlapping(jStart[i], jEnd[i], start[index], end[index])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && start2 < end1);
    }

    private static String solve(int caseNumber, int count) {
        StringBuilder result = new StringBuilder();
        cEnd[0] = end[0];
        cStart[0] = start[0];
        result.append('C');
        for (int j = 1; j < count; j++) {
            char assigned = assignTask(j);
            if (assigned == 'e') {
                return "Case #" + caseNumber + ": IMPOSSIBLE";
            }
            result.append(assigned);
        }
        return "Case #" + caseNumber + ": " + result.toString();
    }

    private static void add(int[] array, int value) {
        for (int i = 0; ; i++) {
            if (array[i] == -1) {
                array[i] = value;
                break;
            }
        }
    }
}