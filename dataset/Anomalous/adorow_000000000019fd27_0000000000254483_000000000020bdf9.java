import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner;
    private static PrintStream output;

    private static final String CASE_PREFIX = "Case #";
    private static final String SEPARATOR = ": ";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        // Uncomment the following line to read from a file
        // scanner = new Scanner(new FileInputStream("./src/main/resources/codejam/year2020/qualification/C/C.in"));
        output = System.out;
        // Uncomment the following line to write to a file
        // output = new PrintStream(new FileOutputStream("A_RobotProgrammingStrategy.out"));

        int testCaseCount = scanner.nextInt();
        Period[] periods = new Period[1001];

        for (int t = 1; t <= testCaseCount; t++) {
            int activityCount = scanner.nextInt();
            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                periods[i] = new Period(i, start, end);
            }

            output.print(CASE_PREFIX);
            output.print(t);
            output.print(SEPARATOR);
            output.println(assignActivities(periods, activityCount));
        }
        output.flush();
    }

    private static final char CAMERON = 'C';
    private static final char JAMIE = 'J';

    private static final Comparator<Period> BY_START = Comparator.comparingInt(p -> p.start);
    private static final Comparator<Period> BY_INDEX = Comparator.comparingInt(p -> p.index);

    private static String assignActivities(Period[] periods, int activityCount) {
        int cameronEnd = 0;
        int jamieEnd = 0;

        Arrays.sort(periods, 0, activityCount, BY_START);
        for (int i = 0; i < activityCount; i++) {
            Period period = periods[i];
            if (cameronEnd <= period.start) {
                period.assigned = CAMERON;
                cameronEnd = period.end;
            } else if (jamieEnd <= period.start) {
                period.assigned = JAMIE;
                jamieEnd = period.end;
            } else {
                return IMPOSSIBLE;
            }
        }

        Arrays.sort(periods, 0, activityCount, BY_INDEX);

        StringBuilder result = new StringBuilder(activityCount);
        for (int i = 0; i < activityCount; i++) {
            result.append(periods[i].assigned);
        }
        return result.toString();
    }

    static class Period {
        int index;
        int start;
        int end;
        char assigned;

        Period(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }
}