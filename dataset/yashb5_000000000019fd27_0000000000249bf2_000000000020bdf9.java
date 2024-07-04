import java.util.*;

class Solution
{
    public static void main (String [] args) {
        Scanner s = new Scanner (System.in);
        
        int t = s.nextInt();
       
        for (int k = 0; k < t; k++) {
            int n = s.nextInt();
            int[][] act = new int[n][3];
            StringBuilder sb = new StringBuilder(n);
        
            for (int i = 0; i < n; i++) {
                act[i][0] = s.nextInt();
                act[i][1] = s.nextInt();
                act[i][2] = i;
                sb.append('i');
            }
            
            solve (k, act, sb);
        }
    }
    
    private static void solve (int caseNum, int[][] act, StringBuilder sb) {
        
        
        Arrays.sort(act, (i, j)-> i[0] - j[0]);
        
        int jBusy = 0, cBusy = 0;

        for (int i = 0; i < act.length; i++) {
            if (jBusy <= act[i][0]) {
                jBusy = act[i][1];
                sb.setCharAt(act[i][2], 'J');
            } else if (cBusy <= act[i][0]) {
                cBusy = act[i][1];
                sb.setCharAt(act[i][2], 'C');
            } else  {
                System.out.println ("Case #"+caseNum+": IMPOSSIBLE");
                return;
            } 
        }        

        System.out.println ("Case #"+caseNum+": "+sb.toString());
        
    }
}