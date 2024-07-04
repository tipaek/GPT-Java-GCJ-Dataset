import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        int caseNumber = 0;
        
        for (int i = 0; i < numberOfTests; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Case #" + caseNumber++ + ": IMPOSSIBLE");
        }
    }
}