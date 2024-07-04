import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            int count = 0;
            ArrayList<Integer> results = new ArrayList<>();
            
            for (int row = 1; row < rows; row++) {
                for (int column = 1; column < columns; column++) {
                    results.add(rows - row + 1);
                    int value = (columns - 1 - column) * (rows - row + 1) + (column) * (rows - row);
                    results.add(value);
                    count++;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + count);
            for (int index = 0; index < count * 2; index += 2) {
                System.out.println(results.get(index) + " " + results.get(index + 1));
            }
        }
        
        scanner.close();
    }
}