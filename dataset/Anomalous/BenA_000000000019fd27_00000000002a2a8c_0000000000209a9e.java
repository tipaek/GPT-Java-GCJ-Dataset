import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Consume all input lines until there's no more input
        String lastLine = "";
        while (scanner.hasNext()) {
            lastLine = scanner.nextLine();
        }

        // Collect 10 lines of input and concatenate them
        StringBuilder concatenatedInput = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            if (scanner.hasNextLine()) {
                concatenatedInput.append(scanner.nextLine());
            }
            System.out.flush();
        }

        // Print the concatenated result
        System.out.println(concatenatedInput.toString());
        System.out.flush();

        // Read one more line and print it
        if (scanner.hasNextLine()) {
            lastLine = scanner.nextLine();
        }
        System.out.println(lastLine);

        // Exit the program
        System.exit(1);
    }
}