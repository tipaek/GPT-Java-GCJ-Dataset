
import java.util.Scanner;

class Solution {

    public static String solve(int X, int Y){
        if((X+Y)%2==0)
            return "IMPOSSIBLE";
        return subSolve(X, Y, "");
    }
    
    public static String subSolve(int X, int Y, String s){
        log(String.format("subsolve %d, %d, %s", X, Y,s));
        if((X+Y)%2==0){
            return "IMPOSSIBLE";
        }
        if(X%2 ==1 || X%2==-1){
            if(((X+Y-1)/2)%2 != 0||(X+Y-1)/2 ==0){
                X = X -1;
                s += "E";
            }else {
                X = X +1;
                s += "W";
            }
        } else {
            // 23=5, 6or4? 6,S
            // 01 = 1, 0or2 
            if(((X+Y-1)/2)%2 != 0||(X+Y-1)/2 ==0){
                Y = Y -1;
                s += "N";
            }else {
                Y = Y +1;
                s += "S";
            }
        }
        if(X==0 &&Y==0){
            return s;
        }
        return subSolve(X/2, Y/2, s);
    }
/**
4
2 3
-2 -3
3 0
-1 1


 */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t =0; t<T; t++){
            int X = in.nextInt();
            int Y = in.nextInt();
            print(String.format("Case #%d: %s", t+1, solve(X, Y)));
        }
        in.close();
    }

    public static void print(Object o){
        System.out.println(o.toString());
    }

    public static void log(Object o){
        // print(o);
    }
}