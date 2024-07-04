import java.util.Scanner;

public class Solution { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ": ");

            if (n == 501) {
                System.out.println("1 1");
                System.out.println("2 2");
                System.out.println("3 2");
                for (int i = 3, j = 3; i <= 500; i++, j++) {
                    System.out.println(i + " " + j);
                }
            } else if (n <= 500) {
                for (int i = 1, j = 1; n > 0; i++, j++, n--) {
                    System.out.println(i + " " + j);
                }
            }
            System.out.println();
        }
    }
}