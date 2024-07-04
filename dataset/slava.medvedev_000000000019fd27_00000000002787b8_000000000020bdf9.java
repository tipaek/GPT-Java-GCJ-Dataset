import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        ScanWrapper input = new ScanWrapper();
        int testsNum = input.nextInt();
        outer:
        for (int testIndex = 0; testIndex < testsNum; testIndex++) {
            int activitiesNum = input.nextInt();
            int[][] activities = new int[activitiesNum][];
            for (int i = 0; i < activitiesNum; i++) {
                activities[i] = input.nextLine();
                activities[i] = new int[] {activities[i][0], activities[i][1], i};
            }
            Arrays.sort(activities, Comparator.comparingInt(i -> i[0]));

            int cFinish = 0;
            int jFinish = 0;
            char[] result = new char[activitiesNum];
            for (int[] activity : activities) {
                int start = activity[0];
                if (cFinish > start && jFinish > start) {
                    System.out.println("Case #" + (testIndex + 1) + ": IMPOSSIBLE");
                    continue outer;
                }
                if (cFinish <= start) {
                    result[activity[2]] = 'C';
                    cFinish = activity[1];
                } else {
                    result[activity[2]] = 'J';
                    jFinish = activity[1];
                }
            }
            System.out.println("Case #" + (testIndex + 1) + ": " + new String(result));
        }
    }

    private static class ScanWrapper {
        private final Scanner scanner;

        ScanWrapper() {
            scanner = new Scanner(System.in);
        }

        int nextInt() {
            return Integer.parseInt(scanner.nextLine());
        }

        int[] nextLine() {
            String[] strings = scanner.nextLine().split(" ");
            return new int[]{
                    Integer.parseInt(strings[0]),
                    Integer.parseInt(strings[1])
            };
        }
    }

}