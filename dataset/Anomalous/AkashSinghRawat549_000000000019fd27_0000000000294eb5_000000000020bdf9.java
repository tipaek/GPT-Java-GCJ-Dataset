import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        ArrayList<String> result = new ArrayList<>();
        Solution sol = new Solution();

        for (int i = 0; i < cases; i++) {
            String output = "";

            int taskCount = sc.nextInt();
            int[][] tasks = new int[taskCount][2];

            for (int j = 0; j < taskCount; j++) {
                tasks[j][0] = sc.nextInt();
                tasks[j][1] = sc.nextInt();
            }

            HashMap<Integer, String> map = new HashMap<>();
            for (int k = 0; k < taskCount; k++) {
                map.put(k, "C");
            }

            int min = tasks[0][0];
            int key = 0;
            for (int j = 1; j < taskCount; j++) {
                if (min > tasks[j][0]) {
                    min = tasks[j][0];
                    key = j;
                }
            }

            boolean impossible = false;

            for (int j = 1; j < taskCount; j++) {
                int[] currentTask = tasks[j];
                for (int k = 0; k < j; k++) {
                    int[] previousTask = tasks[k];
                    if (sol.isOverlap(currentTask, previousTask) && map.get(k).equals(map.get(j)) && !impossible) {
                        map.put(j, sol.switchRole(map.get(j)));
                        for (int l = 0; l < j; l++) {
                            int[] earlierTask = tasks[l];
                            if (sol.isOverlap(earlierTask, currentTask) && map.get(j).equals(map.get(l)) && !impossible) {
                                impossible = true;
                                map.put(0, "IMPOSSIBLE");
                            }
                        }
                    }
                }
            }

            if (!map.get(key).equals("IMPOSSIBLE")) {
                if (map.get(key).equals("J")) {
                    for (int j = 0; j < taskCount; j++) {
                        map.put(j, sol.switchRole(map.get(j)));
                    }
                }
            }

            for (int k = 0; k < taskCount; k++) {
                if (!map.get(0).equals("IMPOSSIBLE")) {
                    output += map.get(k);
                } else {
                    output += map.get(0);
                    break;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + output);
        }
        sc.close();
    }

    public String switchRole(String role) {
        return role.equals("C") ? "J" : "C";
    }

    public boolean isOverlap(int[] a, int[] b) {
        return !(a[1] <= b[0] || b[1] <= a[0]);
    }
}