import java.util.*;
import java.io.*;

public class Solution {

    public static String parentingPartneringReturns(int[][] arr, int n){

        int j_min = Integer.MIN_VALUE, j_max = Integer.MAX_VALUE;
        int c_min = Integer.MIN_VALUE, c_max = Integer.MAX_VALUE;
        HashMap<String, Integer> map = new HashMap<>();
        char[] res_arr = new char[n];
        
        for(int i = 0; i < n; i++){
            map.put(arr[i][0]+"-"+arr[i][1], i);
        }
        
        Arrays.sort(arr, (a,b)->{
            return a[0] - b[0];
        });

        for(int i = 0; i < n; i++){
            if(j_min == Integer.MIN_VALUE){
                j_min = arr[i][0];
                j_max = arr[i][1];
                res_arr[map.get(arr[i][0]+"-"+arr[i][1])] = 'J';
                continue;
            }
            if(arr[i][0] > j_min && arr[i][0] < j_max){
                if(c_min == Integer.MIN_VALUE){
                    c_min = arr[i][0];
                    c_max = arr[i][1];
                    res_arr[map.get(arr[i][0]+"-"+arr[i][1])] = 'C';
                    continue;
                }
                if(arr[i][0] > c_min && arr[i][0] < c_max){
                    return "IMPOSSIBLE";
                }
                else{
                    c_min = arr[i][0];
                    c_max = arr[i][1];
                    res_arr[map.get(arr[i][0]+"-"+arr[i][1])] = 'C';
                    continue;
                }
            }
            else{
                j_min = arr[i][0];
                j_max = arr[i][1];
                res_arr[map.get(arr[i][0]+"-"+arr[i][1])] = 'J';
                continue;
            }
        }

        String res = new String(res_arr);
        return res;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] grid = new int[n][2];
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < 2; ++k) {
                    grid[j][k] = in.nextInt();
                }
            }
            String res = parentingPartneringReturns(grid, n);
            System.out.println("Case #" + i + ": "+res);
        }

    }
}