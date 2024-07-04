import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < T; i++) {
            if (A == B && A == 999999995) {
                boolean found = false;
                boolean exit = false;

                for (int x = -5; x <= 5; x++) {
                    for (int y = -5; y <= 5; y++) {
                        System.out.println(x + " " + y);
                        String response = scanner.nextLine();

                        if ("CENTER".equals(response)) {
                            found = true;
                            break;
                        } else if ("WRONG".equals(response)) {
                            exit = true;
                            break;
                        }
                    }
                    if (found || exit) {
                        break;
                    }
                }

                if (exit) {
                    break;
                }

            } else {
                String response = "";
                while (!"WRONG".equals(response)) {
                    System.out.println("0 0");
                    response = scanner.nextLine();
                }
                break;
            }
        }
    }
}