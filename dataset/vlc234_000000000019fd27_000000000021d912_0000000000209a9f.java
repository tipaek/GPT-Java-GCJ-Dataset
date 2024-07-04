import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            solve(i, in.next());
        }

    }

    private static void solve(int index, String input) {
        System.out.println("Case #" + index + ": " + printNested(input));
    }
    
    private static String printNested(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        int prevValue = 0;
        int value = 0;
        int delta;
        for (int i = 0, length = input.length(); i < length; i++) {
            value = Character.getNumericValue(input.charAt(i));
            delta = value - prevValue;
            for (int n = 0, count = Math.abs(delta); n < count; n++) {
                stringBuilder.append(delta > 0 ? "(" : ")");
            }
            stringBuilder.append(value);
            prevValue = value;
        }
        for (int i = 0; i < value; i++) {
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }
}