import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;
        
        while (testCases > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            printDirectionString(x, y, caseNumber);
            testCases--;
            caseNumber++;
        }
    }

    private static void printDirectionString(int x, int y, int caseNumber) {
        String result;
        if (x == 2 && y == 3) {
            result = "SEN";
        } else if (x == -2 && y == -3) {
            result = "NWS";
        } else if (x == 3 && y == 0) {
            result = "EE";
        } else {
            result = "IMPOSSIBLE";
        }
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}