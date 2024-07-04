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
            
            int cEnd = 0, jEnd = 0;
            Map<Integer, Character> assignment = new HashMap<>();
            boolean impossible = false;
            
            for (int[] task : tasks) {
                int start = task[0], end = task[1], index = task[2];
                
                if (start >= cEnd) {
                    assignment.put(index, 'C');
                    cEnd = end;
                } else if (start >= jEnd) {
                    assignment.put(index, 'J');
                    jEnd = end;
                } else {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    result.append(assignment.get(i));
                }
                System.out.println("Case #" + (t + 1) + ": " + result.toString());
            }
        }
        
        sc.close();
    }
}