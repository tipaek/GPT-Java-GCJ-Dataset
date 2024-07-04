import java.util.*;

import static java.lang.Math.abs;

/**
 *
 * Each intersection is block away.
 * 
 * You and the cat walk at the same speed: 1minute/block
 *
 * X and Y are initially positive. But you can find the
 * cat in a negative position.
 * What matters is if you can get to the cat at most in
 * his last move.
 *
 * Problem: need to find smallest number of minutes
 *
 */ 
public class Solution {
   


    private static void solve(int t) {
        int X = sc.nextInt();
        int Y = sc.nextInt();
        String M = sc.next();

        int len = M.length();
        int x = X, y = Y;
        int myX = 0, myY = 0;
        int min = 0;
        boolean ok = false;
        for (int i = 0; i < len; ++i) {
            ++min;

            // cat move
            if (M.charAt(i) == 'N') {
                y += 1;
            } else if (M.charAt(i) == 'S') {
                y -= 1;
            } else if (M.charAt(i) == 'E') {
                x += 1;
            } else { // 'W'
                x -= 1;
            }
            if (x == myX && y == myY) {
                ok = true;
                break;
            }

            // try to move closer
            // ? maybe try to decrease bigger gap?
            int diffy = abs(abs(y) - abs(myY));
            int diffx = abs(abs(x) - abs(myX));
            
            if (diffx == diffy) {
                if (i + 1 == len) break;

                if (M.charAt(i) == 'N') {
                    diffy += 1;
                } else if (M.charAt(i) == 'S') {
                    diffy -= 1;
                } else if (M.charAt(i) == 'E') {
                    diffx += 1;
                } else { // 'W'
                    diffx -= 1;
                }
            }
            
            if (diffx > diffy) {
                if (x > myX) {
                    myX += 1;
                } else {
                    myX -= 1;
                }
            } else {
                if (y > myY) {
                    myY += 1;
                } else {
                    myY -= 1;
                }
            }

            if (x == myX && y == myY) {
                ok = true;
                break;
            }
        }
        if (ok)
            System.out.println("Case #" + t + ": " + min);
        else
            System.out.println("Case #" + t + ": IMPOSSIBLE");
    }


    private static Scanner sc;
    public static void main(String args[]) throws Exception {
        sc = new Scanner(System.in);
        
        int T = sc.nextInt();

        for (int t = 1; t <= T; ++t) {
            solve(t);
        }
    }
}

