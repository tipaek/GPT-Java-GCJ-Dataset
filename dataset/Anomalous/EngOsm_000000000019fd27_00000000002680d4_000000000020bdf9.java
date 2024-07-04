import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int M = 0; M < T; M++) {
            int N = input.nextInt();
            char[] MT = new char[N];
            boolean[] C = new boolean[1441];
            boolean[] J = new boolean[1441];
            boolean impossible = false;

            for (int j = 0; j < N; j++) {
                int A = input.nextInt();
                int B = input.nextInt();
                boolean camBusy = false, jamBusy = false;

                for (int i = A; i < B; i++) {
                    if (C[i]) camBusy = true;
                    if (J[i]) jamBusy = true;
                }

                if (camBusy && jamBusy) {
                    impossible = true;
                    break;
                } else if (!camBusy) {
                    for (int i = A; i < B; i++) {
                        C[i] = true;
                    }
                    MT[j] = 'C';
                } else {
                    for (int i = A; i < B; i++) {
                        J[i] = true;
                    }
                    MT[j] = 'J';
                }
            }

            System.out.print("Case #" + (M + 1) + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (char c : MT) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }
}