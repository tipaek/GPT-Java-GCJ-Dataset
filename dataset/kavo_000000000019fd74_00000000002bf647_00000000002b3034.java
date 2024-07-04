import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int casei = 1; casei <= t; ++casei) {
            int n = in.nextInt();
            String[] p = new String[n];
            //            int[] length = new int[n];
            //            int maxLen = 0;
            //            int maxLenPos = 0;
            //            StringBuilder sb = new StringBuilder();
            in.nextLine(); //position tyousei
            String currentMaxMojiretu = "";
            for (int i = 0; i < n; i++) {
                p[i] = in.nextLine().substring(1); //except *
                if ("*".equals(currentMaxMojiretu)) {
                    continue;
                }
                //                length[i] = p[i].length();
                //                if (maxLen < length[i]) {
                //                    maxLen = length[i];
                //                    maxLenPos = i;
                //                }
                if (currentMaxMojiretu.contains(p[i])) {
                    //pos check
                    int lastIn = currentMaxMojiretu.lastIndexOf(p[i]);
                    int plen = p[i].length();
                    int curLen = currentMaxMojiretu.length();
                    if (lastIn + plen != curLen) {
                        currentMaxMojiretu = "*";
                    }
                    //                    System.out.println("lastIn" + lastIn);
                    //                    System.out.println("plen" + plen);
                    //                    System.out.println("curLen" + curLen);
                    //                    System.out.println("currentMaxMojiretu" + currentMaxMojiretu);
                    //                    System.out.println("p[i]" + p[i]);
                } else if (p[i].contains(currentMaxMojiretu)) {
                    int lastIn = p[i].lastIndexOf(currentMaxMojiretu);
                    int plen = p[i].length();
                    int curLen = currentMaxMojiretu.length();
                    if (lastIn + curLen != plen) {
                        currentMaxMojiretu = "*";
                    } else {
                        currentMaxMojiretu = p[i];
                    }
                } else {
                    //no ansewer
                    currentMaxMojiretu = "*";
                }
                //                System.out.println("Read" + );
            }
            //            sb.append(p[maxLenPos]);

            System.out.println("Case #" + casei + ": " + currentMaxMojiretu);
        }
    }
}
