import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        int B = scanner.nextInt();

        for (int i = 1; i <= testCaseCount; i++) {
            char[] result = new char[B];
            int queries = 0;

            while (queries < 10) {
                queries++;
                System.out.println(queries);
                String response = scanner.next();
                result[queries - 1] = response.equals("1") ? '1' : '0';
            }

            System.out.println(new StringBuilder(new String(result)).reverse());

            if (!scanner.next().equals("Y")) {
                break;
            }
        }
    }
}