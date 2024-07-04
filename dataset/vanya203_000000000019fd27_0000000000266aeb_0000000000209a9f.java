import java.util.*;
import java.io.*;

public class Solution {
    public static int minLen = Integer.MAX_VALUE;
    public static String minRes = "";
    public static int[][] mem = null;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine());

        for (int i = 1; i <= T; ++i) {
            String cs = in.nextLine();
            int[] vals = new int[cs.length()];
            char[] vchars = cs.toCharArray();
            for (int j = 0; j < vals.length; j++){
                vals[j] = vchars[j] - '0';
            }
            mem = new int[vals.length][10];
            minLen = Integer.MAX_VALUE;
            minRes = "";
            compond(vals, 0, 0, "");
            System.out.printf("Case #%d: %s\n", i, minRes);
        }
    }

    public static void compond(int[] vals, int position, int toClose, String res) {
        if (position == vals.length){
            if (res.length() + toClose < minLen){
                minRes = addRight(res, toClose);
                minLen = minRes.length();
            }
            return;
        }
        if (mem[position][toClose] > 0 && mem[position][toClose] < res.length()){
            return;
        }
        mem[position][toClose] = res.length();
        if (vals[position] < toClose){
            String toClosePartLess = addRight(res, toClose - vals[position]) + String.valueOf(vals[position]);
            compond(vals, position+1, vals[position], toClosePartLess);
        } else {
            String toCloseAll = addRight(res, toClose) + addLeft(String.valueOf(vals[position]), vals[position]);
            compond(vals, position+1, vals[position], toCloseAll);
            String toClosePartBigger = res + addLeft(String.valueOf(vals[position]), vals[position] - toClose);
            compond(vals, position+1, vals[position], toClosePartBigger);
        }
    }
    public static String addLeft(String in, int n){
        StringBuilder res= new StringBuilder();
        for (int i = 0 ; i < n ; i++){
            res.append('(');
        }
        res.append(in);
        return res.toString();
    }

    public static String addRight(String in, int n){
        StringBuilder res= new StringBuilder();
        res.append(in);
        for (int i = 0 ; i < n ; i++){
            res.append(')');
        }
        return res.toString();
    }


}
