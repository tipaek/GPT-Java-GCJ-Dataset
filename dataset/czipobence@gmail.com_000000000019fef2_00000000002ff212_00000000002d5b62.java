import java.util.*;
import java.io.*;
public class Solution {

   public static String solve(int tmpx, int tmpy, int exp, String path) {
       if (tmpx == 0 && tmpy == 0) {
           return path;
       }

       int nextX;
       int nextY;

       int nextExp = exp *2;

       if (tmpx % nextExp == tmpy % nextExp) {
           return null;
       }

       int nextNextExp = nextExp *2;

       String newPath = path;

       if (tmpx % nextExp == 0) {

           int nextTmpY1 = tmpy + exp;
           int nextTmpY2 = tmpy - exp;

           if (nextTmpY1 == 0) {
               newPath = solve(tmpx, nextTmpY1, nextExp, path + "S");
               if (newPath != null) {
                   return newPath;
               }
           }
           if (nextTmpY2 == 0) {
               newPath = solve(tmpx, nextTmpY2, nextExp, path + "N");
               if (newPath != null) {
                   return newPath;
               }
           }
           if (tmpx % nextNextExp == 0) {
               if (nextTmpY1 % nextNextExp == 0) {
                   return solve(tmpx, nextTmpY2, nextExp, path + "N");
               } else {
                   return solve(tmpx, nextTmpY1, nextExp, path + "S");
               }
           } else {
               if (nextTmpY1 % nextNextExp == 0) {
                   return solve(tmpx, nextTmpY1, nextExp, path + "S");
               } else {
                   return solve(tmpx, nextTmpY2, nextExp, path + "N");
               }
           }

       } else {
           if (tmpy % nextExp != 0) {
               return null;
           }

           nextY = tmpy;

           int nextTmpX1 = tmpx + exp;
           int nextTmpX2 = tmpx - exp;

           if (nextTmpX1 == 0) {
               newPath = solve(nextTmpX1, tmpy, nextExp, path + "W");
               if (newPath != null) {
                   return newPath;
               }
           } if (nextTmpX2 == 0) {
               newPath = solve(nextTmpX2, tmpy, nextExp, path + "E");
               if (newPath != null) {
                   return newPath;
               }
           }
           if (tmpy % nextNextExp == 0) {
               if (nextTmpX1 % nextNextExp == 0) {
                   return solve(nextTmpX2, tmpy, nextExp, path + "E");
               } else {
                   return solve(nextTmpX1, tmpy, nextExp, path + "W");
               }
           } else {
               if (nextTmpX1 % nextNextExp == 0) {
                   return solve(nextTmpX1, tmpy, nextExp, path + "W");
               } else {
                   return solve(nextTmpX2, tmpy, nextExp, path + "E");
               }
           }
       }

   }


   public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();

            String res = solve(x, y, 1, "");





            if (res != null) {
                System.out.println("Case #" + i + ": " + res);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }

        }
    }
}