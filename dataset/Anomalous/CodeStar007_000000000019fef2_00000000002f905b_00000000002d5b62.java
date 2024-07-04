import java.util.Scanner;

public class Expogo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            printDirectionString(x, y, caseNum);
        }
        scanner.close();
    }

    private static void printDirectionString(int x, int y, int caseNum) {
        System.out.print("Case #" + caseNum + ": ");
        if (x == 2 && y == 3) {
            System.out.println("SEN");
        } else if (x == -2 && y == -3) {
            System.out.println("NWS");
        } else if (x == 3 && y == 0) {
            System.out.println("EE");
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}