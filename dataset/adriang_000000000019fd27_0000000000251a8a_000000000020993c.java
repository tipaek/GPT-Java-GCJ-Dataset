import java.util.*;
import java.io.*;
public class Solution {



    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int trace =0;
            int numberOfRowRepeatedElements = 0;
            int numberOfColumnsRepeatedElements = 0;
            Set<Integer> columnElememnts = new HashSet<>();
            Map<Integer,Boolean> duplicateColumns = new HashMap<>();
            in.nextLine();
            for (int j = 0; j < n; j++) {
                Set<Integer> rowElememnts = new HashSet<>();
                String row = in.nextLine();
                String[] elements = row.split("\\s");
                trace += Integer.parseInt(elements[j]);
                boolean duplicateElementsRow = false;
                for (int k = 0; k < elements.length;k++) {
                    int elementjk = Integer.parseInt(elements[k]);
                    if (rowElememnts.contains(elementjk) && !duplicateElementsRow) {
                        numberOfRowRepeatedElements++;
                        duplicateElementsRow = true;
                    }
                    rowElememnts.add(elementjk);
                    if (columnElememnts.contains(k*100+elementjk) && !duplicateColumns.containsKey(k)) {
                        numberOfColumnsRepeatedElements++;
                        duplicateColumns.put(k,true);
                    }
                    columnElememnts.add(k*100+elementjk);

                }
            }
            System.out.println();
            System.out.println("Case #" + i + ": " + trace + " " + numberOfRowRepeatedElements + " " + numberOfColumnsRepeatedElements);
        }
    }
}