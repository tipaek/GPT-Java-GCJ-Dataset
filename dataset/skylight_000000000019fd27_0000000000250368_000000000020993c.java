import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tt = 0; tt < t; tt++) {
            int n = sc.nextInt(), trace = 0;
            Set<Integer> columnsWithRepeatedValues = new HashSet<>();
            Set<Integer> rowsWithRepeatedValues = new HashSet<>();
            Set<Integer>[] rowValues = new HashSet[n];
            Set<Integer>[] columnValues = new HashSet[n];
            for(int i = 0; i < n; i++) {
                rowValues[i] = new HashSet<>();
                for(int j = 0; j < n; j++) {
                    if(columnValues[j] == null) columnValues[j] = new HashSet<>();
                    int currentValue = sc.nextInt();
                    if(rowValues[i].contains(currentValue)) rowsWithRepeatedValues.add(i);
                    if(columnValues[j].contains(currentValue)) columnsWithRepeatedValues.add(j);
                    if(i == j) trace += currentValue;
                    rowValues[i].add(currentValue);
                    columnValues[j].add(currentValue);
                }
            }
            System.out.println(String.format("Case #%d: %d %d %d", tt+1, trace, rowsWithRepeatedValues.size(), columnsWithRepeatedValues.size()));
        }
    }
}
