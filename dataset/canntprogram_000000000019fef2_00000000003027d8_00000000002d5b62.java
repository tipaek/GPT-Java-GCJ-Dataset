import java.util.*;
import java.io.*;

public class Solution {
    public static void solve(int ks, int X, int Y) {
        String route = "";
        if(X+Y %2 ==0){
            route = "IMPOSSIBLE";
        }else{
            int sum = Math.abs(X)+ Math.abs(Y);
            int temp = 0;
            int i = 1;
            //sum = 2^(n+1)-1 or 2^(n+1)-3
            ArrayList<Integer> st = new ArrayList<Integer>();
            while(temp<sum){
                temp = temp + i;
                st.add(i);
                i *=2;
            }
            route = helper(X, Y, st);
        }
        System.out.println("Case #" + ks + ": " + route);
    }

    public static String helper(int X, int Y, ArrayList<Integer>s){
        StringBuilder b = new StringBuilder();
        for(int i=s.size()-1; i>=0; i--){
            if(Math.abs(X)>Math.abs(Y)){
                if(X>0){
                    b.append('E');
                    X -=s.get(i);
                }else{
                    b.append('W');
                    X +=s.get(i);
                }
            }else if(Math.abs(X)<Math.abs(Y)){
                if(Y>0){
                    b.append('N');
                    Y -= s.get(i);
                }else{
                    b.append('S');
                    Y+=s.get(i);
                }
            }
        }
        return b.toString();
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int X = input.nextInt();
            int Y = input.nextInt();
            solve(ks, X, Y);
        }
    }
}
