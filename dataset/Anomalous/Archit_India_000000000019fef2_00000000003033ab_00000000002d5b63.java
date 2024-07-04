import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int i = 0; i < t; i++) {
            boolean foundCenter = false;

            for (int x = -5; x <= 5 && !foundCenter; x++) {
                for (int y = -5; y <= 5; y++) {
                    System.out.println(x + " " + y);
                    String response = sc.nextLine();

                    if (response.equalsIgnoreCase("CENTER")) {
                        foundCenter = true;
                        break;
                    }
                }
            }
        }

        sc.close();
    }
}