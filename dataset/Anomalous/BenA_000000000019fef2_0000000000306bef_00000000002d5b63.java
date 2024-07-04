import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] input = scanner.nextLine().split(" ");
        int numberOfTests = Integer.parseInt(input[0]);
        int radius = Integer.parseInt(input[1]);
        
        for (int test = 0; test < numberOfTests; test++) {
            performInteraction(1000000000 - radius);
        }
    }

    public static void performInteraction(int position) {
        int moveRange = position / 5;
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int leftBoundary = -1000000001;
        int rightBoundary = 1000000001;
        int bottomBoundary = -1000000001;
        int topBoundary = 1000000001;
        String response = "";

        // Find left boundary
        while (!response.equals("HIT")) {
            leftBoundary++;
            System.out.println(leftBoundary + " 0");
            System.out.flush();
            response = scanner.nextLine();
            if (response.equals("WRONG")) {
                System.exit(1);
            }
        }

        response = "";

        // Find bottom boundary
        while (!response.equals("HIT")) {
            bottomBoundary++;
            System.out.println("0 " + bottomBoundary);
            System.out.flush();
            response = scanner.nextLine();
            if (response.equals("WRONG")) {
                System.exit(1);
            }
        }

        // Search within the move range
        for (int x = 1000000000 - position - moveRange; x <= 1000000000 - position + moveRange; x++) {
            for (int y = 1000000000 - position - moveRange; y <= 1000000000 - position + moveRange; y++) {
                System.out.println((leftBoundary + x) + " " + (bottomBoundary + y));
                System.out.flush();
                response = scanner.nextLine();
                if (response.equals("CENTER")) {
                    return;
                }
                if (response.equals("WRONG")) {
                    System.exit(1);
                }
            }
        }

        System.exit(1);
    }
}