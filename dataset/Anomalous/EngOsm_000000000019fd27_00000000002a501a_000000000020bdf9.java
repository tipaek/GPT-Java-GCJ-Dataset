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
            int[] camOccupied = new int[1441];
            int[] jamOccupied = new int[1441];

            for (int i = 0; i <= 1440; i++) {
                camOccupied[i] = 0;
                jamOccupied[i] = 0;
            }

            int A = input.nextInt();
            int B = input.nextInt();
            for (int i = A + 1; i < B; i++) {
                camOccupied[i] = 1;
            }
            schedule[0] = 'C';

            for (int j = 1; j < N; j++) {
                A = input.nextInt();
                B = input.nextInt();

                for (int i = A + 1; i < B; i++) {
                    if (camOccupied[i] == 1) {
                        camStatus = "Busy";
                    }
                    if (jamOccupied[i] == 1) {
                        jamStatus = "Busy";
                    }
                    if ("Busy".equals(camStatus) && "Busy".equals(jamStatus)) {
                        pos = 'I';
                        break;
                    }
                }

                if ("Not Busy".equals(camStatus)) {
                    for (int i = A + 1; i < B; i++) {
                        camOccupied[i] = 1;
                    }
                    schedule[j] = 'C';
                } else if ("Not Busy".equals(jamStatus)) {
                    for (int i = A; i <= B; i++) {
                        jamOccupied[i] = 1;
                    }
                    schedule[j] = 'J';
                }

                camStatus = "Not Busy";
                jamStatus = "Not Busy";
            }

            System.out.println();
            System.out.print("Case #" + (M + 1) + ": ");
            if (pos == 'I') {
                System.out.print("IMPOSSIBLE");
            } else {
                for (char c : schedule) {
                    System.out.print(c);
                }
            }
        }
    }
}