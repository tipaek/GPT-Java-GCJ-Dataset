import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        Random random = new Random();
        PrintWriter writer = new PrintWriter(System.out);
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        while (testCases > 0) {
            int attempts = 1;

            while (attempts <= 300) {
                long x = random.nextInt(999999995 - (-999999995) + 1) + (-999999995);
                long y = random.nextInt(999999995 - (-999999995) + 1) + (-999999995);
                System.out.println(x + " " + y);

                try {
                    writer.flush();
                } catch (Exception e) {
                    System.out.println(e);
                }

                String response = scanner.next();

                if (response.equals("CENTER")) {
                    break;
                } else if (response.equals("HIT") || response.equals("MISS")) {
                    attempts++;
                }
            }

            testCases--;
        }
    }
}