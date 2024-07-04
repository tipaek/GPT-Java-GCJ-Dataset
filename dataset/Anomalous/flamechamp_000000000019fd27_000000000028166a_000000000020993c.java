import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int entries = Integer.parseInt(sc.nextLine());

        int[] incorrectRow = new int[entries];
        int[] incorrectCol = new int[entries];
        int[] trace = new int[entries];

        for (int z = 0; z < entries; z++) {
            int N = Integer.parseInt(sc.nextLine());

            boolean[] duplicateColumn = new boolean[N];
            Set<Integer>[] columnSet = new HashSet[N];
            for (int i = 0; i < N; i++) {
                columnSet[i] = new HashSet<>();
            }

            for (int i = 0; i < N; i++) {
                String[] elements = sc.nextLine().split(" ");
                Set<Integer> rowSet = new HashSet<>();
                boolean duplicateRow = false;

                for (int j = 0; j < N; j++) {
                    int elementValue = Integer.parseInt(elements[j]);

                    if (!rowSet.add(elementValue)) {
                        duplicateRow = true;
                    }

                    if (!columnSet[j].add(elementValue)) {
                        duplicateColumn[j] = true;
                    }

                    if (i == j) {
                        trace[z] += elementValue;
                    }
                }

                if (duplicateRow) {
                    incorrectRow[z]++;
                }
            }

            for (boolean col : duplicateColumn) {
                if (col) {
                    incorrectCol[z]++;
                }
            }
        }

        sc.close();

        for (int i = 0; i < entries; i++) {
            System.out.println("Case #" + (i + 1) + ": " + trace[i] + " " + incorrectRow[i] + " " + incorrectCol[i]);
        }
    }
}