import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[]args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int[][]time = new int[n][3];
            char[]tasks = new char[n];
            for(int j = 0; j < n; j++){
                time[j][0] = sc.nextInt();
                time[j][1] = sc.nextInt();
                time[j][2] = j;
            }
            java.util.Arrays.sort(time, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Double.compare(a[0], b[0]);
                }
            });
            String s = "";
            int C = 0;
            int J = 0;
            for(int j = 0; j < n; j++){
                if(time[j][0] >= C){
                    C = time[j][1];
                    tasks[time[j][2]] = 'C';
                }
                else if(time[j][0] < C && time[j][0] >= J){
                    J = time[j][1];
                    tasks[time[j][2]] = 'J';
                }
                else{
                    s = "Case #" + (i+1) + ": IMPOSSIBLE";
                    break;
                }
            }
            if(s != ""){
                System.out.println(s);
            }
            else{
                s = "Case #" + (i+1) + ": ";
                for(int j = 0; j < n; j++){
                    s+=tasks[j];
                }
                System.out.println(s);
            }
        }
    }
}
