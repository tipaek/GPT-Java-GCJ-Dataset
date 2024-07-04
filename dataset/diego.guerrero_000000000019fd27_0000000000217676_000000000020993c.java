import java.util.*;
import java.io.*;

public class Solution {
    private static final String CASE_TEMPLATE = "Case #%s: %s %s %s";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            Map<Integer, Set<Integer>> colSeenMapSet = new HashMap<>();
            Map<Integer, Set<Integer>> rowSeenMapSet = new HashMap<>();
            int n = in.nextInt();
            int k = 0,  r = 0, c = 0;
            for (int rowIdx = 0; rowIdx < n; rowIdx++) {
                rowSeenMapSet.put(rowIdx, new HashSet<>());
                for (int colIdx = 0; colIdx < n; colIdx++) {
                    if (!colSeenMapSet.containsKey(colIdx)) {
                        colSeenMapSet.put(colIdx, new HashSet<>());
                    }
                    int val = in.nextInt();
                    if (rowIdx == colIdx) {
                        k += val;
                    }
                    colSeenMapSet.get(colIdx).add(val);
                    rowSeenMapSet.get(rowIdx).add(val);
                }
            }
            for (int j = 0; j < n; j++) {
                if (colSeenMapSet.get(j).size() != n)
                    c += 1;
                if (rowSeenMapSet.get(j).size() != n)
                    r += 1;
            }
            System.out.println(String.format(CASE_TEMPLATE, i+1, k, r, c));
        }
    }
}