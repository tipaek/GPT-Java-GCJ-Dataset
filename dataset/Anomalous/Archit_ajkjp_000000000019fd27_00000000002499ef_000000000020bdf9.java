import java.util.Scanner;

public class CodeJam2020_ParentingPartneringReturns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activities = sc.nextInt();
            int[][] schedule = new int[activities][2];
            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (int j = 0; j < activities; j++) {
                schedule[j][0] = sc.nextInt();
                schedule[j][1] = sc.nextInt();
            }

            int cEnd = 0, jEnd = 0;

            for (int j = 0; j < activities; j++) {
                int start = schedule[j][0];
                int end = schedule[j][1];

                if (start >= cEnd) {
                    result.append('C');
                    cEnd = end;
                } else if (start >= jEnd) {
                    result.append('J');
                    jEnd = end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + result.toString());
            }
        }
    }
}