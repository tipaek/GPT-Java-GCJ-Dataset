import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        
        for (int i = 1; i <= T; i++) {
            int N = scan.nextInt();
            boolean isPossible = true;
            answer.append("Case #").append(i).append(":");
            
            ArrayList<Integer> cSchedule = new ArrayList<>();
            ArrayList<Integer> jSchedule = new ArrayList<>();
            Queue<Character> schedule = new LinkedList<>();
            
            for (int x = 1; x <= N; x++) {
                int Si = scan.nextInt();
                int Ei = scan.nextInt();
                
                if (canSchedule(cSchedule, Si, Ei)) {
                    cSchedule.add(Si);
                    cSchedule.add(Ei);
                    schedule.add('C');
                } else if (canSchedule(jSchedule, Si, Ei)) {
                    jSchedule.add(Si);
                    jSchedule.add(Ei);
                    schedule.add('J');
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                while (!schedule.isEmpty()) {
                    answer.append(schedule.remove());
                }
            } else {
                answer.append("IMPOSSIBLE");
            }
            answer.append("\n");
        }
        
        System.out.println(answer);
        scan.close();
    }

    public static boolean canSchedule(ArrayList<Integer> schedule, int start, int end) {
        for (int i = 0; i < schedule.size(); i += 2) {
            int scheduledStart = schedule.get(i);
            int scheduledEnd = schedule.get(i + 1);
            
            if (start < scheduledEnd && end > scheduledStart) {
                return false;
            }
        }
        return true;
    }
}