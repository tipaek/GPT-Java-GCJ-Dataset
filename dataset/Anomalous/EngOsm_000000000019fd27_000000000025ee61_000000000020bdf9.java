import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int t = 0; t < T; t++) {
            int N = input.nextInt();
            char[] schedule = new char[N];
            int[] cameronSchedule = new int[1441];
            int[] jamieSchedule = new int[1441];
            boolean impossible = false;

            for (int n = 0; n < N; n++) {
                int start = input.nextInt();
                int end = input.nextInt();
                boolean cameronBusy = false;
                boolean jamieBusy = false;

                for (int time = start; time < end; time++) {
                    if (cameronSchedule[time] == 1) {
                        cameronBusy = true;
                    }
                    if (jamieSchedule[time] == 1) {
                        jamieBusy = true;
                    }
                }

                if (cameronBusy && jamieBusy) {
                    impossible = true;
                } else if (!cameronBusy) {
                    for (int time = start; time < end; time++) {
                        cameronSchedule[time] = 1;
                    }
                    schedule[n] = 'C';
                } else {
                    for (int time = start; time < end; time++) {
                        jamieSchedule[time] = 1;
                    }
                    schedule[n] = 'J';
                }
            }

            System.out.print("Case #" + (t + 1) + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (char c : schedule) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }
}