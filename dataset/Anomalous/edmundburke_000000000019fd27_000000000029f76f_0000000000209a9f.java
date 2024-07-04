import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static int caseCount;
    private static int caseIndex = 0;

    public static void main(String[] args) {
        ArrayList<char[]> rows = readInputAsCharRows();
        
        caseCount = Integer.parseInt(String.valueOf(rows.remove(0)[0]));
        while (caseCount > 0) {
            processCase(rows.remove(0));
            caseCount--;
        }
        System.exit(0);
    }
    
    private static void processCase(char[] row) {
        caseIndex++;
        StringBuilder result = new StringBuilder("Case #" + caseIndex + ": ");
        int currentDepth = 0;
        for (char c : row) {
            int targetDepth = Character.getNumericValue(c);
            while (targetDepth > currentDepth) {
                result.append('(');
                currentDepth++;
            }
            while (targetDepth < currentDepth) {
                result.append(')');
                currentDepth--;
            }
            result.append(c);
        }
        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }
        System.out.println(result.toString());
    }
    
    private static ArrayList<char[]> readInputAsCharRows() {
        ArrayList<String> rows = readInputAsStringRows();
        ArrayList<char[]> charRows = new ArrayList<>();
        for (String row : rows) {
            charRows.add(row.toCharArray());
        }
        return charRows;
    }
    
    private static ArrayList<String> readInputAsStringRows() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputLines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            inputLines.add(scanner.nextLine());
        }
        scanner.close();
        return inputLines;
    }
}