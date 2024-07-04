import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int M = 0; M < T; M++) {
            int N = input.nextInt();
            char[] schedule = new char[N];
            boolean[] C = new boolean[1441];
            boolean[] J = new boolean[1441];
            boolean impossible = false;

            for (int j = 0; j < N; j++) {
                int A = input.nextInt();
                int B = input.nextInt();

                boolean canAssignC = true;
                boolean canAssignJ = true;

                for (int k = A + 1; k <= B; k++) {
                    if (C[k]) canAssignC = false;
                    if (J[k]) canAssignJ = false;
                }

                if (!canAssignC && !canAssignJ) {
                    impossible = true;
                } else if (canAssignC) {
                    for (int k = A; k <= B; k++) {
                        C[k] = true;
                    }
                    schedule[j] = 'C';
                } else {
                    for (int k = A; k <= B; k++) {
                        J[k] = true;
                    }
                    schedule[j] = 'J';
                }
            }

            System.out.print("Case #");
            System.out.print(M + 1);
            System.out.print(": ");
            if (impossible) {
                System.out.print("IMPOSSIBLE");
            } else {
                for (char ch : schedule) {
                    System.out.print(ch);
                }
            }
            System.out.println();
        }
        input.close();
    }
}