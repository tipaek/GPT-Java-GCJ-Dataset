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
            boolean isPossible = true;
            List<Integer> cList = new ArrayList<>();
            List<Integer> jList = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                startTimes[i] = Integer.parseInt(st.nextToken());
                endTimes[i] = Integer.parseInt(st.nextToken());

                boolean canAssignToC = true;
                boolean canAssignToJ = true;

                for (int k : cList) {
                    if ((startTimes[i] >= startTimes[k] && startTimes[i] < endTimes[k]) || 
                        (endTimes[i] > startTimes[k] && endTimes[i] <= endTimes[k])) {
                        canAssignToC = false;
                        break;
                    }
                }

                if (canAssignToC) {
                    cList.add(i);
                    result.append("C");
                } else {
                    for (int k : jList) {
                        if ((startTimes[i] >= startTimes[k] && startTimes[i] < endTimes[k]) || 
                            (endTimes[i] > startTimes[k] && endTimes[i] <= endTimes[k])) {
                            canAssignToJ = false;
                            break;
                        }
                    }

                    if (canAssignToJ) {
                        jList.add(i);
                        result.append("J");
                    } else {
                        isPossible = false;
                    }
                }
            }

            System.out.println("Case #" + z + ": " + (isPossible ? result : "IMPOSSIBLE"));
        }
        br.close();
    }
}