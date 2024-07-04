import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();

            System.out.println("Case #" + caseNumber + ": " + ((rows - 1) * (columns - 1)));
            
            for (int column = columns - 1; column >= 1; column--) {
                for (int row = 0; row < rows - 1; row++) {
                    int result = (column + 1) * (rows - 1 - row) + column * row;
                    System.out.println(result + " " + column);
                }
            }
        }
    }
}