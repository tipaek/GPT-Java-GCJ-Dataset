import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(scanner);
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

    public static void solve(Scanner scanner) {
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int missionCount = scanner.nextInt();
            Mission[] missions = new Mission[missionCount];

            for (int i = 0; i < missionCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                missions[i] = new Mission(i, start, end);
            }

            Arrays.sort(missions, Comparator.comparingInt(mission -> mission.start));

            int cEnd = 0;
            int jEnd = 0;
            boolean isImpossible = false;
            char[] schedule = new char[missionCount];

            for (Mission mission : missions) {
                if (mission.start >= cEnd) {
                    schedule[mission.id] = 'C';
                    cEnd = mission.end;
                } else if (mission.start >= jEnd) {
                    schedule[mission.id] = 'J';
                    jEnd = mission.end;
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