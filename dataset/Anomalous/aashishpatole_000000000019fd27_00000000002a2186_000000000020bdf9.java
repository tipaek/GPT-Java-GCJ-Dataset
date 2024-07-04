import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int[] startInterval = new int[N];
            int[] endInterval = new int[N];
            int[] cStart = new int[N];
            int[] cEnd = new int[N];
            int[] jStart = new int[N];
            int[] jEnd = new int[N];
            
            for (int j = 0; j < N; j++) {
                startInterval[j] = in.nextInt();
                endInterval[j] = in.nextInt();
            }
            
            StringBuilder result = new StringBuilder();
            boolean possible = true;
            
            for (int k = 0; k < N; k++) {
                boolean cFlag = false;
                boolean jFlag = false;
                int j = 0;
                
                for (j = 0; j < N; j++) {
                    if (cStart[j] != 0 || cEnd[j] != 0) {
                        if ((cStart[j] <= startInterval[k] && startInterval[k] < cEnd[j]) || 
                            (cStart[j] < endInterval[k] && endInterval[k] <= cEnd[j])) {
                            cFlag = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                
                if (!cFlag) {
                    cStart[j] = startInterval[k];
                    cEnd[j] = endInterval[k];
                    result.append("C");
                } else {
                    for (j = 0; j < N; j++) {
                        if (jStart[j] != 0 || jEnd[j] != 0) {
                            if ((jStart[j] <= startInterval[k] && startInterval[k] < jEnd[j]) || 
                                (jStart[j] < endInterval[k] && endInterval[k] <= jEnd[j])) {
                                jFlag = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    
                    if (!jFlag) {
                        jStart[j] = startInterval[k];
                        jEnd[j] = endInterval[k];
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        possible = false;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}