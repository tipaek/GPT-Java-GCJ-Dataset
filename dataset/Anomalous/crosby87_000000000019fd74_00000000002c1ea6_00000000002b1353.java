import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numberOfLines = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ": ");
            
            for (int line = 1; line <= numberOfLines; line++) {
                System.out.println(line + " " + line);
            }
        }
    }
}