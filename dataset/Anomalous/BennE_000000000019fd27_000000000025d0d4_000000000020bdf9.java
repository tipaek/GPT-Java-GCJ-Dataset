import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final String RESULT_PATTERN = "Case #{0}: {1}";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final char PERSON_1 = 'C';
    private static final char PERSON_2 = 'J';

    private static String getSolution(Scanner scanner) {
        int activityCount = scanner.nextInt();
        List<Activity> activities = new ArrayList<>(activityCount);

        for (int i = 0; i < activityCount; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(start, end, i));
        }

        Collections.sort(activities);

        char[] resultOrder = new char[activityCount];
        int p1FreeTime = 0;
        int p2FreeTime = 0;

        for (Activity activity : activities) {
            if (p1FreeTime <= activity.start) {
                p1FreeTime = activity.end;
                resultOrder[activity.initialIndex] = PERSON_1;
            } else if (p2FreeTime <= activity.start) {
                p2FreeTime = activity.end;
                resultOrder[activity.initialIndex] = PERSON_2;
            } else {
                return IMPOSSIBLE;
            }
        }

        return new String(resultOrder);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        // Scanner scanner = new Scanner(new FileInputStream("C.in"));

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String solution = getSolution(scanner);
            System.out.println(MessageFormat.format(RESULT_PATTERN, i, solution));
        }
    }

    private static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int initialIndex;

        Activity(int start, int end, int initialIndex) {
            this.start = start;
            this.end = end;
            this.initialIndex = initialIndex;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }
}