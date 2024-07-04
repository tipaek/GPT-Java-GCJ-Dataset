import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            int operations = (rows - 1) * (columns - 1);
            System.out.println("Case #" + caseNumber + ": " + operations);
            
            int left = rows * (columns - 1);
            int right = rows - 1;
            
            while (operations > 0) {
                for (int i = 0; i < columns - 1; i++) {
                    System.out.println(left + " " + right);
                    left--;
                    operations--;
                }
                right--;
            }
        }
    }
}