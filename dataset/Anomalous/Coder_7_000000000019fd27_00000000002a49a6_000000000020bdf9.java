import java.util.*;

class Solution {
    static class Pair {
        int start;
        int end;
        int index;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activitiesCount = Integer.parseInt(scanner.nextLine());
            Pair[] activities = new Pair[activitiesCount];

            for (int i = 0; i < activitiesCount; i++) {
                String[] input = scanner.nextLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                activities[i] = new Pair();
                activities[i].start = start;
                activities[i].end = end;
                activities[i].index = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            int cEnd = 0, jEnd = 0;
            String[] schedule = new String[activitiesCount];
            boolean isPossible = true;

            for (Pair activity : activities) {
                if (cEnd <= activity.start) {
                    cEnd = activity.end;
                    schedule[activity.index] = "C";
                } else if (jEnd <= activity.start) {
                    jEnd = activity.end;
                    schedule[activity.index] = "J";
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.print("Case #" + caseNum + ": ");
                for (String s : schedule) {
                    System.out.print(s);
                }
                System.out.println();
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}