import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int M = 0; M < T; M++) {
            int N = input.nextInt();
            char[] MT = new char[N];
            int[] C = new int[1441];
            int[] J = new int[1441];
            char pos = 'P';
            boolean isImpossible = false;

            for (int i = 0; i <= 1440; i++) {
                C[i] = 0;
                J[i] = 0;
            }

            for (int j = 0; j < N; j++) {
                int A = input.nextInt();
                int B = input.nextInt();
                boolean camBusy = false;
                boolean jamBusy = false;

                for (int k = A + 1; k < B; k++) {
                    if (C[k] == 1) camBusy = true;
                    if (J[k] == 1) jamBusy = true;
                }

                if (camBusy && jamBusy) {
                    pos = 'I';
                    isImpossible = true;
                    break;
                }

                if (!camBusy) {
                    for (int k = A + 1; k < B; k++) {
                        C[k] = 1;
                    }
                    MT[j] = 'C';
                } else {
                    for (int k = A; k <= B; k++) {
                        J[k] = 1;
                    }
                    MT[j] = 'J';
                }
            }

            System.out.print("Case #" + (M + 1) + ": ");
            if (isImpossible) {
                System.out.print("IMPOSSIBLE");
            } else {
                for (char c : MT) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}