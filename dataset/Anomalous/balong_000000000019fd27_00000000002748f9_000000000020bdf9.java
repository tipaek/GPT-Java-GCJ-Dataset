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
            int numMissions = scanner.nextInt();
            Mission[] missions = new Mission[numMissions];

            for (int i = 0; i < numMissions; i++) {
                missions[i] = new Mission(i, scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(missions, Comparator.comparingInt(mission -> mission.end));

            int cEnd = 0;
            int jEnd = 0;
            char[] schedule = new char[numMissions];
            boolean impossible = false;

            for (Mission mission : missions) {
                if (mission.start >= cEnd) {
                    schedule[mission.id] = 'C';
                    cEnd = mission.end;
                } else if (mission.start >= jEnd) {
                    schedule[mission.id] = 'J';
                    jEnd = mission.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            String result = impossible ? "IMPOSSIBLE" : new String(schedule);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}