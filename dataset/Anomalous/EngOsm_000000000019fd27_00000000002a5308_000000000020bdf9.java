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

            char[] MT = new char[N];
            int[] C = new int[1441];
            int[] J = new int[1441];

            int A = input.nextInt();
            int B = input.nextInt();
            for (int i = A + 1; i < B; i++) {
                C[i] = 1;
            }
            MT[0] = 'C';

            for (int j = 1; j < N; j++) {
                A = input.nextInt();
                B = input.nextInt();

                for (int i = A + 1; i < B; i++) {
                    if (C[i] == 1) {
                        camStatus = "Busy";
                    }
                    if (J[i] == 1) {
                        jamStatus = "Busy";
                    }
                    if ("Busy".equals(camStatus) && "Busy".equals(jamStatus)) {
                        pos = 'I';
                        break;
                    }
                }

                if ("Not Busy".equals(camStatus)) {
                    for (int i = A + 1; i < B; i++) {
                        C[i] = 1;
                    }
                    MT[j] = 'C';
                } else if ("Not Busy".equals(jamStatus)) {
                    for (int i = A; i <= B; i++) {
                        J[i] = 1;
                    }
                    MT[j] = 'J';
                }

                camStatus = "Not Busy";
                jamStatus = "Not Busy";
            }

            System.out.println();
            System.out.print("Case #");
            System.out.print(M + 1);
            System.out.print(": ");
            if (pos == 'I') {
                System.out.print("IMPOSSIBLE");
                pos = 'P';
            } else {
                for (int i = 0; i < N; i++) {
                    System.out.print(MT[i]);
                }
            }
        }
    }
}