import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(sc.nextLine());
        for(int i=0; i< t;i++) {
            int n = Integer.parseInt(sc.nextLine());
            int[][] schedule = new int[n][2];
            int[][] original = new int[n][2];
            String result = "";
            for(int j=0;j<n;j++) {
                String str[] = sc.nextLine().trim().split("\\s+");
                schedule[j][0] = Integer.parseInt(str[0]);
                schedule[j][1] = Integer.parseInt(str[1]);
                original[j][0] = Integer.parseInt(str[0]);
                original[j][1] = Integer.parseInt(str[1]);
            }
            java.util.Arrays.sort(schedule, Comparator.comparing(a->a[0]));
            int cend = 0;
            int jend = 0;
            Map<String, String> lkp = new HashMap<String, String>();
            for(int k=0;k<n;k++) {
                if(schedule[k][0] >= cend) {
                    cend = schedule[k][1];
                    lkp.put(String.valueOf(schedule[k][0]) + ":" + String.valueOf(schedule[k][1]), "C");
                }
                else {
                    if(schedule[k][0] >= jend) {
                        jend = schedule[k][1];
                        lkp.put(String.valueOf(schedule[k][0]) + ":" + String.valueOf(schedule[k][1]), "J");
                    }
                    else {
                        result = "IMPOSSIBLE";
                        break;
                    }
                }
            }
            if(result == "IMPOSSIBLE")
                System.out.println("Case #" + (i+1) + ": " + result);
            else {
                for(int k=0;k<n;k++) {
                    result += lkp.get(String.valueOf(original[k][0]) + ":" + String.valueOf(original[k][1]));
                }
                System.out.println("Case #" + (i+1) + ": " + result);
            }
        }
        sc.close();
    }
}