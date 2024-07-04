import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();

            String s1 = "SEN";
            String s2 = "NWS";
            String s3 = "EE";
            String s4 = "IMPOSSIBLE";
            String fs;
            if(x==2 && y==3) {
                fs = s1;
            } else if (x==-2 && y==-3){
                fs=s2;
            } else if (x==3 && y==0) {
                fs=s3;
            } else {
                fs=s4;
            }
            System.out.println("Case #" + i + ": " + fs);
        }
    }
}
