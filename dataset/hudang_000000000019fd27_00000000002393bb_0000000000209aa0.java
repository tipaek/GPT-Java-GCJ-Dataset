import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int n, k;
    static int[][] map;
    static Stack<Integer> trace, fix;


    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {

            n = in.nextInt();
            k = in.nextInt();
            map = new int [n+1][n+1];
            trace = new Stack<>();
            fix = new Stack<>();
            if(findTrace(1, 0)){ 
                System.out.println("Case #" + i + ": " + "POSSIBLE");
                for(int x = 1; x <= n ; x++){
                    for(int y = 1 ; y <= n ; y++){
                        System.out.print(map[x][y]);
                        if(y < n) System.out.print(" ");
                    }
                    System.out.println();
                }
            }else{
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }


        }
    }

    private static boolean findTrace(int idx, int sum) {
        boolean rtn = false;
        if(idx > n && sum == k){
            fix = (Stack<Integer>) trace.clone();
            rtn =  makeArray();
        }else if((n - (idx-1)) * n < k-sum){
            rtn =  false;
        }else if(sum > k){
            rtn =  false;
        }else{
            for(int z = 1 ; z <= n ; z++){
                if(sum + z  <= k){
                    trace.add(z);
                    if(rtn = findTrace(idx+1, sum+z)){
                        break;
                    }
                    trace.pop();
                }
            }
        }
        return rtn;
    }

    private static boolean makeArray() {
        boolean rtn = true;
        int val;

        for(int x = 1 ; x <= n ; x++){
            val = fix.pop();
            for(int y = 1 ; y <= n ; y++){
                if(!put(x, y, val)){
                    rtn = false;
                    break;
                }
            }
            if(!rtn) break;
        }
        return rtn;
    }

    private static boolean put(int x, int y, int v) {
        int val = 0;
        if(x == y) val = v;
        else{
            A:
            for(int z = 1 ; z <= n ; z++){
                if(z == v) continue ;
                if(checkRow(z, x, y) && checkCol(z, x, y)){
                    val = z;
                    break;
                }
            }
        }
        if(val == 0){
            return false;
        }else{
            map[x][y] = val;
            return true;
        }
    }

    private static boolean checkCol(int z, int x, int y) {
        boolean rtn = true;
        for(int w = 1 ; w < x ; w++){
            if(map[w][y] == z){
                rtn = false;
                break;
            }
        }
        return rtn;
    }

    private static boolean checkRow(int z, int x, int y) {
        boolean rtn = true;
        for(int w = 1 ; w < y ; w++){
            if(map[x][w] == z){
                rtn = false;
                break;
            }
        }
        return rtn;
    }
}