import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String result = "";
            String number = in.nextLine();
            char[] digits = number.toCharArray();
            int k = 0;
            for (int j = 0; j < digits.length; j++) {
                int current = digits[j] - '0';
                if (k < current) {
                    while (k < current) {
                        result += "(";
                        k++;
                    }
                } else if (k > current) {
                    while (k > current) {
                        result += ")";
                        k--;
                    }
                }
                result += current;
            }
            while (k > 0) {
                k--;
                result += ")";
            }
            System.out.println("Case #" + i + ": " + result);
        }

    }
}