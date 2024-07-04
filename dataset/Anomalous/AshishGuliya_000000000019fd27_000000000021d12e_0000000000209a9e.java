import java.util.*;

class Activity {
    private final int startTime;
    private final int endTime;
    private char owner;

    Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public char getOwner() {
        return owner;
    }

    public void setOwner(char owner) {
        this.owner = owner;
    }
}

public class Solution {

    private static Scanner scanner = new Scanner(System.in);

    private static Comparator<Activity> byStart = Comparator.comparing(Activity::getStartTime);
    private static Comparator<Activity> byEnd = Comparator.comparing(Activity::getEndTime);

    public static void main(String[] args) {
        processActivities();
    }

    private static void processActivities() {
        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];

        for (int t = 1; t <= testCases; t++) {
            for (int j = 0; j < arraySize; j++) {
                System.out.println(j + 1);
                array[j] = scanner.nextInt();
            }

            for (int digit : array) {
                System.out.print(digit);
            }
            System.out.println();

            int result = 'A' + scanner.nextInt();
            if (result == 'N') {
                break;
            }
        }
    }
}