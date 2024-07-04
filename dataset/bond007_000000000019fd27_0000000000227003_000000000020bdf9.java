import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scan.nextInt();

            int[][] times = new int[N][3];
            for(int i=0; i<N; i++){
                times[i][0] = scan.nextInt();
                times[i][1] = scan.nextInt();

                times[i][2] = i;
            }

            Arrays.sort(times, (a, b) -> (a[0] - b[0]));

            char[] result = new char[N];

            int prevJEnd = -1;
            int prevCEnd = -1;
            boolean isImpossible = false;
            for(int i=0; i<N; i++){
                int start = times[i][0];
                if(start >= prevJEnd){
                    result[times[i][2]] = 'J';
                    prevJEnd = times[i][1];
                } else if(start >= prevCEnd){
                    result[times[i][2]] = 'C';
                    prevCEnd = times[i][1];
                } else {
                    isImpossible = true;
                    break;
                }
            }

            String finalResult = isImpossible ? "IMPOSSIBLE" : new String(result);

            System.out.println("Case #" + t + ": " + finalResult);
        }
    }
}