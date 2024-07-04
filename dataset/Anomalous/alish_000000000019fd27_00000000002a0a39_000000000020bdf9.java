import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        
        for (int i = 1; i <= cases; i++) {
            int activities = input.nextInt();
            StringBuilder result = new StringBuilder();
            LinkedList<int[]> cameron = new LinkedList<>();
            LinkedList<int[]> jamie = new LinkedList<>();
            
            cameron.add(new int[]{input.nextInt(), input.nextInt()});
            jamie.add(new int[]{input.nextInt(), input.nextInt()});
            result.append("CJ");
            
            boolean conflictCameron, conflictJamie;
            for (int j = 3; j <= activities; j++) {
                conflictCameron = conflictJamie = false;
                int start = input.nextInt(), finish = input.nextInt();
                
                conflictCameron = checkConflict(cameron, start, finish);
                if (conflictCameron) {
                    conflictJamie = checkConflict(jamie, start, finish);
                    if (conflictJamie) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    } else {
                        addActivity(jamie, start, finish);
                        result.append("J");
                    }
                } else {
                    addActivity(cameron, start, finish);
                    result.append("C");
                }
            }
            
            System.out.println("Case #" + i + ": " + result);
        }
        input.close();
    }

    private static boolean checkConflict(LinkedList<int[]> schedule, int start, int finish) {
        for (int[] interval : schedule) {
            if ((start >= interval[0] && start < interval[1]) || (finish > interval[0] && finish <= interval[1])) {
                return true;
            }
        }
        return false;
    }

    private static void addActivity(LinkedList<int[]> schedule, int start, int finish) {
        for (int i = 0; i < schedule.size(); i++) {
            int[] interval = schedule.get(i);
            if (finish <= interval[0]) {
                schedule.add(i, new int[]{start, finish});
                return;
            } else if (start >= interval[1] && (i == schedule.size() - 1 || finish <= schedule.get(i + 1)[0])) {
                schedule.add(i + 1, new int[]{start, finish});
                return;
            }
        }
    }
}