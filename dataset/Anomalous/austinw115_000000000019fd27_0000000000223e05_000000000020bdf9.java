import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] intervals = new int[N][2];
            int[][] originalIntervals = new int[N][2];
            
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                intervals[j][0] = start;
                intervals[j][1] = end;
                originalIntervals[j][0] = start;
                originalIntervals[j][1] = end;
            }
            
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            intervals = reSort(intervals);
            
            StringBuilder result = new StringBuilder();
            char currentPerson = 'J';
            boolean possible = true;
            
            for (int j = 0; j < N; j++) {
                if (j > 0 && intervals[j][0] < intervals[j - 1][1]) {
                    if (currentPerson == 'J') {
                        currentPerson = 'C';
                    } else {
                        currentPerson = 'J';
                    }
                    if (j > 1 && intervals[j][0] < intervals[j - 2][1]) {
                        possible = false;
                        break;
                    }
                }
                result.append(currentPerson);
            }
            
            if (possible) {
                char[] answer = new char[N];
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if (originalIntervals[j][0] == intervals[k][0] && originalIntervals[j][1] == intervals[k][1]) {
                            answer[j] = result.charAt(k);
                            break;
                        }
                    }
                }
                pw.println("Case #" + i + ": " + new String(answer));
            } else {
                pw.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        pw.close();
    }

    public static int[][] reSort(int[][] intervals) {
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] == intervals[i - 1][0] && intervals[i - 1][1] > intervals[i][1]) {
                int temp = intervals[i][1];
                intervals[i][1] = intervals[i - 1][1];
                intervals[i - 1][1] = temp;
            }
        }
        return intervals;
    }
}