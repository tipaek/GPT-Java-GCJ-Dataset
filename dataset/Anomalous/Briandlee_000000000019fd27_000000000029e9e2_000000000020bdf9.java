import java.util.*;

public class Solution {

    public static void main(String[] args) {
        calculations();
    }

    public static void calculations() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[] startingTimes = new int[N];
            int[] endingTimes = new int[N];
            for (int j = 0; j < N; j++) {
                startingTimes[j] = scanner.nextInt();
                endingTimes[j] = scanner.nextInt();
            }

            List<Integer> cameronList = new ArrayList<>(Collections.nCopies(1440, 0));
            List<Integer> jamieList = new ArrayList<>(Collections.nCopies(1440, 0));
            StringBuilder parentsList = new StringBuilder();

            boolean impossible = false;

            for (int j = 0; j < N; j++) {
                if (isAvailable(cameronList, startingTimes[j], endingTimes[j])) {
                    fillTimeSlots(cameronList, startingTimes[j], endingTimes[j]);
                    parentsList.append("C");
                } else if (isAvailable(jamieList, startingTimes[j], endingTimes[j])) {
                    fillTimeSlots(jamieList, startingTimes[j], endingTimes[j]);
                    parentsList.append("J");
                } else {
                    impossible = true;
                    break;
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(parentsList.toString());
            }
        }
    }

    private static boolean isAvailable(List<Integer> schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule.get(i) == 1) {
                return false;
            }
        }
        return true;
    }

    private static void fillTimeSlots(List<Integer> schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule.set(i, 1);
        }
    }
}