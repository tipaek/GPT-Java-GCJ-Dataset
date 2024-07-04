import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int k = 1; k <= t; k++) {
            int numTasks = sc.nextInt();
            int[] startTime = new int[numTasks];
            int[] originalStartTime = new int[numTasks];
            int[] endTime = new int[numTasks];
            
            Map<Integer, List<Integer>> taskMap = new HashMap<>();
            for (int i = 0; i < numTasks; i++) {
                startTime[i] = sc.nextInt();
                originalStartTime[i] = startTime[i];
                endTime[i] = sc.nextInt();
                
                taskMap.computeIfAbsent(startTime[i], k1 -> new ArrayList<>()).add(endTime[i]);
            }
            
            Arrays.sort(startTime);
            Arrays.sort(endTime);
            
            int freeJ = -1;
            int freeC = -1;
            
            int startIndex = 0;
            int endIndex = 0;
            
            StringBuilder schedule = new StringBuilder();
            boolean impossible = false;
            
            while (startIndex < numTasks || endIndex < numTasks) {
                if (startIndex < numTasks && startTime[startIndex] < endTime[endIndex]) {
                    if (freeJ == -1) {
                        schedule.append("J");
                        freeJ = startTime[startIndex];
                    } else if (freeC == -1) {
                        schedule.append("C");
                        freeC = startTime[startIndex];
                    } else {
                        impossible = true;
                        break;
                    }
                    startIndex++;
                } else {
                    if (freeJ != -1 && taskMap.get(freeJ).contains(endTime[endIndex])) {
                        freeJ = -1;
                    }
                    if (freeC != -1 && taskMap.get(freeC).contains(endTime[endIndex])) {
                        freeC = -1;
                    }
                    endIndex++;
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + k + ": IMPOSSIBLE");
            } else {
                Map<Integer, List<Character>> order = new HashMap<>();
                for (int i = 0; i < schedule.length(); i++) {
                    order.computeIfAbsent(startTime[i], k1 -> new ArrayList<>()).add(schedule.charAt(i));
                }
                
                StringBuilder finalSchedule = new StringBuilder();
                for (int time : originalStartTime) {
                    finalSchedule.append(order.get(time).remove(0));
                }
                
                System.out.println("Case #" + k + ": " + finalSchedule);
            }
        }
        sc.close();
    }
}