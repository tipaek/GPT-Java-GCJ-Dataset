import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int[] cameron = new int[2];
            int[] jaimie = new int[2];
            StringBuilder result = new StringBuilder();
            int activities = scanner.nextInt();
            scanner.nextLine();

            for (int activity = 0; activity < activities; activity++) {
                String[] times = scanner.nextLine().split(" ");
                int startTime = Integer.parseInt(times[0]);
                int endTime = Integer.parseInt(times[1]);

                if ((cameron[0] == 0 && cameron[1] == 0) || cameron[1] <= startTime || cameron[0] >= endTime) {
                    cameron[0] = startTime;
                    cameron[1] = endTime;
                    result.append("C");
                } else if ((jaimie[0] == 0 && jaimie[1] == 0) || jaimie[1] <= startTime || jaimie[0] >= endTime) {
                    jaimie[0] = startTime;
                    jaimie[1] = endTime;
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }
}