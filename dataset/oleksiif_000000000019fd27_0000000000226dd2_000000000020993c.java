import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int caseIndex = 1; caseIndex <= T; caseIndex++) {
            int N = in.nextInt();
            int[][] M = new int[N][N];
            int sum = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;
            Set<Integer> [] uniqueColumnSet = new Set[N];
            for (int i = 0; i < N; i++) {
                uniqueColumnSet[i] = new HashSet<>();
            }
            for (int i = 0; i < N; i++) {
                var uniqueRowElements = new HashSet<Integer>();
                for (int j = 0; j < N; j++) {
                    int m = in.nextInt();
                    if (i == j)
                        sum += m;
                    uniqueRowElements.add(m);
                    uniqueColumnSet[j].add(m);
                }
                if (uniqueRowElements.size() < N)
                    repeatedRows++;
            }
            for (Set<Integer> columnSet: uniqueColumnSet) {
                if (columnSet.size() < N)
                    repeatedColumns++;
            }
            System.out.println(String.format("Case #%s: %s %s %s", caseIndex, sum, repeatedRows, repeatedColumns));
        }
    }
}