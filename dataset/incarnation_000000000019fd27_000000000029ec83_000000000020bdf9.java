
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 0; i < t; i++) {

            StringBuilder sb = new StringBuilder();
            int rowSize = in.nextInt();
            List<int[]> list = new ArrayList<>();
            Map<int[], String> map = new HashMap<>();

            int[][] arr = new int[rowSize][2];
            int[][] arrOriginal = new int[rowSize][2];

            for (int k = 0; k < rowSize; k++) {
                for (int j = 0; j < 2; j++) {
                    arr[k][j] = in.nextInt();
                    arrOriginal[k][j] = arr[k][j];
                }
            }

            Arrays.sort(arr, (a, b) -> {
                if (a[0] == b[0])
                    return a[1] - b[1];

                return a[0] - b[0];
            });
            
            for (int[] interval : arr) {
                list.add(interval);
            }

            String[] cases = new String[list.size()];
            cases[0] = "C";

            int[] prev = list.get(0);
            map.put(prev, "C");

            for (int j = 1; j < list.size(); j++) {
                if (!isOverLap(prev, list.get(j))) {
                    cases[j] = "C";
                    prev = list.get(j);
                    map.put(list.get(j), "C");
                }
            }

            /*
             * System.out.println("Round 1 cases:"); for(String str : cases){
             * System.out.print(str + " "); } System.out.println();
             */

            int startJindex = 0;
            prev = null;
            for (int j = 1; j < cases.length; j++) {
                if (cases[j] == null) {
                    startJindex = j;
                    prev = list.get(j);
                    cases[j] = "J";
                    map.put(prev, "J");
                    break;
                }
            }

            if (prev != null) {
                // System.out.println("start j index:" + startJindex);
                // System.out.println("prev:" + prev[0] + " " + prev[1]);
                for (int j = startJindex; j < list.size(); j++) {
                    if (cases[j] != "C" && !isOverLap(prev, list.get(j))) {
                        cases[j] = "J";
                        prev = list.get(j);
                        map.put(list.get(j), "J");
                    }
                }
            }

            // System.out.println("Round 2 cases:");
            boolean flag = false;
            for (String str : cases) {
                // System.out.println(str);
                if (str == null) {
                    sb.setLength(0);
                    sb.append("IMPOSSIBLE");
                    flag = true;
                }
            }

            if (!flag) {
                // System.out.println("I am here");
                for (int[] interval : arrOriginal) {
                    // System.out.println(interval[0] + " " + interval[1]);
                    // System.out.println(map.get(interval));
                    // sb.append(map.get(interval));

                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j)[0] == interval[0] && list.get(j)[1] == interval[1])
                            sb.append(cases[j]);
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + sb.toString());
        }
    }

    private static boolean isOverLap(int[] A, int[] B) {
        int first = Math.max(A[0], B[0]);
        int second = Math.min(A[1], B[1]);

        if (second > first)
            return true;

        return false;
    }

}
