import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final String RESULT_PATTERN = "Case #{0}: {1}";
    public static final String IMPOSSIBLE = "IMPOSSIBLE";
    public static final char PERSON_1 = 'C';
    public static final char PERSON_2 = 'J';

    private static String getSolution(final Scanner scanner) {
        final int activityCount = scanner.nextInt();
        final List<Activity> activities = new ArrayList<>(activityCount);
        for (int i = 0; i < activityCount; i++) {
            final Activity e = new Activity();
            e.start = scanner.nextInt();
            e.end = scanner.nextInt();
            e.initialIndex = i;
            activities.add(e);
        }
        Collections.sort(activities);


        char[] resultOrder = new char[activityCount];
        int p1FreeTime = 0;
        int p2FreeTime = 0;
        for (final Activity activity : activities) {
            if(p1FreeTime <= activity.start) {
                p1FreeTime = activity.end;
                resultOrder[activity.initialIndex] = PERSON_1;
                continue;
            }
            if(p2FreeTime <= activity.start) {
                p2FreeTime = activity.end;
                resultOrder[activity.initialIndex] = PERSON_2;
                continue;
            }
            return IMPOSSIBLE;
        }

        StringBuilder output = new StringBuilder();
        for (final char c : resultOrder) {
            output.append(c);
        }

        return output.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(System.in);
//        final Scanner scanner = new Scanner(new FileInputStream("C.in"));

        final int testCases = scanner.nextInt();
        for(int i = 1; i<= testCases; i++) {
            final String solution = getSolution(scanner);
            System.out.println(MessageFormat.format(RESULT_PATTERN, i, solution));
        }
    }

    private static class Activity implements Comparable<Activity> {
        public int start;
        public int end;
        public int initialIndex;

        @Override
        public int compareTo(final Activity o) {
            return Integer.compare(this.start, o.start);
        }
    }
}