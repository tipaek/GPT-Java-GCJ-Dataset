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
            int[][] times = new int[n][3];
            int[][] orig = new int[n][3];
            for (int j = 0; j < n; j++) {
                times[j][0] = scan.nextInt();
                times[j][1] = scan.nextInt();
                times[j][2] = j;
                orig[j][0] = times[j][0];
                orig[j][1] = times[j][1];
                orig[j][2] = j;
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(times, orig));
        }
    }
    
    public static String solve(int[][] times, int[][] orig) {
        Arrays.sort(times, (a, b) -> {
            if (a[0] - (b[0]) == 0) {
                return a[1] - (b[1]);
            } else {
                return a[0] - (b[0]);
            } 
        });
        String ret = "";
        
        //Processing
        int[] taskC = null;
        int[] taskJ = null;
        HashMap<Integer, String> map = new HashMap<>();
        
        for (int i = 0; i < times.length; i++) {
            //System.out.println(times[i][0] + " " + times[i][1]);
            if (taskC == null) {
                taskC = times[i];
                map.put(times[i][2], "C");
            }
            else if (taskC != null) {
                if (times[i][0] >= taskC[1]) {
                    taskC = times[i];
                    map.put(times[i][2], "C");
                }
                else if (taskJ == null) {
                    taskJ = times[i];
                    map.put(times[i][2], "J");
                }
                else {
                    if (times[i][0] >= taskJ[1]) {
                        taskJ = times[i];
                        map.put(times[i][2], "J");
                    }
                    else {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }
        //Mapping back
        for (int i = 0; i < orig.length; i++) {
            ret += map.get(i);
        }
        
        return ret;
    }
}