import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();
        final int MAX_TIME = 24 * 60 + 2;

        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            int[] timeSlots = new int[MAX_TIME];
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                timeSlots[start]++;
                timeSlots[end]--;
            }

            boolean isImpossible = false;
            for (int i = 1; i < MAX_TIME; i++) {
                timeSlots[i] += timeSlots[i - 1];
                if (timeSlots[i] > 2) {
                    isImpossible = true;
                    break;
                }
            }

            result.append("Case #").append(caseNumber).append(": ");
            if (isImpossible) {
                result.append("IMPOSSIBLE");
            } else {
                StringBuilder schedule = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    schedule.append(i % 2 == 0 ? 'J' : 'C');
                }
                result.append(schedule);
            }
            result.append("\n");
        }
        System.out.print(result.toString());
    }
}