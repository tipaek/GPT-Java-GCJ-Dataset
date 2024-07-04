import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t=1; t <= T; t++) {
            int N = scanner.nextInt();
            int[] S = new int[N];
            int[] E = new int[N];
            int[] time = new int[24*60+1];
            int[][] type = new int[24*60+1][2];
            for (int i=0; i < 24*60+1; i++) {
                type[i][0] = -1;
                type[i][1] = -1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0; i < N; i++) {
                S[i] = scanner.nextInt();
                E[i] = scanner.nextInt();
                for (int j=S[i]; j < E[i];j++) {
                    time[j]++;
                    if (type[j][0] != -1) {
                        if (type[j][1] != -1) {
                            // IMPOSSIBLE
                        } else {
                            type[j][1] = i;
                        }
                    } else {
                        type[j][0] = i;
                    }
                }
            }
            int max = Arrays.stream(time).max().getAsInt();
            Map<Integer,String> map = new HashMap<>();
            if (max >2) {
                System.out.println("Case #"+t+": IMPOSSIBLE");
            } else {
                map.put(0,"C");
                for (int i=0; i < N; i++) {
                    // find all tasks
                    Set<Integer> taskIds = new HashSet<>();
                    for (int ti=S[i]; ti < E[i]; ti++) {
                        if (time[ti] > 1) {
                            taskIds.add(type[ti][1]);
                            taskIds.add(type[ti][0]);
                        }
                    }
                    taskIds.remove((Integer)i);
                    for (int taskId: taskIds) {
                        String other = map.get(taskId);
                        if (other != null) {
                            map.putIfAbsent(i,other.equals("C")?"J":"C");
                        }
                    }
                    String current = map.get(i);
                    if (current == null) {
                        current = "C";
                    }
                    for (int taskId: taskIds) {
                        map.putIfAbsent(taskId,current.equals("C")?"J":"C");
                    }
                }
                for (int i=0; i < N; i++) sb.append(map.get(i));
                System.out.println("Case #"+t+": "+sb.toString());
            }
        }
        
    }
}