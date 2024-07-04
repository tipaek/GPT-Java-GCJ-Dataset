import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            StringBuilder schedule = new StringBuilder();
            int n = scanner.nextInt();
            int currentCStart = 0, currentCEnd = 0, currentJStart = 0, currentJEnd = 0;
            boolean possible = true;

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (start >= currentCEnd) {
                    currentCEnd = end;
                    if (currentCStart == 0) currentCStart = start;
                    schedule.append("C");
                } else if (start >= currentJEnd) {
                    currentJEnd = end;
                    if (currentJStart == 0) currentJStart = start;
                    schedule.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        }

        scanner.close();
    }
}