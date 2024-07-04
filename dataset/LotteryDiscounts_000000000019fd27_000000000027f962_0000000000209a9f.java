import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner in = new Scanner(
//                "7\n" +
//                        "0000\n" +
//                        "101\n" +
//                        "111000\n" +
//                        "312\n" +
//                        "4\n" +
//                        "021\n" +
//                        "221"
// );

        int t = in.nextInt();
        for (int c = 1; c <= t; ++c) {
            String w = in.next();
            String wprime = "";
            int level = 0;
            for (int i = 0; i < w.length(); i++) {
                int target = w.charAt(i) - '0';
                while(level < target) {
                    wprime += "(";
                    level++;
                }
                while(level > target) {
                    wprime += ")";
                    level--;
                }
                wprime += w.charAt(i);
            }
            while(level > 0) {
                wprime += ")";
                level--;
            }
            System.out.println("Case #" + c + ": " + wprime);
        }
    }
}
