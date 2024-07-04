import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int[] result = new int[10];
            
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                System.out.flush();
                result[i] = scanner.nextInt();
            }

            for (int bit : result) {
                System.out.print(bit);
            }
            System.out.println();
            System.out.flush();

            String feedback = scanner.next();
            if (!feedback.equals("Y")) {
                System.exit(0);
            }
        }
    }
}