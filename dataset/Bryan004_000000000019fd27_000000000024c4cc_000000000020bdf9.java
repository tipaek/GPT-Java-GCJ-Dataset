import java.util.Arrays;
import java.util.Scanner;

public class Solution
{   
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = Integer.valueOf(scan.nextLine());
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int[][] times = new int[n][2];
            for (int j = 0; j < n; j++) {
                times[j][0] = scan.nextInt();
                times[j][1] = scan.nextInt();
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(times));
        }
    }
    
    public static String solve(int[][] times) {
        Arrays.sort(times, (a, b) -> Double.compare(a[0], b[0]));
        String ret = "";
        boolean impossible = false;
        //Process:
        //Start with C
        //Process C
        
        int[] taskC = null;
        int[] taskJ = null;
        
        for (int i = 0; i < times.length; i++) {
            if (taskC == null) {
                taskC = times[i];
                ret += "C";
            }
            else if (taskC != null) {
                if (times[i][0] >= taskC[1]) {
                    taskC = times[i];
                    ret += "C";
                }
                else if (taskJ == null) {
                    taskJ = times[i];
                    ret += "J";
                }
                else {
                    if (times[i][0] >= taskJ[1]) {
                        ret += "J";
                        taskJ = times[i];
                    }
                    else {
                        impossible = true;
                        break;
                    }
                }
            }
        } 
        return impossible ? "IMPOSSIBLE" : ret;
    }
}