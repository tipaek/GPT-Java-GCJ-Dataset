import java.util.*;
import java.io.*;

public class Solution {
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
            String res = compond(vals, 0, vals.length-1);
            System.out.printf("Case #%d: %s\n", i, res);
        }
    }

    public static String compond(int[] vals, int from, int to) {
        if (from > to){
            return "";
        }
        if (from == to){
            String res = addLeft(String.valueOf(vals[from]), vals[from]);
            res = addRight(res, vals[from]);
            return res;
        }
        int maxId = from;
        for (int i = from; i <= to; i++){
            if (vals[i] > vals[maxId]){
                maxId = i;
            }
        }
        String nowRes= String.valueOf(vals[maxId]);
        int left = vals[maxId];
        int nowId = maxId-1;
        while (left > 0){
            if (nowId >= from && vals[nowId] <= left){
                nowRes = String.valueOf(vals[nowId]) + addLeft(nowRes, left - vals[nowId]);
                left -= (left - vals[nowId]);
                nowId--;
            } else if (nowId >= from && vals[nowId] > left){
                String nowV = addRight(addLeft(String.valueOf(vals[nowId]), vals[nowId] - left), vals[nowId] - left);
                nowRes = nowV + nowRes;
                nowId--;
            } else {
                nowRes = addLeft(nowRes, left);
                left = 0;
            }
        }
        nowRes = compond(vals, from, nowId) + nowRes;
        int right = vals[maxId];
        nowId = maxId+1;
        while (right > 0){
            if (nowId <= to && vals[nowId] <= right){
                nowRes = addRight(nowRes, right - vals[nowId]) + String.valueOf(vals[nowId]);
                right -= (right - vals[nowId]);
                nowId++;
            } else if (nowId <= to && vals[nowId] > right){
                String nowV = addRight(addLeft(String.valueOf(vals[nowId]), vals[nowId] - right), vals[nowId] - right);
                nowRes = nowRes + nowV;
                nowId++;
            } else {
                nowRes = addRight(nowRes, right);
                right = 0;
            }
        }
        nowRes = nowRes + compond(vals, nowId, to);

        return nowRes;
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