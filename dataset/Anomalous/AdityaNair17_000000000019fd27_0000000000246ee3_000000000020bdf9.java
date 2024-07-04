import java.util.*;
import java.io.*;

public class Solution {
    
    public static boolean inRange(HashMap<Integer, Integer> map, int[] timeSlot) {
        if (map.isEmpty()) {
            return true;
        } else {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int start = entry.getKey();
                int end = entry.getValue();
                if (!(end <= timeSlot[0] || start >= timeSlot[1])) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = input.nextInt();

        for (int t = 1; t <= testCase; t++) {
            StringBuilder schedule = new StringBuilder();
            HashMap<Integer, Integer> J = new HashMap<>();
            HashMap<Integer, Integer> C = new HashMap<>();
            int N = input.nextInt();
            int[] timeSlot = new int[2];

            boolean possible = true;

            for (int n = 0; n < N; n++) {
                timeSlot[0] = input.nextInt();
                timeSlot[1] = input.nextInt();

                if (inRange(J, timeSlot)) {
                    J.put(timeSlot[0], timeSlot[1]);
                    schedule.append("J");
                } else if (inRange(C, timeSlot)) {
                    C.put(timeSlot[0], timeSlot[1]);
                    schedule.append("C");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                while (++n < N) {
                    input.nextInt(); // Consume remaining input
                    input.nextInt(); // Consume remaining input
                }
            }

            System.out.println("Case #" + t + ": " + schedule.toString());
        }
    }
}