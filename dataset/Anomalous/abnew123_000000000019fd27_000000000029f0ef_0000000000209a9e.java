import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.next());
        int B = Integer.parseInt(scanner.next());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            boolean[] data = new boolean[B];

            if (B == 10) {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    String response = scanner.next();
                    data[i - 1] = Integer.parseInt(response) == 1;
                }

                StringBuilder answer = new StringBuilder();
                for (boolean bit : data) {
                    answer.append(bit ? 1 : 0);
                }

                System.out.println(answer.toString());

                if (!scanner.next().equals("Y")) {
                    return;
                }
            } else {
                System.out.println("00000000000000000000");
                scanner.next();
                return;
            }
        }
    }
}