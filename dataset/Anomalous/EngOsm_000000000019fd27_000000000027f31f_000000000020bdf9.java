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
            int[] camAvailability = new int[1441];
            int[] jamAvailability = new int[1441];

            for (int i = 0; i <= 1440; i++) {
                camAvailability[i] = 0;
                jamAvailability[i] = 0;
            }

            for (int j = 0; j < N; j++) {
                int A = input.nextInt();
                int B = input.nextInt();

                for (int k = A + 1; k < B; k++) {
                    if (camAvailability[k] == 1) {
                        camStatus = "Busy";
                    }
                    if (jamAvailability[k] == 1) {
                        jamStatus = "Busy";
                    }
                    if ("Busy".equals(camStatus) && "Busy".equals(jamStatus)) {
                        pos = 'I';
                        break;
                    }
                }

                if ("Not Busy".equals(camStatus)) {
                    for (int k = A + 1; k < B; k++) {
                        camAvailability[k] = 1;
                    }
                    schedule[j] = 'C';
                } else if ("Not Busy".equals(jamStatus)) {
                    for (int k = A; k <= B; k++) {
                        jamAvailability[k] = 1;
                    }
                    schedule[j] = 'J';
                }
                camStatus = "Not Busy";
                jamStatus = "Not Busy";
            }

            System.out.print("Case #" + (M + 1) + ": ");
            if (pos == 'I') {
                System.out.println("IMPOSSIBLE");
            } else {
                for (char c : schedule) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
        input.close();
    }
}