import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        for (int i = 0; i < testCases; i++) {
            interact();
        }
    }

    public static void interact() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int leftBound = -1000000001;
        int rightBound = 1000000001;
        int bottomBound = -1000000001;
        int topBound = 1000000001;
        String response = "";

        // Find the left boundary
        while (!response.equals("HIT")) {
            leftBound++;
            System.out.println(leftBound + " 0");
            System.out.flush();
            response = scanner.nextLine();
            if (response.equals("WRONG")) {
                System.exit(1);
            }
        }

        // Reset response
        response = "";

        // Find the bottom boundary
        while (!response.equals("HIT")) {
            bottomBound++;
            System.out.println("0 " + bottomBound);
            System.out.flush();
            response = scanner.nextLine();
            if (response.equals("WRONG")) {
                System.exit(1);
            }
        }

        // Search for the center
        for (int x = 999999994; x <= 999999996; x++) {
            for (int y = 999999994; y <= 999999996; y++) {
                System.out.println((leftBound + x) + " " + (bottomBound + y));
                System.out.flush();
                if (scanner.nextLine().equals("CENTER")) {
                    return;
                }
            }
        }
    }
}