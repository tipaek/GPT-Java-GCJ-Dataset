import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static final int[] personOccupiedTime = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();

        for (int testCase = 1; testCase <= numTestCases; testCase++) {
            Arrays.fill(personOccupiedTime, -1);
            int numJobs = sc.nextInt();
            int[] startTimes = new int[numJobs];
            int[] endTimes = new int[numJobs];

            for (int i = 0; i < numJobs; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
            }

            List<Integer> jobOrder = new ArrayList<>();
            for (int i = 0; i < numJobs; i++) {
                jobOrder.add(i);
            }

            jobOrder.sort(Comparator.comparingInt(i -> startTimes[i]));

            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int job : jobOrder) {
                int startTime = startTimes[job];
                int endTime = endTimes[job];
                String person = getAvailablePerson(startTime, endTime);
                if (person == null) {
                    isPossible = false;
                    break;
                } else {
                    result.append(person);
                }
            }

            if (!isPossible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", testCase);
            } else {
                System.out.printf("Case #%d: %s%n", testCase, result.toString());
            }
        }

        sc.close();
    }

    private static String getAvailablePerson(int startTime, int endTime) {
        for (int i = 0; i < 2; i++) {
            if (personOccupiedTime[i] <= startTime) {
                personOccupiedTime[i] = -1;
            }
        }

        if (personOccupiedTime[0] == -1) {
            personOccupiedTime[0] = endTime;
            return "C";
        } else if (personOccupiedTime[1] == -1) {
            personOccupiedTime[1] = endTime;
            return "J";
        }

        return null;
    }
}