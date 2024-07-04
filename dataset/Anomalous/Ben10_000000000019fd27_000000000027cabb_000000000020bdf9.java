import java.util.*;

public class Solution {
    static class Pair {
        int x, y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            Pair[] intervals = new Pair[n];
            
            for (int i = 0; i < n; i++) {
                intervals[i] = new Pair(sc.nextInt(), sc.nextInt());
            }
            
            Arrays.sort(intervals, new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    if (p1.x == p2.x) {
                        return p1.y - p2.y;
                    }
                    return p1.x - p2.x;
                }
            });
            
            StringBuilder schedule = new StringBuilder();
            schedule.append("J").append("C");
            
            Pair cameron = intervals[0];
            Pair jamie = intervals[1];
            boolean possible = true;
            
            for (int i = 2; i < n; i++) {
                if (intervals[i].x >= cameron.y) {
                    if (cameron.y < jamie.y) {
                        cameron = intervals[i];
                        schedule.append("J");
                    } else {
                        jamie = intervals[i];
                        schedule.append("C");
                    }
                } else if (intervals[i].x >= jamie.y) {
                    if (jamie.y < cameron.y) {
                        jamie = intervals[i];
                        schedule.append("C");
                    } else {
                        cameron = intervals[i];
                        schedule.append("J");
                    }
                } else {
                    possible = false;
                    break;
                }
            }
            
            String result = possible ? schedule.toString() : "IMPOSSIBLE";
            System.out.println("Case #" + t + ": " + result);
        }
        
        sc.close();
    }
}