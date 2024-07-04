import java.util.*;
import java.io.*;
public class Solution {
    static int dist = (int) (1e9 / 2);
    static String read;
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); int a = sc.nextInt(); int b = sc.nextInt();
        for (int p = 1; p <= t; p++) {
            int xInit = -1; int yInit = -1; read = "";
            System.out.println(-dist + " " + dist);
            System.out.flush();
            read = sc.next();
            if (read.equals("HIT")) {
                xInit = -dist; yInit = dist;
            } else if (read.equals("CENTER")) continue;
            System.out.println(dist + " " + dist);
            System.out.flush();  read = sc.next();
            if (read.equals("HIT")) {
                xInit = dist; yInit = dist;
            } else if (read.equals("CENTER")) continue;
            System.out.println(dist + " " + -dist);
            System.out.flush();  read = sc.next();
            if (read.equals("HIT")) {
                xInit = dist; yInit = dist;
            } else if (read.equals("CENTER")) continue;
            System.out.println(-dist + " " + -dist);
            System.out.flush();  read = sc.next();
            if (read.equals("HIT")) {
                xInit = -dist; yInit = -dist;
            } else if (read.equals("CENTER")) continue;
            System.out.println(0 + " " + 0);
            System.out.flush();  read = sc.next();
            if (read.equals("HIT")) {
                xInit = 0; yInit = 0;
            } else if (read.equals("CENTER")) continue;
            int lo = yInit; int hi = 2 * dist; boolean finish = false; int loPrev = lo; int hiPrev = hi;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                System.out.println(xInit + " " + mid);
                System.out.flush(); read = sc.next();
                if (read.equals("HIT")) {
                    lo = mid;
                } else if (read.equals("CENTER")) {
                    finish = true;
                    break;
                } else {
                    hi = mid - 1;
                }
                if (loPrev == lo && hiPrev == hi) {
                    break;
                } else {
                    loPrev = lo; hiPrev = hi;
                }
            }
            if (finish) continue;
            int upperChord = hi;
            lo = - 2 * dist; hi = yInit; finish = false;  loPrev = lo; hiPrev = hi;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                System.out.println(xInit + " " + mid);
                System.out.flush(); read = sc.next();
                if (read.equals("HIT")) {
                    hi = mid;
                } else if (read.equals("CENTER")) {
                    finish = true;
                    break;
                } else {
                    lo = mid + 1;
                }
                if (loPrev == lo && hiPrev == hi) {
                    break;
                } else {
                    loPrev = lo; hiPrev = hi;
                }
            }
            if (finish) continue;
            int lowerChord = lo;
            int finalY = (lowerChord + upperChord) / 2;
            lo = - 2 * dist; hi = xInit; loPrev = lo; hiPrev = hi;
            while (lo < hi) {
                if (hi == 2 * dist && lo == 2 * dist - 1) break;
                int mid = (lo + hi) / 2;
                System.out.println(mid + " " + finalY);
                System.out.flush(); read = sc.next();
                if (read.equals("HIT")) {
                    hi = mid;
                } else if (read.equals("CENTER")) {
                    finish = true;
                    break;
                } else {
                    lo = mid + 1;
                }
                if (loPrev == lo && hiPrev == hi) {
                    break;
                } else {
                    loPrev = lo; hiPrev = hi;
                }
            }
            if (finish) continue;
            int left = lo;
            lo = xInit; hi = 2 * dist; loPrev = lo; hiPrev = hi;
            while (lo < hi) {
                if (hi == 2 * dist && lo == 2 * dist - 1) break;
                int mid = (lo + hi) / 2;
                System.out.println(mid + " " + finalY);
                System.out.flush(); read = sc.next();
                if (read.equals("HIT")) {
                    lo = mid;
                } else if (read.equals("CENTER")) {
                    finish = true;
                    break;
                } else {
                    hi = mid - 1;
                }
                if (loPrev == lo && hiPrev == hi) {
                    break;
                } else {
                    loPrev = lo; hiPrev = hi;
                }
            }
            if (finish) continue;
            int right = hi;
            int finalX = (left + right) / 2;
            System.out.println(finalX + " " + finalY);
            System.out.flush(); read = sc.next();
            continue;
        }

    }

}