import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nbTest = in.nextInt();
        
        for (int t = 0; t < nbTest; t++) {
            int N = in.nextInt();
            int[] startTimes = new int[N];
            int[] endTimes = new int[N];
            boolean[] assignedToJ = new boolean[N];
            int[] cursors = {0, 0};
            int[] order = new int[N];
            boolean isImpossible = false;
            
            for (int i = 0; i < N; i++) {
                order[i] = -1;
                startTimes[i] = in.nextInt();
                endTimes[i] = in.nextInt();
            }
            
            for (int i = 0; i < N; i++) {
                int minStart = Integer.MAX_VALUE;
                int minIndex = -1;
                
                for (int j = 0; j < N; j++) {
                    int candidateStart = startTimes[j];
                    boolean isAvailable = true;
                    
                    for (int k = 0; k < i; k++) {
                        if (order[k] == j) {
                            isAvailable = false;
                            break;
                        }
                    }
                    
                    if (isAvailable && candidateStart < minStart) {
                        minStart = candidateStart;
                        minIndex = j;
                    }
                }
                
                order[i] = minIndex;
            }
            
            for (int i = 0; i < N; i++) {
                int start = startTimes[order[i]];
                
                if (cursors[0] <= start) {
                    assignedToJ[order[i]] = false;
                    cursors[0] = endTimes[order[i]];
                } else if (cursors[1] <= start) {
                    assignedToJ[order[i]] = true;
                    cursors[1] = endTimes[order[i]];
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    result.append(assignedToJ[i] ? "J" : "C");
                }
                System.out.println("Case #" + (t + 1) + ": " + result.toString());
            }
        }
        in.close();
    }
}