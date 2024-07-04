import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int z = 1; z <= t; z++) {
            int n = Integer.parseInt(br.readLine());
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            ArrayList<Integer> cTasks = new ArrayList<>();
            ArrayList<Integer> jTasks = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                startTimes[i] = Integer.parseInt(st.nextToken());
                endTimes[i] = Integer.parseInt(st.nextToken());

                boolean canAssignToC = true;
                for (int k : cTasks) {
                    if ((startTimes[i] < endTimes[k] && endTimes[i] > startTimes[k])) {
                        canAssignToC = false;
                        break;
                    }
                }

                if (canAssignToC) {
                    cTasks.add(i);
                    result.append("C");
                } else {
                    boolean canAssignToJ = true;
                    for (int k : jTasks) {
                        if ((startTimes[i] < endTimes[k] && endTimes[i] > startTimes[k])) {
                            canAssignToJ = false;
                            break;
                        }
                    }

                    if (canAssignToJ) {
                        jTasks.add(i);
                        result.append("J");
                    } else {
                        result.setLength(0);
                        result.append("IMPOSSIBLE");
                        break;
                    }
                }
            }
            System.out.println("Case #" + z + ": " + result);
        }
        br.close();
    }
}