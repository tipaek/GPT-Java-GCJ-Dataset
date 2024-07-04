import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;


/**
 * Created by HelenHan on 3/6/20.
 */
public class Solution {


    public static String solve(int[][] activities) {
        if (activities == null || activities.length == 0) return "";
        int[][] orginal = new int[activities.length][activities[0].length];
        System.arraycopy(activities, 0, orginal, 0, activities.length);
        int number = helper(activities);
        if (number > 2) {
            return "IMPOSSIBLE";
        } else if (number == 2) {
            Arrays.sort(activities, (a, b) -> (a[0] - b[0])); //minHeap
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
            HashMap<String, Character> map = new HashMap<>();

            char J = 'J';
            char C = 'C';
            for (int[] activity : activities) {
                if (!pq.isEmpty() && pq.peek()[1] <= activity[0]) {
                    int[] temp = pq.poll();
                    if (!pq.isEmpty()) {
                        String key1 = temp[0] + "," + temp[1];
                        String key2 = activity[0] + "," + activity[1];
                        if (map.containsKey(key1)) {
                            map.put(key2, map.get(key1));
                        }
                    }
                }
                pq.add(activity);
                if (pq.size() == 2) {
                    int[] temp1 = pq.poll();
                    int[] temp2 = pq.poll();

                    String key1 = temp1[0] + "," + temp1[1];
                    String key2 = temp2[0] + "," + temp2[1];
                    if (map.containsKey(key1) && map.containsKey(key2)) {
                        //perfect
                    } else if (map.containsKey(key1) && !map.containsKey(key2)) {
                        char in = (map.get(key1) == C) ? J : C;
                        map.put(key2, in);
                    } else if (!map.containsKey(key1) && map.containsKey(key2)) {
                        char in = (map.get(key2) == C) ? J : C;
                        map.put(key1, in);
                    } else {
                        map.put(key1, J);
                        map.put(key2, C);
                    }

                    pq.add(temp1);
                    pq.add(temp2);
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < orginal.length; i++) {
                String key = orginal[i][0] + "," + orginal[i][1];
                if (map.containsKey(key)) {
                    sb.append(map.get(key));
                } else {
                    sb.append(J);
                }
            }
            return sb.toString();


        } else if (number == 1) {//number <=1
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < activities.length; i++) {
                sb.append('C');
            }
            return sb.toString();
        } else {
            return "";
        }
    }


    public static int helper(int[][] activities) {
        Arrays.sort(activities, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for (int[] activity : activities) {
            if (!pq.isEmpty() && pq.peek()[1] <= activity[0]) {
                pq.poll();
            }
            pq.add(activity);
        }
        return pq.size();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int T = Integer.parseInt(t[0]);

        for (int j = 1; j <= T; j++) {
            String[] n = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int N = Integer.parseInt(n[0]);
            int[][] activity = new int[N][2];
            for (int i = 0; i < N; i++) {
                String[] input = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                activity[i][0] = Integer.parseInt(input[0]);
                activity[i][1] = Integer.parseInt(input[1]);
            }
            String answer = solve(activity);
            System.out.println("Case #" + j + ": " + answer);
        }

        bufferedReader.close();
    }
}
