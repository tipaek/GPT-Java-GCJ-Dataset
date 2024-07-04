


import java.util.*;

class Solution {

    private static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
//            Map<Integer, Integer> conflictedMap = new HashMap<>();
//            Map<Integer, Integer> scheduleMap = new HashMap<>();
            List<Pair> scheduleList = new ArrayList<>();
            List<Pair> conflictedList = new ArrayList<>();

//            List<Pair<Integer, Integer>> conflictedList = new ArrayList<>();

            StringBuilder scheduledResult = new StringBuilder();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
//                scheduleMap.put(start, end);
                scheduleList.add(new Pair(start, end));
            }

            int size_e = 0;
            if (!scheduleList.isEmpty()) {
                for(int j=0; j<n; j++) {
                    scheduledResult.append("C");
                }
            }
            for (Pair entry : scheduleList) {

                int size_o = 0;
                for (Pair others : scheduleList) {
                    if (size_e > size_o) {
                        continue;
                    }
                    if (others != entry) {
                        if (others.first < entry.second &&
                                others.second > entry.first) {
                            conflictedList.add(new Pair(Math.max(entry.first, others.first), Math.min(others.second, entry.second)));
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

            for (Pair entry : conflictedList) {
                boolean isImpossible = false;
                for (Pair others : conflictedList) {
                    if (others != entry) {
                        if (others.first < entry.second &&
                                others.second > entry.first) {
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