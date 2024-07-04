import java.util.*;
import java.io.*;

public class Solution {

    public static String parentingPartneringReturns(int[][] arr, int n){

        int j_min = Integer.MIN_VALUE, j_max = Integer.MAX_VALUE;
        int c_min = Integer.MIN_VALUE, c_max = Integer.MAX_VALUE;
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        
        char[] res_arr = new char[n];
        
        for(int i = 0; i < n; i++){
            ArrayList a = map.getOrDefault(arr[i][0]+"-"+arr[i][1], new ArrayList<Integer>());
            a.add(i);
            map.put(arr[i][0]+"-"+arr[i][1], a);
        }
        
        Arrays.sort(arr, (a,b)->{
            if(a[0] != b[0])
                return a[0] - b[0];
            else
                return a[1] - b[1];
        });

        for(int i = 0; i < n; i++){
            if(j_min == Integer.MIN_VALUE){
                j_min = arr[i][0];
                j_max = arr[i][1];
                
                ArrayList a = map.get(arr[i][0]+"-"+arr[i][1]);
                res_arr[(int)a.get(0)] = 'J';
                a.remove(0);
                map.put(arr[i][0]+"-"+arr[i][1], a);
                continue;
            }
            if(arr[i][0] >= j_min && arr[i][0] < j_max){
                if(c_min == Integer.MIN_VALUE){
                    c_min = arr[i][0];
                    c_max = arr[i][1];
                    
                    ArrayList a = map.get(arr[i][0]+"-"+arr[i][1]);
                    res_arr[(int)a.get(0)] = 'C';
                    a.remove(0);
                    map.put(arr[i][0]+"-"+arr[i][1], a);
                    
                    continue;
                }
                if(arr[i][0] >= c_min && arr[i][0] < c_max){
                    return "IMPOSSIBLE";
                }
                else{
                    c_min = arr[i][0];
                    c_max = arr[i][1];
                    
                    ArrayList a = map.get(arr[i][0]+"-"+arr[i][1]);
                    res_arr[(int)a.get(0)] = 'C';
                    a.remove(0);
                    map.put(arr[i][0]+"-"+arr[i][1], a);
                    
                    continue;
                }
            }
            else{
                j_min = arr[i][0];
                j_max = arr[i][1];
                
                ArrayList a = map.get(arr[i][0]+"-"+arr[i][1]);
                res_arr[(int)a.get(0)] = 'J';
                a.remove(0);
                map.put(arr[i][0]+"-"+arr[i][1], a);
                
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