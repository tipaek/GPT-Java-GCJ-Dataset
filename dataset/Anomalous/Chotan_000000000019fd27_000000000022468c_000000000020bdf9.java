import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] activities = new int[N][3];
            
            for (int i = 0; i < N; i++) {
                activities[i][0] = sc.nextInt(); // start time
                activities[i][1] = sc.nextInt(); // end time
                activities[i][2] = i; // original index
            }
            
            Arrays.sort(activities, (a, b) -> {
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });
            
            HashSet<Integer> cameronSet = new HashSet<>();
            int lastEndC = activities[0][1];
            cameronSet.add(activities[0][2]);
            
            for (int i = 1; i < N; i++) {
                if (lastEndC <= activities[i][0]) {
                    cameronSet.add(activities[i][2]);
                    lastEndC = activities[i][1];
                }
            }
            
            HashSet<Integer> jamieSet = new HashSet<>();
            int lastEndJ = -1;
            
            for (int i = 0; i < N; i++) {
                if (!cameronSet.contains(activities[i][2])) {
                    if (lastEndJ == -1 || lastEndJ <= activities[i][0]) {
                        jamieSet.add(activities[i][2]);
                        lastEndJ = activities[i][1];
                    }
                }
            }
            
            if (cameronSet.size() + jamieSet.size() == N) {
                StringBuilder schedule = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    if (cameronSet.contains(i)) {
                        schedule.append('C');
                    } else {
                        schedule.append('J');
                    }
                }
                System.out.println("Case #" + t + ": " + schedule.toString());
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}