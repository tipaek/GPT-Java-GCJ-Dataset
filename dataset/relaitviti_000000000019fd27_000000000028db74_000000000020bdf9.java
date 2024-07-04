import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<String> answer = new ArrayList<>();
        while (n > 0) {
            Map<Integer, List<Integer>> timeMap = new HashMap<>();
            List<Integer> startTimes = new ArrayList<>();
            List<String> order = new ArrayList<>();
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int start = sc.nextInt();
                startTimes.add(start);
                int end = sc.nextInt();
                order.add(start + "_" + end);
                if (timeMap.containsKey(start)) {
                    timeMap.get(start).add(end);
                    Collections.sort(timeMap.get(start));
                } else {
                    List<Integer> sameStartTime = new ArrayList<>();
                    sameStartTime.add(end);
                    timeMap.put(start,sameStartTime);
                }
            }
            Collections.sort(startTimes);
            answer.add(calculate(m,timeMap,startTimes, order));
            n--;
        }
        for (int i = 0 ; i < answer.size(); i++) {
            int j = i+1;
            System.out.println("Case #" + j + ": " + answer.get(i));
        }
    }

    public static String calculate(int length, Map<Integer, List<Integer>> timeMap, List<Integer> startTimes, List<String> order) {
//        System.out.println(arr[0][0]+ " " +arr[0][1]);
        StringBuilder result = new StringBuilder();
        // System.out.println(timeMap + " " + startTimes);
        int[] cameron = new int[2];
        int[] james = new int[2];
        Map<String, Character> doneMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            // System.out.println(cameron[0] + " " + cameron[1]);
            if (cameron[1] <= startTimes.get(i)) {
                cameron[0] = startTimes.get(i);
                cameron[1] = timeMap.get(startTimes.get(i)).get(0);
                timeMap.get(startTimes.get(i)).remove(0);
                doneMap.put(cameron[0] + "_" + cameron[1], 'C');
            } else if (james[1] <= startTimes.get(i)){
                james[0] = startTimes.get(i);
                james[1] = timeMap.get(startTimes.get(i)).get(0);
                timeMap.get(startTimes.get(i)).remove(0);
                doneMap.put(james[0] + "_" + james[1], 'J');
            } else {
                return  "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < length; i++) {
            result.append(doneMap.get(order.get(i)));
        }

        return  result.toString();
    }
}
