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
                scanner.nextLine();
                System.out.println(queries);
                result[queries - 1] = scanner.nextInt() == 1 ? '1' : '0';
            }
            System.out.println(new String(result));
        }
    }
}