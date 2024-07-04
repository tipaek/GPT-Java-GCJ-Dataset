import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(scanner);
    }

    static class Mission {
        int start;
        int end;

        Mission(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void solve(Scanner scanner) {
        int numberOfCases = Integer.parseInt(scanner.nextLine().trim());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int missionCount = scanner.nextInt();
            Mission[] missions = new Mission[missionCount];

            for (int i = 0; i < missionCount; i++) {
                missions[i] = new Mission(scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(missions, Comparator.comparingInt(mission -> mission.end));

            int cEnd = 0;
            int jEnd = 0;
            StringBuilder arrangement = new StringBuilder();

            for (Mission mission : missions) {
                if (mission.start >= cEnd) {
                    arrangement.append("C");
                    cEnd = mission.end;
                } else if (mission.start >= jEnd) {
                    arrangement.append("J");
                    jEnd = mission.end;
                } else {
                    arrangement = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + arrangement);
        }
    }
}