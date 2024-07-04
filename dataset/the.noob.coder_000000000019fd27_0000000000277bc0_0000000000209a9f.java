import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solver solver = new Solver();

        int t = sc.nextInt();

        for (int i=0; i<t; i++) {
            String s = sc.next();
            System.out.println(solver.solve(s, i+1));
        }
    }
}

class Solver {
    public String solve(String s, int testNum) {
        return "Case #"+ testNum+ ": " + solve(s);
    }

    String solve(String s) {
        int i =0;
        while (i+1 < s.length() && s.charAt(i) >= s.charAt(i+1)) {
            i++;
        }
        if (i < s.length()-1) {
            return solveNonInc(s.substring(0, i+1)) + solve(s.substring(i+1));
        }
        return solveNonInc(s.substring(0, i+1));

    }

    String solveNonInc(String s) {
        int length = s.length();

        Stack<String> stack = new Stack<String>();

        for (int i=length-1; i>=0; i--) {
            int c = s.charAt(i)-'0';
            int diff;
            if (i == length-1) {
                diff = c;
            }
            else {
                diff = s.charAt(i)-s.charAt(i+1);
            }

            for (int j =0; j<diff; j++) {
                stack.push(")");
            }
            stack.push(c+"");
        }

        for (int i =0; i< (s.charAt(0)-'0'); i++) {
            stack.push("(");
        };

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}