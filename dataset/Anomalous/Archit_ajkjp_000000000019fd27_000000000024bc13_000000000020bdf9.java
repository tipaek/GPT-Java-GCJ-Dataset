import java.util.Scanner;

class CodeJam2020_ParentingPartneringReturns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activities = sc.nextInt();
            int[][] schedule = new int[activities][2];
            char[] result = new char[activities];

            for (int j = 0; j < activities; j++) {
                schedule[j][0] = sc.nextInt();
                schedule[j][1] = sc.nextInt();
            }

            int cameronEnd = 0;
            int jamieEnd = 0;
            boolean impossible = false;

            for (int j = 0; j < activities; j++) {
                int start = schedule[j][0];
                int end = schedule[j][1];

                if (start >= cameronEnd) {
                    result[j] = 'C';
                    cameronEnd = end;
                } else if (start >= jamieEnd) {
                    result[j] = 'J';
                    jamieEnd = end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + new String(result));
            }
        }
    }
}