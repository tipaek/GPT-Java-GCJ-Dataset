import java.util.*;
import java.io.*;
class Solution {

    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strings = new String[scanner.nextInt()];

        for (int i = 0; i < strings.length; i++) {
            strings[i] = scanner.next();

        }

        for (int i = 0; i < strings.length; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            printInfo(strings[i]);
            if (i != strings.length - 1) {
                System.out.print("\n");
            }

        }

    }

    public static void makeString(String s) {
        int depth = 0;
        int diff = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int nextInt = Character.getNumericValue(s.charAt(i));
            diff = nextInt - depth;

            result += parenthesesToAdd(diff) + nextInt;

            depth = nextInt;

        }

        result += parenthesesToAdd(-depth);

        System.out.print(result);

    }

    public static String parenthesesToAdd(int difference) {
        String answer = "";

        if (difference > 0) {
            for (int i = 0; i < difference; i++) {
                answer += "(";
            }
        } else if (difference < 0) {
            for (int i = 0; i < -difference; i++) {
                answer += ")";
            }
        }
        return answer;

    }
}
