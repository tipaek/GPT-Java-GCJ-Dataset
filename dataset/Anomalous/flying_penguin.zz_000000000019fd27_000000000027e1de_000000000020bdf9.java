import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            boolean[] cs = new boolean[24 * 60 + 1];
            boolean[] ce = new boolean[24 * 60 + 1];
            boolean[] js = new boolean[24 * 60 + 1];
            boolean[] je = new boolean[24 * 60 + 1];
            
            int[][] intervals = new int[N][2];
            for (int i = 0; i < N; i++) {
                intervals[i][0] = in.nextInt();
                intervals[i][1] = in.nextInt();
            }
            
            String result = "";
            boolean foundSolution = false;
            
            for (int n = 0; n < (1 << N); n++) {
                String binaryString = String.format("%" + N + "s", Integer.toBinaryString(n)).replace(' ', '0');
                
                Arrays.fill(cs, false);
                Arrays.fill(ce, false);
                Arrays.fill(js, false);
                Arrays.fill(je, false);
                
                boolean overlap = false;
                for (int i = 0; i < N; i++) {
                    if (binaryString.charAt(i) == '0') {
                        if (cs[intervals[i][0]] || ce[intervals[i][1]]) {
                            overlap = true;
                            break;
                        } else {
                            cs[intervals[i][0]] = true;
                            ce[intervals[i][1]] = true;
                            for (int k = intervals[i][0] + 1; k < intervals[i][1]; k++) {
                                cs[k] = true;
                                ce[k] = true;
                            }
                        }
                    } else {
                        if (js[intervals[i][0]] || je[intervals[i][1]]) {
                            overlap = true;
                            break;
                        } else {
                            js[intervals[i][0]] = true;
                            je[intervals[i][1]] = true;
                            for (int k = intervals[i][0] + 1; k < intervals[i][1]; k++) {
                                js[k] = true;
                                je[k] = true;
                            }
                        }
                    }
                }
                if (!overlap) {
                    result = binaryString.replace('0', 'C').replace('1', 'J');
                    foundSolution = true;
                    break;
                }
            }
            
            if (!foundSolution) {
                result = "IMPOSSIBLE";
            }
            
            System.out.println("Case #" + t + ": " + result);
        }
    }
}