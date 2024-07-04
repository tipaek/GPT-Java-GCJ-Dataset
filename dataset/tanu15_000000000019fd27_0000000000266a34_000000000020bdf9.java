import java.util.*;

class Solution
{
    public static void main (String [] args) {
        Scanner s = new Scanner (System.in);
        
        int t = s.nextInt();
       
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int[][] time = new int[n][3];
            StringBuilder str = new StringBuilder(n);
        
            for (int j = 0; j < n; j++) {
                time[j][0] = s.nextInt();
                time[j][1] = s.nextInt();
                time[j][2] = j;
                str.append('j');
            }
            
            solve (i + 1, time, str);
        }
    }
    
    private static void solve (int caseNum, int[][] time, StringBuilder str) {
        
        
        Arrays.sort(time, (i, j)-> i[0] - j[0]);
        
        int jBusy = 0, cBusy = 0;

        for (int i = 0; i < time.length; i++) {
            if (jBusy <= time[i][0]) {
                jBusy = time[i][1];
                str.setCharAt(time[i][2], 'J');
            } else if (cBusy <= time[i][0]) {
                cBusy = time[i][1];
                str.setCharAt(time[i][2], 'C');
            } else  {
                System.out.println ("Case #"+caseNum+": IMPOSSIBLE");
                return;
            } 
        }        

        System.out.println ("Case #"+caseNum+": "+str.toString());
        
    }
}