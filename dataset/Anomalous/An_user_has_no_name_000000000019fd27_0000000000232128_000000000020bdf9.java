import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            boolean[] she = new boolean[1441];
            boolean[] jhe = new boolean[1441];
            boolean feasible = true;
            StringBuilder ans = new StringBuilder("C");
            int n = in.nextInt();
            int s = in.nextInt();
            int e = in.nextInt();
            
            for (int j = s; j <= e; j++) {
                she[j] = true;
            }
            
            for (int j = 2; j <= n; j++) {
                boolean canAssignC = true;
                boolean canAssignJ = true;
                s = in.nextInt();
                e = in.nextInt();
                
                if (feasible) {
                    for (int k = s + 1; k < e; k++) {
                        if (she[k]) {
                            canAssignC = false;
                            break;
                        }
                    }
                    
                    if (canAssignC) {
                        for (int k = s; k <= e; k++) {
                            she[k] = true;
                        }
                        ans.append("C");
                    } else {
                        for (int k = s + 1; k < e; k++) {
                            if (jhe[k]) {
                                canAssignJ = false;
                                break;
                            }
                        }
                        
                        if (canAssignJ) {
                            for (int k = s; k <= e; k++) {
                                jhe[k] = true;
                            }
                            ans.append("J");
                        }
                    }
                    
                    if (!canAssignC && !canAssignJ) {
                        ans = new StringBuilder("IMPOSSIBLE");
                        feasible = false;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}