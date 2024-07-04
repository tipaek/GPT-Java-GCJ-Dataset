
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int target = in.nextInt();
            String sol = "";
            System.out.println("Case #" + i + ":");
            if(target <= 501){
                solveSmall(target);
            }
        }
    }

    public static void solveSmall(int target){
        if (target == 501){
            System.out.println("1 1");
            System.out.println("2 1");
            System.out.println("3 2");
            for (int i = 4; i < 501; i++){
                System.out.println("" + (i - 1) + " 1");
            }
            return;
        }
        for (int i = 1; i <= target; i++){
            System.out.println(""+ i + " 1");
        }
    }

}
