import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int N = Integer.parseInt(scanner.nextLine());
            List<String> results = new ArrayList<>();
            generateSolution(results, N);
            
            System.out.printf("Case #%d:%n", caseIndex + 1);
            results.forEach(System.out::println);
        }
        
        scanner.close();
    }
    
    private static void generateSolution(List<String> results, int N) {
        if (N <= 500) {
            for (int i = 1; i <= N; i++) {
                results.add(String.format("%d, %d", i, 1));
            }
        } else {
            results.add("1, 1");
            results.add("2, 1");
            results.add("2, 2");
            results.add("3, 3");
            results.add("3, 2");
            results.add("3, 1");
            for (int i = 1; i <= N - 7; i++) {
                results.add(String.format("%d, %d", i + 3, i));
            }
        }
    }
}