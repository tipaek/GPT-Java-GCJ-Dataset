
import javafx.util.Pair;

import java.util.*;

class Solution {

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            Map<Integer, Integer> conflictedMap = new HashMap<>();
//            Map<Integer, Integer> scheduleMap = new HashMap<>();
            List<Pair<Integer, Integer>> scheduleList = new ArrayList<>();

            StringBuilder scheduledResult = new StringBuilder();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
//                scheduleMap.put(start, end);
                scheduleList.add(new Pair<>(start, end));
            }

            int size_e = 0;
            if (!scheduleList.isEmpty()) {
                for(int j=0; j<n; j++) {
                    scheduledResult.append("C");
                }
            }
            for (Pair<Integer, Integer> entry : scheduleList) {

                int size_o = 0;
                for (Pair<Integer, Integer> others : scheduleList) {
                    if (size_e > size_o) {
                        continue;
                    }
                    if (others != entry) {
                        if (others.getKey() < entry.getValue() &&
                                others.getValue() > entry.getKey()) {
                            conflictedMap.put(Math.max(entry.getKey(), others.getKey()), Math.min(others.getValue(), entry.getValue()));
                            //scheduledResult.insert(size_o, scheduledResult.charAt(size_e));
                            if (scheduledResult.charAt(size_e) == 'C') {
                                scheduledResult.replace(size_o, size_o + 1, "J");
                            } else {
                                scheduledResult.replace(size_o, size_o + 1, "C");
                            }
                        } else {
                            scheduledResult.replace(size_o, size_o + 1, scheduledResult.charAt(size_e) + "");
                        }
                    }
                    size_o++;
                }
                size_e++;
            }

            for (Map.Entry<Integer, Integer> entry : conflictedMap.entrySet()) {
                boolean isImpossible = false;
                for (Map.Entry<Integer, Integer> others : conflictedMap.entrySet()) {
                    if (others != entry) {
                        if (others.getKey() < entry.getValue() &&
                                others.getValue() > entry.getKey()) {
                            isImpossible = true;
                            break;
                        }
                    }
                }
                if (isImpossible) {
                    scheduledResult = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ":" + " " + scheduledResult);

        }
    }
}