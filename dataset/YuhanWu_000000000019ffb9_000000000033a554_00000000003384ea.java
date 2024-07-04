import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Harry on 5/16/20.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            long L = in.nextLong();
            long R = in.nextLong();
            int cur = 1;
            while(L>=cur || R>=cur){
                if (L >= R) {
                    L -= cur;
                }
                else{
                    R -= cur;
                }
                ++cur;
            }
            System.out.println("Case #"+i+": "+(cur-1)+" "+L+" "+R);
        }
    }
}
