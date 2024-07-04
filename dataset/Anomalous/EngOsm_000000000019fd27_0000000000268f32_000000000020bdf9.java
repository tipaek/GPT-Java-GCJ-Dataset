import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int M = 0; M < T; M++) {
            boolean isPossible = true;
            int N = input.nextInt();
            char[] schedule = new char[N];
            boolean[] cameronSchedule = new boolean[1441];
            boolean[] jamieSchedule = new boolean[1441];

            for (int j = 0; j < N; j++) {
                int start = input.nextInt();
                int end = input.nextInt();

                boolean cameronBusy = false;
                boolean jamieBusy = false;

                for (int k = start + 1; k < end; k++) {
                    if (cameronSchedule[k]) {
                        cameronBusy = true;
                    }
                    if (jamieSchedule[k]) {
                        jamieBusy = true;
                    }
                    if (cameronBusy && jamieBusy) {
                        isPossible = false;
                        break;
                    }
                }

                if (!isPossible) {
                    break;
                }

                if (!cameronBusy) {
                    for (int k = start; k <= end; k++) {
                        cameronSchedule[k] = true;
                    }
                    schedule[j] = 'C';
                } else if (!jamieBusy) {
                    for (int k = start; k <= end; k++) {
                        jamieSchedule[k] = true;
                    }
                    schedule[j] = 'J';
                }
            }

            System.out.print("Case #" + (M + 1) + ": ");
            if (!isPossible) {
                System.out.print("IMPOSSIBLE");
            } else {
                System.out.print(new String(schedule));
            }
            System.out.println();
        }
    }
}