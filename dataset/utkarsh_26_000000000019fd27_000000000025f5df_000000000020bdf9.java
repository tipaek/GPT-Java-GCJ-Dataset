import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    
    
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = sc.nextInt();
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int n = sc.nextInt();
            int[][] events = new int[n][3];
            int[][] orderedArr = new int[n][3];
            String ans = "";
            for (int i = 0; i < n; i++) {
                int[] event = new int[3];
                for (int j = 0; j < 2; j++) {
                    event[j] = sc.nextInt();
                }
                events[i] = event;
                orderedArr[i] = event;
            }
            Arrays.sort(events, new ArrComparator());
            int[] c = null;
            int[] j = null;
            for (int[] event : events) {
                if (c == null) {
                    event[2] = 1;
                    c = event;
                } else {
                    int startOfCurrentEvent = event[0];
                    int endOfPrevEventAssignedToC = c[1];
                    if (startOfCurrentEvent < endOfPrevEventAssignedToC) {
                        if (j == null) {
                            j = event;
                            event[2] = 2;
                        } else {
                            int endOfPrevEventAssignedToJ = j[1];
                            if (startOfCurrentEvent < endOfPrevEventAssignedToJ) {
                                ans = IMPOSSIBLE;
                                break;
                            } else {
                                j = event;
                                event[2] = 2;
                            }
                        }
                    } else {
                        c = event;
                        event[2] = 1;
                    }
                }
            }
            if (!ans.equals(IMPOSSIBLE)) {
                for (int[] event : orderedArr) {
                    if(event[2]==1){
                        ans += "C";
                    }else if(event[2]==2){
                        ans += "J";
                    }else {
                        ans += "ERR";
                    }
                }
            }
            System.out.println("Case #" + testCase + ": " + ans);
        }
        sc.close();
    }
}

class ArrComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
            return Integer.compare(o1[1], o2[1]);
        }
        return Integer.compare(o1[0], o2[0]);
    }
}

