import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    private static class Node {
        boolean isStart;
        int time;
        int id;

        Node(boolean isStartInp, int timeInp, int idInp) {
            isStart = isStartInp;
            time = timeInp;
            id = idInp;
        }
    }

    public static void main(String[] args) {
        // Scanner has functions to read ints, longs, strings, chars, etc.
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int caseNum = Integer.valueOf(input.nextLine());
        for(int i = 1; i <= caseNum; i ++) {
            int activityNum = Integer.valueOf(input.nextLine());
            List<Node> activities = new ArrayList();

            for(int j = 0; j <  activityNum; j ++) {
                String[] times = input.nextLine().split(" ");
                activities.add(new Node(true, Integer.valueOf(times[0]), j));
                activities.add(new Node(false, Integer.valueOf(times[1]), j));
            }

            String result = solve(activities);
            out.println("Case #" + i + ": " + result);
        }
    }

    private static String solve(List<Node> activities) {
        char[] result = new char[activities.size()/2];
        Collections.sort(activities, (o1, o2) -> {
            if(o1.time != o2.time) {
                return o1.time - o2.time;
            } else {
                return o1.isStart ? 1 : -1;
            }
        });

        Map<Integer, Character> openPs = new HashMap<>();

        for(int i = 0; i < activities.size(); i ++) {
            Node current = activities.get(i);
            if(current.isStart) {
                if(openPs.size() == 2) {
                    return "IMPOSSIBLE";
                }
                Character candidate = 'C';
                if(!openPs.isEmpty()) {
                    for(Character c : openPs.values()) {
                        candidate = c == 'C' ? 'J' : 'C';
                    }
                }
                result[current.id] = candidate;
                openPs.put(current.id, candidate);
            } else {
                openPs.remove(current.id);
            }
        }

        return new String(result);
    }
}
