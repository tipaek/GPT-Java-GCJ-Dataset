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

            char[] schedule = new char[N];
            boolean[] camBusy = new boolean[1441];
            boolean[] jamBusy = new boolean[1441];

            for (int j = 0; j < N; j++) {
                int A = input.nextInt();
                int B = input.nextInt();
                boolean conflict = false;

                for (int k = A + 1; k <= B; k++) {
                    if (camBusy[k]) camStatus = "Busy";
                    if (jamBusy[k]) jamStatus = "Busy";
                    if ("Busy".equals(camStatus) && "Busy".equals(jamStatus)) {
                        pos = 'I';
                        conflict = true;
                        break;
                    }
                }

                if (conflict) break;

                if ("Not Busy".equals(camStatus)) {
                    for (int k = A; k <= B; k++) camBusy[k] = true;
                    schedule[j] = 'C';
                } else if ("Not Busy".equals(jamStatus)) {
                    for (int k = A; k <= B; k++) jamBusy[k] = true;
                    schedule[j] = 'J';
                }

                camStatus = "Not Busy";
                jamStatus = "Not Busy";
            }

            System.out.print("Case #" + (M + 1) + ": ");
            if (pos == 'I') {
                System.out.println("IMPOSSIBLE");
            } else {
                for (char ch : schedule) {
                    System.out.print(ch);
                }
                System.out.println();
            }
        }
        input.close();
    }
}