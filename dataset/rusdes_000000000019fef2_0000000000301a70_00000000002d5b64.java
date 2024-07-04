import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = reader.nextInt();
        for(int i = 1; i <= t; i++){
            int[][] ans = new int[100000][2];
            int R = reader.nextInt(), S = reader.nextInt() ;
            int ways = 0;
            int Total = R * S;
            int removed = 0;
            int r = R;
            int total = Total;
            while(R > 1){
                ways++;
                ans[ways][0] = total - r;
                ans[ways][1] = r - 1;
                total--;
                removed++;
                r = R;
                if ((removed+1) / S == 1){
                    removed = 0;
                    Total -= S;
                    total = Total;
                    R--;
                    r = R;
                }
            }

            System.out.println("Case #" + i + ": " + ways);
            for (int j = 1; j <= ways; j++){
                System.out.println(ans[j][0] + " " + ans[j][1]);
            }
        }
    }
}