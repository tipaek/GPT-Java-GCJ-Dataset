import java.util.Scanner;

public class Solution {

    static int T;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        T = scan.nextInt();

        scan.nextLine();

        for (int t = 0; t < T; t++) {

            // Getting table of int's
            String line = scan.nextLine();
            String[] tab = line.split("");
            int[] r = new int[tab.length];
            for (int i = 0; i < tab.length; i++) {
                r[i] = Integer.parseInt(tab[i]);
            }

            // Process
            StringBuilder sb = new StringBuilder();
            int currentPar = 0;
            for (int i = 0; i < r.length; i++) {
                int value = r[i];
                // Add parentheses
                if (currentPar < value) {
                    for (int j = currentPar; j < value; j++) {
                        sb.append('(');
                        currentPar++;
                    }
                } else if (currentPar > value) {
                    for (int j = currentPar; j > value; j--) {
                        sb.append(')');
                        currentPar--;
                    }
                }
                sb.append(value);
            }

            for (int j = currentPar; j > 0; j--) {
                sb.append(')');
            }

            System.out.println("Case #" + (t+1) + ": " + sb.toString());

        }

    }
}
