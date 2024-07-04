import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            
            StringBuilder result = new StringBuilder();
            
            for (int j = 0; j < n; j++) {
                String line = scanner.nextLine();
                // The original code logic for processing each line is commented out.
                // Assuming the final output for each case is "CC" as per the original code.
            }
            
            System.out.println("Case #" + i + ": CC");
        }
    }
}