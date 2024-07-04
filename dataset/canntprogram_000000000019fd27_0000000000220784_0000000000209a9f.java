import java.util.*;
import java.io.*;

public class Solution {
    public static void solve(int ks, String S) {
        S = helper(S, 0);
        System.out.println("Case #" + ks + ": "+ S);
    }
    public static String helper(String S, int numP){
        if(S.length()==0){
            return S;
        }
        int min = Integer.MAX_VALUE;
        int minPos = S.length();
        for(int i=0; i<S.length(); i++){
            int temp = S.charAt(i) -'0';
            if(temp<min){
                min = temp;
                minPos = i;
            }
        }
        int minSegS=minPos;
        int minSegE=minPos;
        while(minSegS>0 && S.charAt(minSegS-1)-'0'== min){
            minSegS--;
        }
        while(minSegE<S.length()-1 && S.charAt(minSegE+1)-'0'== min){
            minSegE++;
        }

        S = helper(S.substring(0, minSegS), min) +
                S.substring(minSegS, minSegE+1) +
                helper(S.substring(minSegE+1), min);
        for(int i=0; i<min-numP; i++){
            S = '('+S+')';
        }
        return S;
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        //T test cases
        int T = input.nextInt();
        input.nextLine();
        for (int ks = 1; ks <= T; ks++) {
            String S = input.nextLine();
            solve(ks, S);
        }
    }
}
