import java.util.*;

class Solution {

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
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfMissions = scanner.nextInt();
            Mission[] missions = new Mission[numberOfMissions];

            for (int i = 0; i < numberOfMissions; i++) {
                missions[i] = new Mission(scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(missions, Comparator.comparingInt(mission -> mission.end));

            int lastEndC = 0;
            int lastEndJ = 0;
            StringBuilder arrangement = new StringBuilder();

            for (Mission mission : missions) {
                if (mission.start >= lastEndC) {
                    arrangement.append("C");
                    lastEndC = mission.end;
                } else if (mission.start >= lastEndJ) {
                    arrangement.append("J");
                    lastEndJ = mission.end;
                } else {
                    arrangement = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + arrangement);
        }
    }
}