import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static boolean solve(Scanner input, long b) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int minR = 1000000000 / 2;
        long r = 1000000000 - 5;
        int max = 5;
        int min = -5 ;
        int centX = random.nextInt((max - min) + 1) + min;
        int centY = random.nextInt((max - min) + 1) + min;
        long x = 0;
        long y = 0;
        boolean hit = false;
        boolean horizontal = true;
        boolean positive = false;
        boolean movePositive = false;
        boolean prevHit = true;
        long startX = 0;
        long startY = 0;
        long centerX = 0;
        long centerY = 0;
        long upX = 0;
        long upY = 0;
        long downX = 0;
        long downY = 0;
        long init = 1L << 31;
        long current = init;
        long lastHitX = 0;
        long lastHItY = 0;

        startX = 0;
        startY = 0;
//        System.out.println("" + startX + " " + startY);
//        String next = input.next();
//        if (next.charAt(0) != 'H') {
//            if (next.charAt(0) == 'C') {
//               return true;
//            }
//            startX = -minR;
//            startY = minR;
//            System.out.println("" + startX + " " + startY);
//            next = input.next();
//            if (next.charAt(0) != 'H') {
//                if (next.charAt(0) == 'C') {
//                    return true;
//                }
//                startX = minR;
//                startY = -minR;
//                System.out.println("" + startX + " " + startY);
//                next = input.next();
//                if (next.charAt(0) != 'H') {
//                    if (next.charAt(0) == 'C') {
//                        return true;
//                    }
//                    startX = minR;
//                    startY = minR;
//                    System.out.println("" + startX + " " + startY);
//                    next = input.next();
//                    if (next.charAt(0) != 'H') {
//                        if (next.charAt(0) == 'C') {
//                            return true;
//                        }
//                        startX = 0;
//                        startY = 0;
//                    }
//
//                }
//
//            }
//        }
        while (true) {
            if (horizontal) {
                if (movePositive)
                    x += current;
                else
                    x -= current;
            } else {
                if (movePositive)
                    y += current;
                else
                    y -= current;
            }
            System.out.println("" + x + " " + y);
//            if (x == centX && y == centY) {
//                return true;
//            } else {
//                hit = Math.sqrt((x - centX) * (x - centX) + (y - centY) * (y - centY)) <= r;
//            }
            String s = input.next();
            if (s.charAt(0) == 'C')
                return true;
            else if (s.charAt(0) == 'W')
                return false;
            hit = s.charAt(0) == 'H';
            if (hit) {
                if (horizontal)
                    lastHitX = x;
                else
                    lastHItY = y;
            }
            if (current <= 1) {
                if (horizontal) {
                    if (positive) {
                        upX = lastHitX;
                        movePositive = false;
                        positive = false;
                        horizontal = false;
                        centerX = (upX + downX) / 2;
                        current = init;
                        prevHit = true;
                        x = startX;
                    } else {
                        downX = lastHitX;
                        movePositive = true;
                        positive = true;
                        current = init;
                        prevHit = true;
                        x = startX;
                    }
                } else {
                    if (positive) {
                        upY = lastHItY;
                        centerY = (upY + downY) / 2;
//                        System.out.println("" + upX + " " + downX + " " + upY + " " + downY);
                        System.out.println("" + centerX + " " + centerY);
//                        System.out.println("" + centX + " " + centY);
//                        if (centerX == centX && centerY == centY) {
                        if (input.next().charAt(0) == 'C') {
                            return true;
                        } else {
                            return false;
                        }
                        //end
                    } else {
                        downY = lastHItY;
                        movePositive = true;
                        positive = true;
                        current = init;
                        prevHit = true;
                        y = startY;
                    }
                }
            } else {
                current = current >> 1;
                if ((hit && !prevHit) || (!hit && prevHit)) {
                    prevHit = hit;
                    movePositive = !movePositive;
                }
            }

        }
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        long t = input.nextLong();
        long a = input.nextLong();
        long b = input.nextLong();
        input.nextLine();
        for (long ks = 1; ks <= t; ks++) {
            if (!solve(input, b))
                break;
        }
    }
}