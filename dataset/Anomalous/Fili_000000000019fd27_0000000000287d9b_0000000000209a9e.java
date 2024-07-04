import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();

        for (int i = 1; i <= T; i++) {
            int[] array = new int[B];

            if (B == 10) {
                for (int j = 1; j <= B; j++) {
                    System.out.println(j);
                    array[j - 1] = input.nextInt();
                }
            }
            // Additional conditions for B can be handled here if needed
            else if (B == 20) {
                // Implement logic for B == 20 if required
            }
            else {
                // Implement logic for other values of B if required
            }

            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < B; k++) {
                sb.append(array[k]);
            }

            System.out.println(sb.toString());
            String s = input.next();

            if (s.equals("Y")) {
                continue;
            } else if (s.equals("N")) {
                break;
            }
        }
    }
}