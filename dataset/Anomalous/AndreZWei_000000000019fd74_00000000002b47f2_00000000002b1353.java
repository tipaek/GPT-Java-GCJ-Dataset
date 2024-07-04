import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int d = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ":\n" + solve(d));
        }
        scanner.close();
    }

    public static String solve(int d) {
        if (d == 1) return "1 1";
        if (d == 2) return "1 1\n2 2";
        if (d == 3) return "1 1\n2 2\n2 1";
        
        int c = 0, sum = 0;
        while (sum <= d) {
            c++;
            sum += c;
        }

        int diff = d - (sum - c);
        StringBuilder result = new StringBuilder();
        result.append("1 1\n");
        
        for (int i = 1; i < c; i++) {
            result.append(i + 1).append(" 2\n");
        }

        for (int i = 0; i < diff - 1; i++) {
            result.append(c - i).append(" 1\n");
        }

        return result.toString().trim();
    }
}