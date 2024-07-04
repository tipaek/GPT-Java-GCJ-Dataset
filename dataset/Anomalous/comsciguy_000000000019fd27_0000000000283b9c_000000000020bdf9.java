import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        for (int tci = 0; tci < tc; tci++) {
            int n = Integer.parseInt(br.readLine());
            List<Pair> list = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new Pair(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            
            list.sort(Comparator.comparingInt(p -> p.start));
            
            boolean[] occupiedC = new boolean[24 * 60];
            boolean[] occupiedJ = new boolean[24 * 60];
            char[] solution = new char[n];
            boolean impossible = false;
            
            for (Pair pair : list) {
                if (canSchedule(occupiedC, pair.start, pair.end)) {
                    fillSchedule(occupiedC, pair.start, pair.end);
                    solution[pair.index] = 'C';
                } else if (canSchedule(occupiedJ, pair.start, pair.end)) {
                    fillSchedule(occupiedJ, pair.start, pair.end);
                    solution[pair.index] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", tci + 1);
            } else {
                System.out.printf("Case #%d: %s\n", tci + 1, new String(solution));
            }
        }
        br.close();
    }
    
    private static boolean canSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }
    
    private static void fillSchedule(boolean[] schedule, int start, int end) {
        Arrays.fill(schedule, start, end, true);
    }
}

class Pair {
    int index;
    int start;
    int end;
    
    public Pair(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }
}