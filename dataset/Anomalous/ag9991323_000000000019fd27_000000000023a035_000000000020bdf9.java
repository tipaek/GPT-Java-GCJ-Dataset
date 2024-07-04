import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ParentingCodejam {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Integer[][] intervals = new Integer[N][2];
            int[] cSchedule = new int[1441];
            int[] jSchedule = new int[1441];
            
            for (int i = 0; i < N; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                intervals[i][0] = Integer.parseInt(token.nextToken());
                intervals[i][1] = Integer.parseInt(token.nextToken());
            }

            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();
            
            outerLoop:
            for (int i = 0; i < N; i++) {
                int startTime = intervals[i][0];
                int endTime = intervals[i][1];
                boolean cFree = true;
                boolean jFree = true;

                for (int k = startTime; k < endTime; k++) {
                    if (cSchedule[k] != 0) {
                        cFree = false;
                        break;
                    }
                }

                if (cFree) {
                    for (int k = startTime; k < endTime; k++) {
                        cSchedule[k] = 1;
                    }
                    schedule.append('C');
                } else {
                    for (int k = startTime; k < endTime; k++) {
                        if (jSchedule[k] != 0) {
                            jFree = false;
                            isImpossible = true;
                            break outerLoop;
                        }
                    }
                    if (jFree) {
                        for (int k = startTime; k < endTime; k++) {
                            jSchedule[k] = 1;
                        }
                        schedule.append('J');
                    }
                }
            }

            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(schedule);
            }
        }
    }
}