import java.util.*;
import java.io.*;

public class Solution {
    public static void solve(int ks, int X, int Y, String M) {
        String y = "IMPOSSIBLE";
        int curDist;
        for(int i = 0; i<M.length(); i++){
            if(M.charAt(i) == 'N'){
                Y +=1;
            }else if(M.charAt(i) == 'S'){
                Y -=1;
            }else if(M.charAt(i) == 'W'){
                X -=1;
            }else if(M.charAt(i) == 'E'){
                X +=1;
            }
            curDist = Math.abs(X) + Math.abs(Y);
            if(curDist<=i+1){
                y=Integer.toString(i+1);
                break;
            }
        }
        System.out.println("Case #" + ks + ": " + y);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int X = input.nextInt();
            int Y = input.nextInt();
            String M = input.nextLine();
            M = M.substring(1);
            solve(ks, X, Y, M);
        }
    }
}
