import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solveProblem(scanner);
    }

    public static void solveProblem(Scanner scanner) {
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            solveCase(scanner, n);
        }
    }

    public static void solveCase(Scanner scanner, int n) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
            integers.add(scanner.nextInt());
        }
        StringBuilder result = new StringBuilder();
        for (Integer integer : integers) {
            result.append(integer).append(" ");
        }
        System.out.println(result.toString().trim());
        String response = scanner.next();
        if ("N".equals(response)) {
            throw new RuntimeException("Oops");
        }
    }
}