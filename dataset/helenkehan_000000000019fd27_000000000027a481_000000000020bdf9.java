import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * Created by HelenHan on 3/6/20.
 */
public class Solution {


    public static String solve(int[][] activities) {
        if (activities == null || activities.length == 0) return "";
        int number = helper(activities);
        if (number > 2) {
            return "IMPOSSIBLE";
        } else if (number == 2) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
            char[] charMap = new char[activities.length];
            char J = 'J';
            char C = 'C';
            for (int[] activity : activities) {
                if (!pq.isEmpty() && pq.peek()[1] <= activity[0]) {
                    int[] temp = pq.poll();
                    if (!pq.isEmpty()) {
                        if (charMap[temp[2]]!=0) {
                            charMap[activity[2]] = charMap[temp[2]];
                        }
                    }
                }
                pq.add(activity);
                if (pq.size() == 2) {
                    int[] temp1 = pq.poll();
                    int[] temp2 = pq.poll();

                    if (charMap[temp1[2]]!=0 && charMap[temp2[2]]!=0) {
                        //perfect
                    } else if (charMap[temp1[2]]!=0 && charMap[temp2[2]]==0) {
                        char in = (charMap[temp1[2]] == C) ? J : C;
                        charMap[temp2[2]]=in;
                    } else if (charMap[temp1[2]]==0 && charMap[temp2[2]]!=0) {
                        char in = (charMap[temp2[2]] == C) ? J : C;
                        charMap[temp1[2]]=in;
                    } else {
                        charMap[temp1[2]]=J;
                        charMap[temp2[2]]=C;
                    }

                    pq.add(temp1);
                    pq.add(temp2);
                }
            }
            for (int i = 0; i < activities.length; i++) {
                if ( charMap[activities[i][2]]==0) {
                    charMap[activities[i][2]] = J;
                }
            }
            return String. valueOf(charMap);


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
            int[][] activity = new int[N][3];
            for (int i = 0; i < N; i++) {
                String[] input = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                activity[i][0] = Integer.parseInt(input[0]);
                activity[i][1] = Integer.parseInt(input[1]);
                activity[i][2] = i;
            }
            String answer = solve(activity);
            System.out.println("Case #" + j + ": " + answer);
        }

        bufferedReader.close();
    }
}
