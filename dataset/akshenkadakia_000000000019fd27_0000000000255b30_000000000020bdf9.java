import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int caseN = 1;

        while (caseN <= T) {
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder(N);
            TreeMap<Integer, Integer> J = new TreeMap<>();
            TreeMap<Integer, Integer> C = new TreeMap<>();
            boolean possible = true;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                if (possible) {
                    int start = Integer.parseInt(st.nextToken());
                    int end = Integer.parseInt(st.nextToken());
                    boolean canFitJ = canFit(J, start, end);
                    if (canFitJ) {
                        sb.append('J');
                        J.put(start, end);
//                        J.put(start, 0);
//                        J.put(end, 1);
                    } else {
                        boolean canFitC = canFit(C, start, end);
                        if (canFitC) {
                            sb.append('C');
                            C.put(start, end);
//                            C.put(start, 0);
//                            C.put(end, 1);
                        } else {
                            sb = new StringBuilder("IMPOSSIBLE");
                            possible = false;
                        }
                    }
//                    System.out.println(J.toString());
//                    System.out.println(C.toString());
                }
            }

            System.out.printf("Case #%d: %s\n", caseN, sb.toString());
            caseN++;
        }
    }

    static boolean canFit(TreeMap<Integer, Integer> map, int start, int end) {
//        NavigableMap<Integer, Integer> subMap = map.subMap(start, true, end, true);
//        if (subMap.size() == 0) {
//            return true;
//        }
//
//        if (subMap.size() <= 2) {
//            Map.Entry<Integer, Integer> first = subMap.firstEntry();
//            Map.Entry<Integer, Integer> last = subMap.size() == 2 ? subMap.lastEntry() : null;
//
//            if (first.getKey() == start && first.getValue() == 1) {
//                return last == null || (last.getKey() == end && last.getValue() == 0);
//            }
//        }
        Map.Entry<Integer, Integer> lower = map.floorEntry(start);
        Integer same = map.get(start);
        Map.Entry<Integer, Integer> higher = map.higherEntry(start);

        if (lower != null && start < lower.getValue()) {
            return false;
        }

        if (same != null) {
            return false;
        }

        if (higher != null && higher.getKey() < end) {
            return false;
        }

        return true;
    }
}
