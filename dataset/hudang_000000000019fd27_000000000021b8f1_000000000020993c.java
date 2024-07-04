import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        int n, trace, rcnt, ccnt;
        int[][] map;
        HashSet<Integer> row;
        HashSet<Integer>[] col;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            n = in.nextInt();
            map = new int [n+1][n+1];
            trace = rcnt = ccnt = 0;
            col = new HashSet[n+1];

            for(int x = 1 ; x <= n ; x++){
                row = new HashSet<>();
                for(int y = 1 ; y <= n ; y++){
                    if(x == 1){
                        col[y] = new HashSet<>();
                    }
                    map[x][y] = in.nextInt();
                    if(x == y) trace += map[x][y];
                    row.add(map[x][y]);
                    col[y].add(map[x][y]);
                }
                if(row.size() < n) rcnt++;
            }

            for(int x = 1 ; x <= n ; x++){
                if(col[x].size() < n) ccnt++;
            }

            System.out.println("Case #" + i + ": " + trace + " " + rcnt + " " + ccnt);
        }
    }
}