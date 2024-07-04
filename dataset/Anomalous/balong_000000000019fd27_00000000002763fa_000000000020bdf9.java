import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        processCases(scanner);
    }

    static class Mission {
        int id;
        int start;
        int end;

        Mission(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }

    public static void processCases(Scanner scanner) {
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfMissions = scanner.nextInt();
            Mission[] missions = new Mission[numberOfMissions];

            for (int i = 0; i < numberOfMissions; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                missions[i] = new Mission(i, start, end);
            }

            Arrays.sort(missions, Comparator.comparingInt(mission -> mission.end));

            int cEndTime = 0;
            int jEndTime = 0;
            boolean isImpossible = false;
            char[] schedule = new char[numberOfMissions];

            for (Mission mission : missions) {
                if (mission.start >= cEndTime) {
                    schedule[mission.id] = 'C';
                    cEndTime = mission.end;
                } else if (mission.start >= jEndTime) {
                    schedule[mission.id] = 'J';
                    jEndTime = mission.end;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + new String(schedule));
            }
        }
    }
}