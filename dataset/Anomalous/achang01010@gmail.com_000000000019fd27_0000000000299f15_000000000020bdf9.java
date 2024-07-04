import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt(); 

        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            boolean impossible = false;
            StringBuilder result = new StringBuilder();
            boolean[] scheduleC = new boolean[1440];
            boolean[] scheduleJ = new boolean[1440];

            int numEvents = sc.nextInt();
            for (int eventIndex = 0; eventIndex < numEvents; eventIndex++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();
                boolean canAssignC = true;
                boolean canAssignJ = true;

                for (int time = startTime; time < endTime; time++) {
                    if (scheduleC[time]) {
                        canAssignC = false;
                        break;
                    }
                }

                if (canAssignC) {
                    result.append("C");
                    for (int time = startTime; time < endTime; time++) {
                        scheduleC[time] = true;
                    }
                } else {
                    for (int time = startTime; time < endTime; time++) {
                        if (scheduleJ[time]) {
                            canAssignJ = false;
                            break;
                        }
                    }

                    if (canAssignJ) {
                        result.append("J");
                        for (int time = startTime; time < endTime; time++) {
                            scheduleJ[time] = true;
                        }
                    } else {
                        impossible = true;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseIndex + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseIndex + ": " + result.toString());
            }
        }

        sc.close();
    }
}