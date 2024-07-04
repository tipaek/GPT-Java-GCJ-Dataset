import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            StringBuilder solution = new StringBuilder();
            for (int i = 1; i <= bitLength; i++) {
                System.out.println(i);
                System.out.flush();
                solution.append(scanner.next().charAt(0));
            }
            System.out.println(solution.toString());
            System.out.flush();
            if (scanner.next().charAt(0) == 'N') {
                System.exit(0);
            }
        }
        System.exit(0);
    }
}