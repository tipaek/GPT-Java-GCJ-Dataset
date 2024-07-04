import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//import java.util.*;

class Solution {
    //private static int startX;
    //private static int endY;

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        for (int m =0; m<testcases;m++) {
            int endX = in.nextInt();
            int endY = in.nextInt();
            String output = getMinimumSteps(endX, endY);
            System.out.println("Case #" + m + ": " + output);
        }
    }

    private static String getMinimumSteps(int x, int y) {
        if(x == 0 && y == 0)
            return "";
        int isOddX = isOdd(x);
        int isOddY = isOdd(y);
        if((isOddX == 1 && isOddY == 1) || (isOddX == 0 && isOddY ==0))
            return "IMPOSSIBLE";
        if(isOddX == 1){
            int newX1 = (x-1)/2;
            int newX2 = (x+1)/2;
            int newY = y/2;
            if(isPossible(newX1, newY) == 1){
                return ("E" + getMinimumSteps(newX1, newY));
            }
            else{
                return ("W" + getMinimumSteps(newX2, newY));
            }
        }
        else{
            int newY1 = (y-1)/2;
            int newY2 = (y+1)/2;
            int newX = x/2;
            if(isPossible(newX, newY1) == 1){
                return ("N" + getMinimumSteps(newX, newY1));
            }
            else{
                return ("S" + getMinimumSteps(newX, newY2));
            }
        }
        //return "---";
    }

    private static int isPossible(int x, int y){
        if(x == 0 && y == 0)
            return 1;
        int isOddX = isOdd(x);
        int isOddY = isOdd(y);
        if((isOddX == 1 && isOddY == 1) || (isOddX == 0 && isOddY ==0))
            return 0;
        return 1;
    }

    private static int isOdd(int num) {
        if(num % 2 == 1){
            return 1;
        }
        return 0;
    }
}