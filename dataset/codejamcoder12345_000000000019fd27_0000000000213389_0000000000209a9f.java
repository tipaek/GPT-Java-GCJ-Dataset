import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int c = 0; c < t; c++) {
            System.out.print("Case #" + String.valueOf(c+1) + ": ");
            int depth = 0;
            String line = in.next();
            for (int i = 0; i < line.length(); i++) {
                int num = line.charAt(i) - '0';
                if (num == depth) {
                    System.out.print(String.valueOf(num));
                } else if (num > depth) {
                    for (int j = 0; j < num - depth; j++) {
                        System.out.print("(");
                    }
                    depth = num;
                    System.out.print(String.valueOf(num));
                } else if (num < depth) {
                    for (int j = 0; j < depth - num; j++) {
                        System.out.print(")");
                    }
                    depth = num;
                    System.out.print(String.valueOf(num));
                }
            }
            while (depth > 0) {
                System.out.print(")");
                depth--;
            }
            System.out.println();
        }
    }
}