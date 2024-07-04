import java.util.*;

public class Solution {
    
    public static boolean overlaps(int[] a, int[] b) {
        return Math.max(a[0], b[0]) < Math.min(a[1], b[1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = in.nextInt();
            int[] schedule = new int[n];
            boolean impossible = false;
            List<int[]> intervals = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int[] interval = new int[3];
                interval[0] = in.nextInt();
                interval[1] = in.nextInt();
                interval[2] = i;
                intervals.add(interval);
            }
            
            intervals.sort((a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(b[1], a[1]);
            });
            
            TreeSet<Integer> availableLabels = new TreeSet<>(Arrays.asList(0, 1));
            for (int i = 0; i < n; i++) {
                int[] current = intervals.get(i);
                availableLabels.clear();
                availableLabels.add(0);
                availableLabels.add(1);
                
                for (int j = 0; j < i; j++) {
                    int[] previous = intervals.get(j);
                    if (overlaps(current, previous)) {
                        availableLabels.remove(schedule[previous[2]]);
                    }
                }
                
                if (availableLabels.isEmpty()) {
                    impossible = true;
                    break;
                }
                
                schedule[current[2]] = availableLabels.first();
            }
            
            System.out.print("Case #" + (t + 1) + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    System.out.print(schedule[i] == 0 ? "C" : "J");
                }
                System.out.println();
            }
        }
        
        in.close();
    }
}