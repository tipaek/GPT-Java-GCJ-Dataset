import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int N = scanner.nextInt();
            System.out.println("Case #" + caseNumber++ + ":");
            N--;
            System.out.println("1 1");

            int next = 1;
            int row = 1;

            while (N > 0) {
                if (N - next < 0) {
                    while (N > 0) {
                        System.out.println(row + " 1");
                        row--;
                        N--;
                    }
                } else {
                    row++;
                    System.out.println(row + " 2");
                    N -= next;
                    next++;
                }
            }
        }

        System.out.flush();
    }
}