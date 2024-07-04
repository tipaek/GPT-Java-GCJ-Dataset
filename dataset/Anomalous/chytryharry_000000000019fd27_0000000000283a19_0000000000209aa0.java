import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int trace = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ": " + isPossibleToGenerate(size, trace));
        }
    }

    private static String isPossibleToGenerate(int size, int trace) {
        if (size > trace) {
            return "IMPOSSIBLE";
        }
        if (size == 1 && trace != 1) {
            return "IMPOSSIBLE";
        }
        if (size == 2 && (trace != 2 && trace != 4)) {
            return "IMPOSSIBLE";
        }
        
        Set<Integer> validTraces = new HashSet<>();
        for (int i = 1; i <= trace; i++) {
            validTraces.add(i * size);
        }
        validTraces.add(IntStream.rangeClosed(1, size).sum());
        
        return validTraces.contains(trace) ? "POSSIBLE" : "IMPOSSIBLE";
    }
}