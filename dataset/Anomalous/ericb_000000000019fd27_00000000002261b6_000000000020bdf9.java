import java.util.*;

public class Solution {
    static int testCases = 0;
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        testCases = scanner.nextInt();
        scanner.nextLine();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            output.append(runTestCase(i + 1));
        }

        System.out.println(output.toString());
    }

    public static String runTestCase(int caseNumber) {
        int size = scanner.nextInt();
        scanner.nextLine();
        Activity[] activities = new Activity[size];

        for (int i = 0; i < size; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            activities[i] = new Activity(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), i);
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a.leftBound));

        boolean impossible = false;
        String nextAssign = "C";
        for (int i = 0; i < activities.length; i++) {
            if (activities[i].assignedTo.isEmpty()) {
                activities[i].assignedTo = "C";
                nextAssign = "J";
            } else {
                nextAssign = activities[i].assignedTo.equals("C") ? "J" : "C";
            }

            for (int j = i + 1; j < activities.length && activities[j].leftBound < activities[i].rightBound; j++) {
                if (!activities[j].assignedTo.isEmpty() && activities[j].assignedTo.equals(activities[i].assignedTo)) {
                    impossible = true;
                }
                activities[j].assignedTo = nextAssign;
            }

            nextAssign = nextAssign.equals("C") ? "J" : "C";
        }

        if (impossible) {
            return "Case #" + caseNumber + ": IMPOSSIBLE\n";
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a.order));

        StringBuilder result = new StringBuilder("Case #" + caseNumber + ": ");
        for (Activity activity : activities) {
            result.append(activity.assignedTo);
        }
        result.append("\n");

        return result.toString();
    }
}

class Activity {
    String assignedTo;
    int leftBound, rightBound, order;

    public Activity(int leftBound, int rightBound, int order) {
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.order = order;
        this.assignedTo = "";
    }

    @Override
    public String toString() {
        return "Activity assigned to: " + assignedTo + ", " + leftBound + " -- " + rightBound;
    }
}