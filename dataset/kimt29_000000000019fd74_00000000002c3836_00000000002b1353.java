import java.util.*;
import java.io.*;
public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            int r = findR(n);
            // System.out.println(r);
            System.out.println("Case #" + i + ":");
            int[] coor = printFullPath(r);
            n -= (int) Math.pow(2, r) - 1;
            printLeg(n, coor);
        }
    }
    
    public static int findR(int n) {
        int r = 1;
        int num = (int) Math.pow(2, r);
        while (n > num) {
            n -= num;
            r++;
            num = (int) Math.pow(2, r);
        }
        return r;
    }
    
    public static int[] printFullPath(int r) {
        System.out.println("1 1");
        int currR = 1;
        int c = 1;
        int[] last = new int[2];
        while (currR < r) {
            currR++;
            if (c != currR) {
                // going forward
                for (c = 1; c <= currR; c++) {
                    System.out.println(currR + " " + c);
                }
                last[0] = currR;
                last[1] = c;
            } else { 
                // going backward
                for (c = currR; c >= 1; c--) {
                    System.out.println(currR + " " + c);
                }
                last[0] = currR;
                last[1] = c;
            }
        }
        return last;
    }
    
    public static void printLeg(int n, int[] coor) {
        if (coor[1] == 1) {
            while (n > 0) {
                System.out.println("1 " + coor[1]);
                coor[1]++;
                n--;
            }
        } else {
            while (n > 0) {
                System.out.println(coor[1] + " " + coor[1]);
                coor[1]++;
                n--;
            }
        }
    }
}