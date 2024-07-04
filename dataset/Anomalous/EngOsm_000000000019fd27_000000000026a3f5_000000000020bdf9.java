import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int M = 0; M < T; M++) {
            char pos = 'P';
            String camStatus = "Not Busy";
            String jamStatus = "Not Busy";
            int N = input.nextInt();

            char[] MT = new char[N];
            int[] C = new int[1441];
            int[] J = new int[1441];

            for (int j = 0; j < N; j++) {
                int A = input.nextInt();
                int B = input.nextInt();
                for (int i = A + 1; i < B; i++) {
                    if (C[i] == 1) camStatus = "Busy";
                    if (J[i] == 1) jamStatus = "Busy";
                    if ("Busy".equals(camStatus) && "Busy".equals(jamStatus)) {
                        pos = 'I';
                        break;
                    }
                }
                if ("Not Busy".equals(camStatus)) {
                    for (int i = A; i <= B; i++) {
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

            System.out.print("Case #" + (M + 1) + ": ");
            if (pos == 'I') {
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