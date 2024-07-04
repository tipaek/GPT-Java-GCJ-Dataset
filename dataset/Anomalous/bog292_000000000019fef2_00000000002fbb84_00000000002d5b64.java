import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // Uncomment the line below and comment the above line to read from a file.
        // Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/jointheranks/input.txt"))));
        
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            processCase(caseNumber, x, y);
        }
    }

    private static void processCase(int caseNumber, int x, int y) {
        System.out.println("Case #" + caseNumber + ": " + (x - 1) * (y - 1));
        for (int i = x; i > 1; i--) {
            generateOutput(i, y);
        }
    }

    private static void generateOutput(int x, int y) {
        int baseValue = x * (y - 1);
        for (int i = 0; i < y - 1; i++) {
            System.out.println((baseValue - i) + " " + (x - 1));
        }
    }
}