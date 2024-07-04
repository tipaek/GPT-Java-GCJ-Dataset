import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            List<int[]> tasks = new ArrayList<>();
            
            for (int n = 0; n < N; n++) {
                tasks.add(new int[]{sc.nextInt(), sc.nextInt(), n});
            }

            tasks.sort(Comparator.comparingInt(a -> a[0]));

            int endC = 0, endJ = 0;
            Map<Integer, Character> assignments = new HashMap<>();
            boolean possible = true;

            for (int[] task : tasks) {
                if (task[0] >= endC) {
                    assignments.put(task[2], 'C');
                    endC = task[1];
                } else if (task[0] >= endJ) {
                    assignments.put(task[2], 'J');
                    endJ = task[1];
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    result.append(assignments.get(i));
                }
                System.out.println("Case #" + (t + 1) + ": " + result);
            }
        }
    }
}