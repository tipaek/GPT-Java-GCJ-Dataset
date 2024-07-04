import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution
{   
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = Integer.valueOf(scan.nextLine());
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int[][] times = new int[n][2];
            int[][] orig = new int[n][2];
            for (int j = 0; j < n; j++) {
                times[j][0] = scan.nextInt();
                times[j][1] = scan.nextInt();
                orig[j][0] = times[j][0];
                orig[j][1] = times[j][1];
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(times, orig));
        }
    }
    
    public static String solve(int[][] times, int[][] orig) {
        Arrays.sort(times, (a, b) -> Double.compare(a[0], b[0]));
        String ret = "";
        boolean impossible = false;
        
        //Processing
        int[] taskC = null;
        int[] taskJ = null;
        HashMap<String, String> map = new HashMap<>();
        
        for (int i = 0; i < times.length; i++) {
            if (taskC == null) {
                taskC = times[i];
                map.put(times[i][0] + "-" + times[i][1], "C");
            }
            else if (taskC != null) {
                if (times[i][0] >= taskC[1]) {
                    taskC = times[i];
                    map.put(times[i][0] + "-" + times[i][1], "C");
                }
                else if (taskJ == null) {
                    taskJ = times[i];
                    map.put(times[i][0] + "-" + times[i][1], "J");
                }
                else {
                    if (times[i][0] >= taskJ[1]) {
                        taskJ = times[i];
                        map.put(times[i][0] + "-" + times[i][1], "J");
                    }
                    else {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }
        //Mapping back
        for (int i = 0; i < orig.length; i++) {
            ret += map.get(orig[i][0] + "-" + orig[i][1]);
        }
        
        return ret;
    }
}