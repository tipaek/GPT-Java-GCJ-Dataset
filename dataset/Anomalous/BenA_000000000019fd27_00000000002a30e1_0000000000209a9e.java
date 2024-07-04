import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String inputLine;

        // Reading input lines until there's no more input
        while (scanner.hasNext()) {
            inputLine = scanner.nextLine();
        }

        // Exiting the program
        System.exit(1);

        // This part of the code will never be reached due to the System.exit(1) above
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            result.append(scanner.nextLine());
            System.out.flush();
        }

        // The following lines are commented out and will not execute
        // System.out.println(result.toString());
        // System.exit(1);
    }
}