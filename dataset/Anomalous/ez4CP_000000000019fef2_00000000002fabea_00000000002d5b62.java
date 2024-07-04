import java.util.Scanner;

public class CodeJamExpogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
        scanner.close();
    }
}