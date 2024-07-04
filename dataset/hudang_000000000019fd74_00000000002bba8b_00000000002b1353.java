import java.util.*;
import java.io.*;
public class Solution {
    static Stack<String> PATH = new Stack<>();
    static int[] mvR = {1, 0, -1, -1, 0, 1};
    static int[] mvK = {1, 1, 0, -1, -1, 0};
    static int[][] COMB = new int[31][31];
    public static void main(String[] args) {
        for(int i = 1 ; i <= 30 ; i++){
            for(int j = 1 ; j <= i ; j++){
                if(i == 1 || i == 2 || j == 1 || i == j){
                    COMB[i][j] = 1;
                }else{
                    COMB[i][j] = COMB[i-1][j] + COMB[i-1][j-1];
                }
            }
        }

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            PATH.clear();
            find(n, 1, 1);
            Stack<String> ANSWER = new Stack<>();
            while(!PATH.isEmpty()){
                ANSWER.push(PATH.pop());
            }
            System.out.println("Case #" + i + ":");
            while(!ANSWER.isEmpty()){
                System.out.println(ANSWER.pop());
            }
        }
    }

    private static boolean find(int rest, int r, int k) {
        if(rest == 0){
            return true;
        }
        if(r == 1  && k == 1){
            PATH.add("1 1");
            if(find(rest - 1, 2,1))
                return true;
            return find(rest - 1, 2,2);
        }

        for(int i = 0 ; i < 5 ; i++){
            int nR = r + mvR[i];
            int nK = k + mvK[i];
            int value = COMB[r][k];

            if(value > rest) continue;

            PATH.push(r + " " + k);
            if(find(rest - value, nR, nK)){
                return true;
            }
            PATH.pop();
        }
        return false;
    }
}