import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < caseCount; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            List<String> result = new ArrayList<>();
            generateSolution(result, N);
            
            System.out.printf("Case #%d:%n", i + 1);
            for (String val : result) {
                System.out.println(val);
            }
        }
        
        scanner.close();
    }

    private static void generateSolution(List<String> result, int N) {
        if (N <= 500) {
            for (int i = 1; i <= N; i++) {
                result.add(String.format("%d, %d", i, 1));
            }
        } else {
            result.add("1, 1");
            result.add("2, 1");
            result.add("2, 2");
            result.add("3, 3");
            result.add("3, 2");
            result.add("3, 1");
            
            for (int i = 1; i <= N - 7; i++) {
                result.add(String.format("%d, %d", i + 3, 1));
            }
        }
    }
}