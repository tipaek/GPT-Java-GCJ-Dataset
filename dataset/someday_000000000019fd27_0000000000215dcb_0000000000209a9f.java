import java.util.*;
import java.io.*;

public class Solution {
    public static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + nestNumbers(scanner.next()));
        }

        scanner.close();
    }

    public static String nestNumbers(String s) {
        StringBuffer sb = new StringBuffer("");
        int alreadyAdded = 0;

        for (char c : s.toCharArray()) {
            int howManyToAdd = c - 48 - alreadyAdded;
            char whatToAdd = howManyToAdd == 0 ? Character.MIN_VALUE : howManyToAdd > 0 ? '(' : ')';

            for (int i = 0; i < Math.abs(howManyToAdd); ++i) {
                sb.append(whatToAdd);
            }
            sb.append(c);

            alreadyAdded += howManyToAdd;
        }

        for (int i = 0; i < alreadyAdded; ++i) {
            sb.append(')');
        }

        return sb.toString();
    }
}