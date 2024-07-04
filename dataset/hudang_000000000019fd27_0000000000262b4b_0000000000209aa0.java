import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int n, k;
    static int fix[];
    static int[][] map;
    static Stack<Integer> trace;


    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {

            n = in.nextInt();
            k = in.nextInt();
            map = new int [n+1][n+1];
            trace = new Stack<>();
            fix = new int[n+1];
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
            Stack<Integer> tmp = (Stack<Integer>) trace.clone();
            for (int i = 1; i <= n; i++) {
                fix[i] =  tmp.pop();
            }
            rtn =  make(1,1);
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

    private static boolean make(int posX, int posY) {
        boolean rtn = false;
        int nX = posX;
        int nY = posY;
        if(posY == n){
            nY = 1;
            nX ++;
        }else{
            nY++;
        }
        if(posX == posY){
            for(int row = 1; row < posX ; row++ ){
                if(map[row][posY] == fix[posX])
                    return false;
            }
            map[posX][posY] = fix[posX];
            if(posX == n && posY == n){
                rtn = true;
            }else{
                rtn =  make(nX, nY);
            }
        }else{
            A:
            for(int i = 1 ; i <= n ; i++){
                if(i == fix[posX])
                    continue;
                for(int col = 1; col < posY ; col++ ){
                    if(map[posX][col] == i)
                        continue A;
                }
                for(int row = 1; row < posX ; row++ ){
                    if(map[row][posY] == i)
                        continue A;
                }
                map[posX][posY] = i;
                if(posX == n && posY == n){
                    rtn = true;
                    break ;
                }else{
                    rtn =  make(nX, nY);
                    if(rtn) break ;
                }
            }
        }
        return rtn;
    }
}