import java.util.*;

public class Solution {

    public static void main(String[] args) {
        calculations();
    }

    public static void calculations() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[] startingTimes = new int[N];
            int[] endingTimes = new int[N];
            
            for (int j = 0; j < N; j++) {
                startingTimes[j] = scanner.nextInt();
                endingTimes[j] = scanner.nextInt();
            }
            
            ArrayList<Integer> cameronList = new ArrayList<>(Collections.nCopies(1001, 0));
            ArrayList<Integer> jamieList = new ArrayList<>(Collections.nCopies(1001, 0));
            StringBuilder parentsString = new StringBuilder();
            
            boolean impossible = false;
            
            for (int j = 0; j < N; j++) {
                boolean assigned = false;
                
                if (isAvailable(cameronList, startingTimes[j], endingTimes[j])) {
                    assignTime(cameronList, startingTimes[j], endingTimes[j]);
                    parentsString.append("C");
                    assigned = true;
                } else if (isAvailable(jamieList, startingTimes[j], endingTimes[j])) {
                    assignTime(jamieList, startingTimes[j], endingTimes[j]);
                    parentsString.append("J");
                    assigned = true;
                }
                
                if (!assigned) {
                    impossible = true;
                    break;
                }
            }
            
            int index = i + 1;
            if (impossible) {
                System.out.println("Case #" + index + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + index + ": " + parentsString.toString());
            }
        }
    }

    private static boolean isAvailable(ArrayList<Integer> schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule.get(i) == 1) {
                return false;
            }
        }
        return true;
    }

    private static void assignTime(ArrayList<Integer> schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule.set(i, 1);
        }
    }
}