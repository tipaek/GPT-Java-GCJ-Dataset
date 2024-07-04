import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        // Read all lines until no more input
        while (scanner.hasNext()) {
            String inputLine = scanner.nextLine();
        }
        
        StringBuilder answer = new StringBuilder();
        
        // Read 10 lines and print numbers from 1 to 10
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            answer.append(scanner.nextLine());
            System.out.flush();
        }
        
        // Print the concatenated result of the 10 input lines
        System.out.println(answer.toString());
        
        // Exit the program
        System.exit(1);
    }
}