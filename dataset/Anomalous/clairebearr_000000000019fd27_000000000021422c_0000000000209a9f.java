import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            String s = sc.next();
            int openBrackets = 0;
            System.out.print("Case #" + test + ": ");
            for (int i = 0; i < s.length(); i++) {
                int currentDigit = Character.getNumericValue(s.charAt(i));
                if (currentDigit > openBrackets) {
                    for (int j = 0; j < currentDigit - openBrackets; j++) {
                        System.out.print('(');
                    }
                    openBrackets = currentDigit;
                } else if (currentDigit < openBrackets) {
                    for (int j = 0; j < openBrackets - currentDigit; j++) {
                        System.out.print(')');
                    }
                    openBrackets = currentDigit;
                }
                System.out.print(currentDigit);
            }
            for (int i = 0; i < openBrackets; i++) {
                System.out.print(')');
            }
            System.out.println();
        }
    }
}