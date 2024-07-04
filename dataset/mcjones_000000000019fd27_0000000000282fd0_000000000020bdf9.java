import javafx.util.Pair;
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(in.nextLine());
        for (int i = 0; i < testCases; i++) {
            int numberOfActivities = Integer.parseInt(in.nextLine());
            ArrayList<Pair<Integer, Integer>> activities = new ArrayList<>();
            for (int j = 0; j < numberOfActivities; j++) {
                String line = in.nextLine();
                String[] tmp = line.split("\\s+");
                int start = Integer.parseInt(tmp[0]);
                int end = Integer.parseInt(tmp[1]);
                Pair<Integer, Integer> p = new Pair<>(start, end);
                activities.add(p);
            }
            activities.sort((o1, o2) -> {
                if (o1.getKey() < o2.getKey()) {
                    return -1;
                } else if (o1.getKey().equals(o2.getKey())) {
                    return 0;
                } else {
                    return 1;
                }
            });
            String output = "C";
            while (true) {
                Pair<Integer, Integer> currentActivity = activities.get(output.length() - 1);
                Pair<Integer, Integer> nextActivity = activities.get(output.length());
                if (currentActivity.getValue() <= nextActivity.getKey()) {
                    output += output.charAt(output.length() - 1);
                } else {
                    if (output.charAt(output.length() - 1) == 'C') {
                        int index = output.lastIndexOf('J');
                        if (index == -1) {
                            output += "J";
                        } else {
                            Pair<Integer, Integer> lastActivity = activities.get(index);
                            if (lastActivity.getValue() <= nextActivity.getKey()) {
                                output += "J";
                            } else {
                                output = "IMPOSSIBLE";
                                break;
                            }
                        }
                    } else {
                        int index = output.lastIndexOf('C');
                        if (index == -1) {
                            output += "C";
                        } else {
                            Pair<Integer, Integer> lastActivity = activities.get(index);
                            if (lastActivity.getValue() <= nextActivity.getKey()) {
                                output += "C";
                            } else {
                                output = "IMPOSSIBLE";
                                break;
                            }
                        }
                    }
                }
                if (output.length() == numberOfActivities) {
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + output);
        }
    }
}