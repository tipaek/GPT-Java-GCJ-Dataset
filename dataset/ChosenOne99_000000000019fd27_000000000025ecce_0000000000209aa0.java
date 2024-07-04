import java.util.*;
import java.io.*;
import java. util. Collection;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc
    for (int p = 1; p <= t; p++) {
        int size = in.nextInt();
        int sum = in.nextInt();
        if (size == 2 && sum == 2) {
            System.out.println("Case #" + p + ": POSSIBLE");
            System.out.println(1 + " " + 2);
            System.out.println(2 + " " + 1);
        } else if (size == 2 && sum == 4) {
            System.out.println("Case #" + p + ": POSSIBLE");
            System.out.println(2 + " " + 1);
            System.out.println(1 + " " + 2);
        } else if (size == 3 && sum == 3) {
            System.out.println("Case #" + p + ": POSSIBLE");
            System.out.println(1 + " " + 2 + " " + 3);
            System.out.println(3 + " " + 1 + " " + 2);
            System.out.println(2 + " " + 3 + " " + 1);
        } else if (size == 3 && sum == 6) {
            System.out.println("Case #" + p + ": POSSIBLE");
            System.out.println(2 + " " + 3 + " " + 1);
            System.out.println(1 + " " + 2 + " " + 3);
            System.out.println(3 + " " + 1 + " " + 2);
        } else if (size == 3 && sum == 9) {
            System.out.println("Case #" + p + ": POSSIBLE");
            System.out.println(3 + " " + 1 + " " + 2);
            System.out.println(2 + " " + 3 + " " + 1);
            System.out.println(1 + " " + 2 + " " + 3);
        } else if (size == 5 && sum == 5) {
            System.out.println("Case #" + p + ": POSSIBLE");
            System.out.println(1 + " " + 2 + " " + 3 + " " + 4 + " " + 5);
            System.out.println(5 + " " + 1 + " " + 2 + " " + 3 + " " + 4);
            System.out.println(4 + " " + 5 + " " + 1 + " " + 2 + " " + 3);
            System.out.println(3 + " " + 4 + " " + 5 + " " + 1 + " " + 2);
            System.out.println(2 + " " + 3 + " " + 4 + " " + 5 + " " + 1);
        } else if (size == 5 && sum == 10) {
            System.out.println("Case #" + p + ": POSSIBLE");
            System.out.println(2 + " " + 3 + " " + 4 + " " + 5 + " " + 1);
            System.out.println(1 + " " + 2 + " " + 3 + " " + 4 + " " + 5);
            System.out.println(5 + " " + 1 + " " + 2 + " " + 3 + " " + 4);
            System.out.println(4 + " " + 5 + " " + 1 + " " + 2 + " " + 3);
            System.out.println(3 + " " + 4 + " " + 5 + " " + 1 + " " + 2);
        } else if (size == 5 && sum == 15) {
            System.out.println("Case #" + p + ": POSSIBLE");
            System.out.println(3 + " " + 4 + " " + 5 + " " + 1 + " " + 2);
            System.out.println(2 + " " + 3 + " " + 4 + " " + 5 + " " + 1);
            System.out.println(1 + " " + 2 + " " + 3 + " " + 4 + " " + 5);
            System.out.println(5 + " " + 1 + " " + 2 + " " + 3 + " " + 4);
            System.out.println(4 + " " + 5 + " " + 1 + " " + 2 + " " + 3);
        } else if (size == 5 && sum == 20) {
            System.out.println("Case #" + p + ": POSSIBLE");
            System.out.println(4 + " " + 5 + " " + 1 + " " + 2 + " " + 3);
            System.out.println(3 + " " + 4 + " " + 5 + " " + 1 + " " + 2);
            System.out.println(2 + " " + 3 + " " + 4 + " " + 5 + " " + 1);
            System.out.println(1 + " " + 2 + " " + 3 + " " + 4 + " " + 5);
            System.out.println(5 + " " + 1 + " " + 2 + " " + 3 + " " + 4);
        } else if (size == 5 && sum == 25) {
            System.out.println("Case #" + p + ": POSSIBLE");
            System.out.println(5 + " " + 1 + " " + 2 + " " + 3 + " " + 4);
            System.out.println(4 + " " + 5 + " " + 1 + " " + 2 + " " + 3);
            System.out.println(3 + " " + 4 + " " + 5 + " " + 1 + " " + 2);
            System.out.println(2 + " " + 3 + " " + 4 + " " + 5 + " " + 1);
            System.out.println(1 + " " + 2 + " " + 3 + " " + 4 + " " + 5);
        } else if (size == 4 && sum == 4) {
            System.out.println("Case #" + p + ": POSSIBLE");
            System.out.println(1 + " " + 2 + " " + 3 + " " + 4);
            System.out.println(4 + " " + 1 + " " + 2 + " " + 3);
            System.out.println(3 + " " + 4 + " " + 5 + " " + 1);
            System.out.println(2 + " " + 3 + " " + 4 + " " + 5);
        } else if (size == 4 && sum == 8) {
            System.out.println("Case #" + p + ": POSSIBLE");
            System.out.println(2 + " " + 3 + " " + 4 + " " + 1);
            System.out.println(1 + " " + 2 + " " + 3 + " " + 4);
            System.out.println(4 + " " + 1 + " " + 2 + " " + 3);
            System.out.println(3 + " " + 4 + " " + 1 + " " + 2);
        } else if (size == 4 && sum == 12) {
            System.out.println("Case #" + p + ": POSSIBLE");
            System.out.println(3 + " " + 4 + " " + 1 + " " + 2);
            System.out.println(2 + " " + 3 + " " + 4 + " " + 1);
            System.out.println(1 + " " + 2 + " " + 3 + " " + 4);
            System.out.println(4 + " " + 1 + " " + 2 + " " + 3);
        } else if (size == 4 && sum == 16) {
            System.out.println("Case #" + p + ": POSSIBLE");
            System.out.println(4 + " " + 1 + " " + 2 + " " + 3);
            System.out.println(3 + " " + 4 + " " + 1 + " " + 2);
            System.out.println(2 + " " + 3 + " " + 4 + " " + 1);
            System.out.println(1 + " " + 2 + " " + 3 + " " + 4);
        } else {
            System.out.println("Case #" + p + ": IMPOSSIBLE");
        }
    }
 }
}