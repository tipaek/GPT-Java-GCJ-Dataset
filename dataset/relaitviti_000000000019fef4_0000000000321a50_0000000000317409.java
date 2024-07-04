import java.util.*;
import java.lang.*;


public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Object> answers = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            int caseAnswer = 0;
            int pX = scanner.nextInt();
            int pY = scanner.nextInt();
            String direction = scanner.next();
//            System.out.println(direction.length() + " " + direction);
            Map<List<Integer>, List<Integer>> petMap = calculateTime(pX,pY,direction);
            int time = checkPossible(petMap, direction.length());
//            System.out.println(petMap + " " + time);
            if (time != -1) {
                answers.add(time);
            } else {
                answers.add(("IMPOSSIBLE"));
            }
        }

        for (int i = 0; i < n; i++) {
            int z = i + 1;
            System.out.println("Case #" + z + ": " + answers.get(i));
        }

        scanner.close();
    }

    public static Map<List<Integer>, List<Integer>> calculateTime(int x, int y, String S) {
        List<Integer> timeListBase = new ArrayList<>();
        int time = 0;
        Map<List<Integer>, List<Integer>> timeMap = new HashMap<>();
        List<Integer> intersectionsStart = new ArrayList<>();
        intersectionsStart.add(x);
        intersectionsStart.add(y);
        timeListBase.add(time);
        timeMap.put(intersectionsStart,timeListBase);
//        System.out.println(timeMap);
        for (int i =0 ; i < S.length(); i++) {
            List<Integer> intersections = new ArrayList<>();

            if (S.charAt(i) == 'N') y++;
            else if (S.charAt(i) == 'S') y--;
            else if (S.charAt(i) == 'E') x++;
            else if (S.charAt(i) == 'W') x--;
            intersections.add(x);
            intersections.add(y);
            time++;
            if (timeMap.containsKey(intersections)) {
                List temp = timeMap.get(intersections);
                temp.add(time);
                timeMap.put(intersections,temp);
            } else {
                List<Integer> timeList = new ArrayList<>();
                timeList.add(time);
                timeMap.put(intersections,timeList);
            }
//            timeMap.put(intersections,time);
//            System.out.println(timeMap);
        }
        return timeMap;
    }

    public static int checkPossible(Map<List<Integer>, List<Integer>> pathMap, int maxTime) {
        int result = Integer.MAX_VALUE;
        for (List<Integer> location : pathMap.keySet()) {
            int meTime = Math.abs(location.get(0)) + Math.abs(location.get(1));
            if (pathMap.get(location).get(pathMap.get(location).size() - 1) >= meTime ) {
                for (int i = 0; i < pathMap.get(location).size(); i++) {
                    if (pathMap.get(location).get(i) == meTime) {if (meTime < result) result = meTime;}
                    else if (pathMap.get(location).get(i) > meTime) {if (pathMap.get(location).get(i) < result) result = pathMap.get(location).get(i);};
                }
            }
        }
        if (result == Integer.MAX_VALUE) result = -1;
        return result;
    }

}

