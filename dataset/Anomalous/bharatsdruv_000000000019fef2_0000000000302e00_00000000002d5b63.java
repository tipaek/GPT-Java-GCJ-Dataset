import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        long A = scanner.nextLong();
        long B = scanner.nextLong();

        for (int t = 0; t < testCases; t++) {
            boolean foundCenter = false;
            for (int x = -5; x <= 5 && !foundCenter; x++) {
                for (int y = 5; y >= -5; y--) {
                    System.out.println(x + " " + y);
                    String response = scanner.next();
                    if (response.equals("CENTER")) {
                        foundCenter = true;
                        break;
                    }
                }
            }
        }
    }
}