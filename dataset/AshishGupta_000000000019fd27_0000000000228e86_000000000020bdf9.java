import java.lang.System;
import java.util.*;

public class Solution{
    private static String output1 = "Case #%d: %s";

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().getAnswer(caseNum, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnswer(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<Map.Entry<Map.Entry<Integer, Integer>, Integer>> course = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            course.add(new AbstractMap.SimpleEntry(new AbstractMap.SimpleEntry(start, end), i));
        }

        Collections.sort(course, new Comparator<Map.Entry<Map.Entry<Integer, Integer>, Integer>>() {
            @Override
            public int compare(Map.Entry<Map.Entry<Integer, Integer>, Integer> o1,
                    Map.Entry<Map.Entry<Integer, Integer>, Integer> o2) {
                return o1.getKey().getKey() - o2.getKey().getKey();
            }
        });
        int cend = 0;
        int jend = 0;
        char[] schedule = new char[n];
        boolean impossible = false;

        for (int i = 0; i < n; i++) {
            int start = course.get(i).getKey().getKey();
            int end = course.get(i).getKey().getValue();
            if (start >= cend) {
                cend = end;
                schedule[course.get(i).getValue()] = 'C';
            } else if (start >= jend) {
                jend = end;
                schedule[course.get(i).getValue()] = 'J';
            } else {
                impossible = true;
                break;
            }
        }

        String result;
        if (impossible) {
            result = "IMPOSSIBLE";
        } else {
            result = String.valueOf(schedule);
        }

        System.out.println(String.format(output1, caseNum, result));
    }

}