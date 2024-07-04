import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        
        for (int i = 1; i <= T; i++) {
            int N = input.nextInt();
            int[][] schedule = new int[N][3];
            
            for (int j = 0; j < N; j++) {
                schedule[j][0] = input.nextInt();
                schedule[j][1] = input.nextInt();
                schedule[j][2] = j;
            }
            
            Arrays.sort(schedule, Comparator.comparingInt(a -> a[0]));
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            queue.add(new int[]{schedule[0][1], 1, schedule[0][2]});
            
            char[] res = new char[N];
            res[schedule[0][2]] = 'C';
            int id = 1;
            
            for (int k = 1; k < N; k++) {
                while (!queue.isEmpty() && schedule[k][0] >= queue.peek()[0]) {
                    queue.poll();
                }
                
                if (!queue.isEmpty()) {
                    id = queue.peek()[1] == 1 ? 0 : 1;
                }
                
                queue.offer(new int[]{schedule[k][1], id, schedule[k][2]});
                
                if (queue.size() > 2) break;
                
                res[schedule[k][2]] = id == 1 ? 'C' : 'J';
            }
            
            if (queue.size() > 2) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + new String(res));
            }
        }
        
        input.close();
    }
}