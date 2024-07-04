import java.io.*;
import java.util.*;

public class Solution {

    static String[][] dp;

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            int m = in.nextInt();
            int n = in.nextInt();

            //dp = new String[m][n];

            String ans = recurse(m,n);
            if(ans.charAt(ans.length()-1) == 'I') ans = "IMPOSSIBLE";

            System.out.println("Case #" + (x + 1) + ": "+ans);
        }
    }

    public static String recurse(int x, int y){
        //System.out.println(x+", "+y);
        if(x==0 && y==0) return "";
        if(x==0 && y==1) return "N";
        if(x==1 && y==0) return "E";
        if(x==0 && y==-1) return "S";
        if(x==-1 && y==0) return "W";
        if(x%2==y%2) return "IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII";
        if(x%2==0 && y%2!=0){
            String a = recurse(x/2, (y-1)/2); String b = recurse(x/2,(y+1)/2);
            if(a.length()<b.length()) return "N"+a;
            else return "S"+b;
        }
        if(x%2!=0 && y%2==0){
            String a = recurse((x-1)/2, y/2); String b = recurse((x+1)/2,y/2);
            if(a.length()<b.length()) return "E"+a;
            else return "W"+b;
        }
        return "I";
    }
}

