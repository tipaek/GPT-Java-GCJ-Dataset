import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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

    private static char assignActivity(int j) {
        if (canAssignToC(j)) {
            assignToC(j);
            return 'C';
        } else if (canAssignToJ(j)) {
            assignToJ(j);
            return 'J';
        } else {
            return 'e';
        }
    }

    private static boolean canAssignToC(int j) {
        for (int i = 0; i < cEnd.length && cEnd[i] != -1; i++) {
            if (overlaps(cStart[i], cEnd[i], start[j], end[j])) {
                return false;
            }
        }
        return true;
    }

    private static boolean canAssignToJ(int j) {
        for (int i = 0; i < jEnd.length && jEnd[i] != -1; i++) {
            if (overlaps(jStart[i], jEnd[i], start[j], end[j])) {
                return false;
            }
        }
        return true;
    }

    private static boolean overlaps(int start1, int end1, int start2, int end2) {
        return !(end1 <= start2 || end2 <= start1);
    }

    private static void assignToC(int j) {
        add(cEnd, end[j]);
        add(cStart, start[j]);
    }

    private static void assignToJ(int j) {
        add(jEnd, end[j]);
        add(jStart, start[j]);
    }

    private static String solve(int caseNum, int count) {
        StringBuilder result = new StringBuilder();
        result.append('C');
        cEnd[0] = end[0];
        cStart[0] = start[0];

        for (int j = 1; j < count; j++) {
            char assignment = assignActivity(j);
            if (assignment == 'e') {
                return "Case #" + caseNum + ": IMPOSSIBLE";
            }
            result.append(assignment);
        }
        return "Case #" + caseNum + ": " + result;
    }

    private static void add(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                array[i] = value;
                break;
            }
        }
    }
}