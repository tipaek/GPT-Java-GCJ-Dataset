import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= testCases; i++) {
            int numberOfActivities = Integer.parseInt(in.nextLine());
            ArrayList<int[]> activities = new ArrayList<>();
            for (int j = 0; j < numberOfActivities; j++) {
                String line = in.nextLine();
                String[] tmp = line.split("\\s+");
                int[] a = new int[2];
                a[0] = Integer.parseInt(tmp[0]);
                a[1] = Integer.parseInt(tmp[1]);
                activities.add(a);
            }
            activities.sort((o1, o2) -> {
                if (o1[0] < o2[0]) {
                    return -1;
                } else if (o1[0] == o2[0]) {
                    return 0;
                } else {
                    return 1;
                }
            });

            String output = "C";
            while (true) {
                int[] currentActivity = activities.get(output.length() - 1);
                int[] nextActivity = activities.get(output.length());
                if (currentActivity[1] <= nextActivity[0]) {
                    output += output.charAt(output.length() - 1);
                } else {
                    if (output.charAt(output.length() - 1) == 'C') {
                        int index = output.lastIndexOf('J');
                        if (index == -1) {
                            output += "J";
                        } else {
                            int[] lastActivity = activities.get(index);
                            if (lastActivity[1] <= nextActivity[0]) {
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
                            int[] lastActivity = activities.get(index);
                            if (lastActivity[1] <= nextActivity[0]) {
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