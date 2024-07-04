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

        for (int caseNum = 1; caseNum <= numberOfCases; caseNum++) {
            int numMissions = scanner.nextInt();
            Mission[] missions = new Mission[numMissions];

            for (int i = 0; i < numMissions; i++) {
                missions[i] = new Mission(scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(missions, Comparator.comparingInt(mission -> mission.end));

            int endC = 0;
            int endJ = 0;
            StringBuilder schedule = new StringBuilder();

            for (Mission mission : missions) {
                if (mission.start >= endC) {
                    schedule.append("C");
                    endC = mission.end;
                } else if (mission.start >= endJ) {
                    schedule.append("J");
                    endJ = mission.end;
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNum + ": " + schedule.toString());
        }
    }
}