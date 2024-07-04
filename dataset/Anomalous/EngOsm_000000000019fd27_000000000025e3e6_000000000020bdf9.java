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
            boolean impossible = false;

            for (int j = 0; j < N; j++) {
                int A = input.nextInt();
                int B = input.nextInt();
                
                boolean camBusy = false;
                boolean jamBusy = false;

                for (int i = A + 1; i < B; i++) {
                    if (C[i] == 1) camBusy = true;
                    if (J[i] == 1) jamBusy = true;
                    if (camBusy && jamBusy) {
                        impossible = true;
                        break;
                    }
                }

                if (impossible) break;

                if (!camBusy) {
                    for (int i = A; i <= B; i++) C[i] = 1;
                    MT[j] = 'C';
                } else if (!jamBusy) {
                    for (int i = A; i <= B; i++) J[i] = 1;
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

        input.close();
    }
}