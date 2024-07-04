import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            boolean possible = true;
            StringBuilder schedule = new StringBuilder();
            int[] cameronSchedule = new int[1441];
            int[] jamieSchedule = new int[1441];
            Arrays.fill(cameronSchedule, 0);
            Arrays.fill(jamieSchedule, 0);

            for (int k = 0; k < n; k++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean cameronAvailable = true;
                boolean jamieAvailable = true;

                for (int time = start + 1; time <= end; time++) {
                    if (cameronSchedule[time] == 1) {
                        cameronAvailable = false;
                        break;
                    }
                }

                if (cameronAvailable) {
                    Arrays.fill(cameronSchedule, start, end + 1, 1);
                    schedule.append("C");
                } else {
                    for (int time = start + 1; time <= end; time++) {
                        if (jamieSchedule[time] == 1) {
                            jamieAvailable = false;
                            break;
                        }
                    }
                    if (jamieAvailable) {
                        Arrays.fill(jamieSchedule, start, end + 1, 1);
                        schedule.append("J");
                    } else {
                        possible = false;
                        break;
                    }
                }
            }

            if (possible) {
                System.out.println("Case #" + i + ": " + schedule.toString());
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}