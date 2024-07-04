import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(sc.nextLine());
        for(int i=0; i< t;i++) {
            int n = Integer.parseInt(sc.nextLine());
            int[][] schedule = new int[n][2];
            String result = "";
            for(int j=0;j<n;j++) {
                String str[] = sc.nextLine().trim().split("\\s+");
                schedule[j][0] = Integer.parseInt(str[0]);
                schedule[j][1] = Integer.parseInt(str[1]);
            }
            java.util.Arrays.sort(schedule, Comparator.comparing(a->a[0]));
            int cend = 0;
            int jend = 0;
            for(int k=0;k<n;k++) {
                if(schedule[k][0] >= cend) {
                    cend = schedule[k][1];
                    result += "C";
                }
                else {
                    if(schedule[k][0] >= jend) {
                        jend = schedule[k][1];
                        result += "J";
                    }
                    else {
                        result = "IMPOSSIBLE";
                        break;
                    }
                }
            }
            System.out.println("Case #" + (i+1) + ": " + result);
        }
        sc.close();
    }
}