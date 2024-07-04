import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int testCasesCount = scanner.nextInt();
        for (int i=1; i<=testCasesCount; i++) {
            int n = scanner.nextInt();
            int trace = 0;
            int dRow = 0;
            int dCol = 0;

            List<HashSet<Integer>> hashSets = new ArrayList<>();
            for (int j=0; j<n; j++) {
                hashSets.add(new HashSet<>());
            }

            for (int j=0; j<n; j++) {
                HashSet<Integer> hashSet = new HashSet<>();
                for (int k=0; k<n; k++) {
                    int d = scanner.nextInt();
                    if (j == k) {
                        trace = trace + d;
                    }
                    hashSet.add(d);
                    hashSets.get(k).add(d);
                }
                if (hashSet.size() != n) {
                    dRow++;
                }
            }

            for (int j=0; j<n; j++) {
                if (hashSets.get(j).size() != n) {
                    dCol++;
                }
            }

            printResult(i, trace, dRow, dCol);
        }
    }

    private static void printResult(int i, int trace, int dRowCount, int dColCount) {
        System.out.print("Case #");
        System.out.print(i);
        System.out.print(": ");
        System.out.print(trace);
        System.out.print(' ');
        System.out.print(dRowCount);
        System.out.print(' ');
        System.out.print(dColCount);
        System.out.println();
    }

}
