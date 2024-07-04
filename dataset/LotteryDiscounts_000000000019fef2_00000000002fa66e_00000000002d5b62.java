import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class Solution {

    static boolean test(Stack<Character> s, int x, int y, int currX, int currY, int depth, int targetDepth, int mult) {

        if (targetDepth == depth) {
            return (x == currX && y == currY);
        }
        int newX = currX + mult;
        s.push('E');
        if (test(s, x, y, newX, currY, depth + 1, targetDepth, mult * 2)) {
            return true;
        }
        s.pop();
        newX = currX - mult;
        s.push('W');
        if (test(s, x, y, newX, currY, depth + 1, targetDepth, mult * 2)) {
            return true;
        }
        s.pop();
        int newY = currY + mult;
        s.push('N');
        if (test(s, x, y, currX, newY, depth + 1, targetDepth, mult * 2)) {
            return true;
        }
        s.pop();
        newY = currY - mult;
        s.push('S');
        if (test(s, x, y, currX, newY, depth + 1, targetDepth, mult * 2)) {
            return true;
        }
        s.pop();
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//         Scanner in = new Scanner(
//                 "4\n" +
//                         "2 3\n" +
//                         "-2 -3\n" +
//                         "3 0\n" +
//                         "-1 1"
//  );


        int t = in.nextInt();
        for (int testCase = 1; testCase <= t; ++testCase) {
            int x = in.nextInt();
            int y = in.nextInt();

            Stack<Character> stack = new Stack();
            System.out.print("Case #" + testCase + ": ");
            boolean found = false;
            for (int i = 1; i <= 8; i++) {
                if (test(stack, x, y, 0, 0, 1, i, 1)) {
                    found = true;
                    for (char c :
                            stack) {
                        System.out.print(c);
                    }
                    System.out.println();
                    break;
                }
            }
            if (!found) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
