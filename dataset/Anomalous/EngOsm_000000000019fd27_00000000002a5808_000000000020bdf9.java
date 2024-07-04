import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int M = 0; M < T; M++) {
            int N = input.nextInt();
            char pos = 'P';
            String camStatus = "Not Busy";
            String jamStatus = "Not Busy";
            char[] schedule = new char[N];
            int[] camBusy = new int[1441];
            int[] jamBusy = new int[1441];

            for (int i = 0; i <= 1440; i++) {
                camBusy[i] = 0;
                jamBusy[i] = 0;
            }

            int start = input.nextInt();
            int end = input.nextInt();
            for (int i = start + 1; i < end; i++) {
                camBusy[i] = 1;
            }
            schedule[0] = 'C';

            for (int j = 1; j < N; j++) {
                start = input.nextInt();
                end = input.nextInt();
                camStatus = "Not Busy";
                jamStatus = "Not Busy";

                for (int i = start + 1; i < end; i++) {
                    if (camBusy[i] == 1) camStatus = "Busy";
                    if (jamBusy[i] == 1) jamStatus = "Busy";
                    if ("Busy".equals(camStatus) && "Busy".equals(jamStatus)) {
                        pos = 'I';
                        break;
                    }
                }

                if ("Not Busy".equals(camStatus)) {
                    for (int i = start + 1; i < end; i++) {
                        camBusy[i] = 1;
                    }
                    schedule[j] = 'C';
                } else if ("Not Busy".equals(jamStatus)) {
                    for (int i = start; i < end; i++) {
                        jamBusy[i] = 1;
                    }
                    schedule[j] = 'J';
                }
            }

            System.out.print("Case #" + (M + 1) + ": ");
            if (pos == 'I') {
                System.out.print("IMPOSSIBLE");
            } else {
                for (char c : schedule) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}