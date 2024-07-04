import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int t = 0; t < cases; t++) {
            int activites = in.nextInt();
            ArrayList<ArrayList<Integer>> schedule = new ArrayList<>();
            for (int activity = 0; activity < activites; activity++) {

                ArrayList<Integer> aux = new ArrayList<>();
                aux.add(in.nextInt());
                aux.add(in.nextInt());
                aux.add(activity);
                schedule.add(aux);
            }
            schedule.sort((a, b) -> a.get(0) - b.get(0));
            schedule.get(0).add((int) 'C');
            int C_finish = schedule.get(0).get(1);
            int J_finish = 0;
            boolean impossible = false;
            for (int activity = 1; activity < activites && !impossible; activity++) {
                int startTime = schedule.get(activity).get(0);
                if (startTime < C_finish) {
                    if (startTime < J_finish) {
                        impossible = true;
                    } else {
                        schedule.get(activity).add((int) 'J');
                        J_finish = schedule.get(activity).get(1);
                    }
                } else {
                    schedule.get(activity).add((int) 'C');
                    C_finish = schedule.get(activity).get(1);
                }
            }
            if (impossible) {
                System.out.println("Case #" + (t+1) + ": IMPOSSIBLE");
            } else {
                schedule.sort((a, b) -> a.get(2) - b.get(2));
                StringBuilder answer = new StringBuilder();
                for (int activity = 0; activity < activites; activity++) {
                    answer.append((char)((int)schedule.get(activity).get(3)));
                }
                System.out.println("Case #" + (t+1) + ": " + answer);
            }
        }
    }
}