import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numberOfIntervals = scanner.nextInt();
            String result = "";

            TreeMap<Integer, Integer> intervals1 = new TreeMap<>();
            TreeMap<Integer, Integer> intervals2 = new TreeMap<>();

            for (int i = 0; i < numberOfIntervals; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (!intervals1.containsKey(start)) {
                    intervals1.put(start, end);
                } else if (!intervals2.containsKey(start)) {
                    intervals2.put(start, end);
                } else {
                    result = "IMPOSSIBLE";
                }
            }

            Map<Integer, Integer> jIntervals = new HashMap<>();
            Map<Integer, Integer> cIntervals = new HashMap<>();

            while (!result.equals("IMPOSSIBLE") && (!intervals1.isEmpty() || !intervals2.isEmpty())) {
                int start, end;

                if (intervals1.isEmpty()) {
                    start = intervals2.firstKey();
                    end = intervals2.remove(start);
                } else if (intervals2.isEmpty()) {
                    start = intervals1.firstKey();
                    end = intervals1.remove(start);
                } else if (intervals1.firstKey() <= intervals2.firstKey()) {
                    start = intervals1.firstKey();
                    end = intervals1.remove(start);
                } else {
                    start = intervals2.firstKey();
                    end = intervals2.remove(start);
                }

                boolean conflictWithJ = false;
                for (Map.Entry<Integer, Integer> entry : jIntervals.entrySet()) {
                    int jStart = entry.getKey();
                    int jEnd = entry.getValue();
                    if ((start < jEnd && end > jStart) || start == jStart) {
                        conflictWithJ = true;
                        break;
                    }
                }

                if (!conflictWithJ) {
                    jIntervals.put(start, end);
                    result += "C";
                } else {
                    boolean conflictWithC = false;
                    for (Map.Entry<Integer, Integer> entry : cIntervals.entrySet()) {
                        int cStart = entry.getKey();
                        int cEnd = entry.getValue();
                        if ((start < cEnd && end > cStart) || start == cStart) {
                            conflictWithC = true;
                            break;
                        }
                    }

                    if (!conflictWithC) {
                        cIntervals.put(start, end);
                        result += "J";
                    } else {
                        result = "IMPOSSIBLE";
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }

        scanner.close();
    }
}