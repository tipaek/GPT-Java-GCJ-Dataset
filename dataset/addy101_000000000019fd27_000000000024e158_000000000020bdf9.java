import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String args[]) throws IOException{
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine().trim());
        for(int x = 0; x < t; x ++){
            int n = Integer.parseInt(br.readLine().trim());
            int[][] time = new int[n][2];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                time[i][0] = Integer.parseInt(s[0]);
                time[i][1] = Integer.parseInt(s[1]);
            }
            Arrays.sort(time, new Comparator<int[]>() {
                public int compare(int[] a, int[] b){
                    return a[0] - b[0];
                }
            });
            int eC = 0, eJ = 0;
            StringBuilder sb = new StringBuilder();
            boolean fail = false;
            for(int[] y: time){
                if(eC <= y[0]){
                    eC = y[1];
                    sb.append('C');
                } else if(eJ <= y[0]){
                    eJ = y[1];
                    sb.append('J');
                } else{
                    fail = true;
                    break;
                }
            }
            System.out.print("Case #" + (x+1) + ": ");
            if(fail)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(sb);
        }
    }
}