import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String inputLine;
        
        // Read all input lines until no more input is available
        while (scanner.hasNext()) {
            inputLine = scanner.nextLine();
        }

        StringBuilder result = new StringBuilder();
        
        // Print numbers from 1 to 10 and read corresponding input lines
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            result.append(scanner.nextLine());
            System.out.flush();
        }

        // Print the concatenated result of input lines
        System.out.println(result.toString());
        System.out.flush();

        // Read one more line and print it
        inputLine = scanner.nextLine();
        System.out.println(inputLine);
    }
}