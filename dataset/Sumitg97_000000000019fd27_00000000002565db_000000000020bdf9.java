import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    public static boolean isOverlapping(int x1, int x2, int y1, int y2) {
        return x1 < y2 && y1 < x2;
    }

    public static boolean validateOverlapping(int [][]array , int x , int y, int counter)   {
        int i = 0, j = 0;
        for(i = 0;i < counter ; i++) {
            if(isOverlapping(array[i][0], array[i][1], x, y)) {
                return false;
            }
        }
        array[counter][0] = x;
        array[counter][1] = y;
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseCounter = 1;
        while(t-->0) {
            int n = sc.nextInt();
            String s = "";
            int arr[][] = new int[n][2];
            int c[][] = new int[n][2];
            int j[][] = new int[n][2];
            int i = 0, ccount = 0, jcount = 0, k = 0;
            for(i = 0 ; i < n ; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            for(i = 0 ; i < n ; i++) {
                if(validateOverlapping(c,arr[i][0],arr[i][1],ccount)) {
                    s = s + "C";
                    ccount++;
                }
                else if(validateOverlapping(j,arr[i][0],arr[i][1],jcount)){
                    s = s + "J";
                    jcount++;
                }
                else {
                    s = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + caseCounter + ": " + s);
           
            caseCounter++;
        }
    }
}
