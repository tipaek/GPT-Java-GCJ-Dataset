import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int a = in.nextInt();
            TreeMap<Integer, Integer> mapJ = new TreeMap<>();
            TreeMap<Integer, Integer> mapC = new TreeMap<>();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int j = 0; j < a; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                if (isImpossible) {
                    continue;
                }

                if (canBeAssigned(mapJ, start, end)) {
                    mapJ.put(start, end);
                    result.append("J");
                } else if (canBeAssigned(mapC, start, end)) {
                    mapC.put(start, end);
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
        in.close();
    }

    private static boolean canBeAssigned(TreeMap<Integer, Integer> map, int start, int end) {
        Entry<Integer, Integer> floorEntry = map.floorEntry(start);
        if (floorEntry != null && floorEntry.getValue() > start) {
            return false;
        }

        Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(start);
        if (ceilingEntry != null && ceilingEntry.getKey() < end) {
            return false;
        }

        return true;
    }
}