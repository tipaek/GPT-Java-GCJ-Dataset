import java.util.Scanner;

public class Qualification3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            StringBuilder schedule = new StringBuilder("C");

            for (int i = 0; i < n - 1; i++) {
                if (startTimes[i] > startTimes[i + 1] || endTimes[i] < endTimes[i + 1]) {
                    char lastChar = schedule.charAt(schedule.length() - 1);
                    schedule.append(lastChar == 'C' ? 'J' : 'C');
                }
            }

            if (schedule.length() != n) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + t + ": " + schedule);
        }
    }
}