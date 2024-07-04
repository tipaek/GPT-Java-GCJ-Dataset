import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.readLine());
            int[][] events = new int[N][3];
            int[] eventTimes = new int[N * 2];
            int[] assignments = new int[N];
            
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                events[j][0] = Integer.parseInt(st.nextToken());
                events[j][1] = Integer.parseInt(st.nextToken());
                events[j][2] = j;
                
                eventTimes[j * 2] = events[j][0];
                eventTimes[j * 2 + 1] = events[j][1];
            }
            
            Arrays.sort(eventTimes);
            Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
            
            int jShiftEnds = -1;
            int cShiftEnds = -1;
            boolean impossible = false;
            int nextEvent = 0;
            
            for (int time : eventTimes) {
                if (cShiftEnds == time) {
                    cShiftEnds = -1;
                } else if (jShiftEnds == time) {
                    jShiftEnds = -1;
                } else {
                    if (cShiftEnds == -1) {
                        cShiftEnds = events[nextEvent][1];
                        assignments[events[nextEvent][2]] = 1;
                    } else if (jShiftEnds == -1) {
                        jShiftEnds = events[nextEvent][1];
                        assignments[events[nextEvent][2]] = 2;
                    } else {
                        impossible = true;
                        break;
                    }
                    nextEvent++;
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                StringBuilder answer = new StringBuilder();
                for (int assignment : assignments) {
                    answer.append(assignment == 1 ? 'C' : 'J');
                }
                System.out.println("Case #" + (i + 1) + ": " + answer);
            }
        }
        
        reader.close();
    }
}