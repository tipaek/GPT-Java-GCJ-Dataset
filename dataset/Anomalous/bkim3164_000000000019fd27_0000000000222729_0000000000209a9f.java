import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            solve(in);
            System.out.println();
        }
        in.close();
    }

    static void solve(Scanner in) {
        String s = in.next();
        StringBuilder result = new StringBuilder();
        int previous = 0;

        for (char c : s.toCharArray()) {
            int current = c - '0';
            while (previous < current) {
                result.append('(');
                previous++;
            }
            while (previous > current) {
                result.append(')');
                previous--;
            }
            result.append(c);
        }
        
        while (previous > 0) {
            result.append(')');
            previous--;
        }

        System.out.print(result.toString());
    }
}