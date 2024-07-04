import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        for (int i = 1; i <= t; i++) {
            int[] cameron = {0, 0};
            int[] jaimie = {0, 0};
            StringBuilder result = new StringBuilder();
            int n = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            boolean possible = true;
            for (int j = 0; j < n; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                scanner.nextLine();  // Consume the newline

                if (isAvailable(cameron, startTime, endTime)) {
                    cameron[0] = startTime;
                    cameron[1] = endTime;
                    result.append("C");
                } else if (isAvailable(jaimie, startTime, endTime)) {
                    jaimie[0] = startTime;
                    jaimie[1] = endTime;
                    result.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }

    private static boolean isAvailable(int[] person, int startTime, int endTime) {
        return person[0] == 0 && person[1] == 0 || person[1] <= startTime || person[0] >= endTime;
    }
}