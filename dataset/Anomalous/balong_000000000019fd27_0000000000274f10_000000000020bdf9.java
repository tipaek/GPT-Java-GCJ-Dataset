import java.util.*;
import java.io.*;

class Solution {

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

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int missionCount = scanner.nextInt();
            Mission[] missions = new Mission[missionCount];

            for (int i = 0; i < missionCount; i++) {
                missions[i] = new Mission(i, scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(missions, Comparator.comparingInt(mission -> mission.end));

            int endTimeC = 0;
            int endTimeJ = 0;
            boolean impossible = false;
            char[] schedule = new char[missionCount];

            for (Mission mission : missions) {
                if (mission.start >= endTimeC) {
                    schedule[mission.id] = 'C';
                    endTimeC = mission.end;
                } else if (mission.start >= endTimeJ) {
                    schedule[mission.id] = 'J';
                    endTimeJ = mission.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseIndex + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseIndex + ": " + new String(schedule));
            }
        }
    }
}