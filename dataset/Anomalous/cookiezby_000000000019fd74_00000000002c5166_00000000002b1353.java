import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int caseCount = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < caseCount; i++) {
                int N = Integer.parseInt(sc.nextLine());
                List<String> result = new ArrayList<>();
                generateResult(result, N);
                System.out.printf("Case #%d:%n", i + 1);
                result.forEach(System.out::println);
            }
        }
    }

    private static void generateResult(List<String> result, int N) {
        if (N <= 500) {
            for (int i = 1; i <= N; i++) {
                result.add(String.format("%d, %d", i, 1));
            }
        } else {
            result.add("1, 1");
            result.add("2, 2");
            result.add("2, 1");
            result.add("3, 1");
            result.add("3, 2");
            result.add("3, 3");
            for (int i = 1; i <= N - 7; i++) {
                result.add(String.format("%d, %d", i + 3, i + 3));
            }
        }
    }
}