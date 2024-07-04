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
//            System.out.println(order);
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
//        System.out.println(timeMap + " " + startTimes);
        int[] cameron = new int[2];
        int[] james = new int[2];
        String[] res = new String[startTimes.size()];
//        System.out.println(res[0]  + " " + res[1] + " " +res[2] + res[3]);
        Map<String, Character> doneMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (cameron[1] <= startTimes.get(i)) {
                cameron[0] = startTimes.get(i);
                cameron[1] = timeMap.get(startTimes.get(i)).get(0);
                timeMap.get(startTimes.get(i)).remove(0);
                for(int j = 0; j < res.length; j++) {
                    if (res[j] == null && order.get(j).equals(cameron[0] + "_" + cameron[1])) {
                        res[j] = "C";
                        break;
                    }
                }
            } else if (james[1] <= startTimes.get(i)){
                james[0] = startTimes.get(i);
                james[1] = timeMap.get(startTimes.get(i)).get(0);
                timeMap.get(startTimes.get(i)).remove(0);
                for(int j = 0; j < res.length; j++) {
                    if (res[j] == null && order.get(j).equals( james[0] + "_" + james[1])) {
                        res[j] = "J";
                        break;
                    }
                }
            } else {
                return  "IMPOSSIBLE";
            }
        }
//        System.out.println(res[0]  + " " + res[1] + " " +res[2] + res[3]);
        for (int i = 0; i < length; i++) {
            result.append(res[i]);
        }

        return  result.toString();
    }
}
