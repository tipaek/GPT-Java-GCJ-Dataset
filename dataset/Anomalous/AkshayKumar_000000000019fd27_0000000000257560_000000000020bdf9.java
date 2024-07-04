import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            Pair[] times = new Pair[n];
            
            for (int i = 0; i < n; i++) {
                times[i] = new Pair(sc.nextInt(), sc.nextInt(), i);
            }
            
            Arrays.sort(times, Comparator.comparingInt(p -> p.start));
            
            char[] result = new char[n];
            result[times[0].index] = 'C';
            int currentMaxC = times[0].end;
            int currentMaxJ = 0;
            boolean isImpossible = false;
            
            for (int i = 1; i < times.length; i++) {
                if (currentMaxC <= times[i].start) {
                    result[times[i].index] = 'C';
                    currentMaxC = times[i].end;
                } else if (currentMaxJ <= times[i].start) {
                    result[times[i].index] = 'J';
                    currentMaxJ = times[i].end;
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + k + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + k + ": " + new String(result));
            }
        }
        sc.close();
    }
}

class Pair {
    int start;
    int end;
    int index;

    public Pair(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}