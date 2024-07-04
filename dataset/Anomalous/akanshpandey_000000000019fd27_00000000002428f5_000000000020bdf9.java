import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];
            char[] schedule = new char[numActivities];

            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            System.out.print("Case #" + caseNumber + ": ");
            int activeCount = 0;

            for (int i = 0; i < numActivities; i++) {
                if (activeCount == 0) {
                    schedule[i] = 'C';
                    activeCount++;
                } else if (activeCount < 3) {
                    if (activities[i][0] < activities[i - 1][1]) {
                        schedule[i] = (schedule[i - 1] == 'C') ? 'J' : 'C';
                        activeCount++;
                    } else {
                        schedule[i] = schedule[i - 1];
                        activeCount--;
                    }
                } else {
                    break;
                }
            }

            if (activeCount > 2) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(new String(schedule));
            }
        }

        scanner.close();
    }
}