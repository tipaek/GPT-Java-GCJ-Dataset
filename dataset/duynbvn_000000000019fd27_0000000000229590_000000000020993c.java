
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
   public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCase = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= numberOfTestCase; ++testCase) {
            int matrixSize = in.nextInt();
            int numberOfRowRepeat = 0;
            int trace = 0;
            Map<Integer, Set<Integer>> columnMap = new HashMap<>();
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int column = 0; column < matrixSize; column++) {
                    int value = in.nextInt();
                    if (row == column) trace = trace + value;
                    rowSet.add(value);
                    columnMap.computeIfAbsent(column, integer -> new HashSet<>()).add(value);
                }
                if (rowSet.size()< matrixSize) numberOfRowRepeat++;
            }
            long numberOfColumnRepeat = columnMap.values().parallelStream().map(Set::size).filter(integer -> integer < matrixSize).count();
            System.out.println("Case #" + testCase + ": " + trace + " " + numberOfRowRepeat + " " + numberOfColumnRepeat);
        }
    }
}