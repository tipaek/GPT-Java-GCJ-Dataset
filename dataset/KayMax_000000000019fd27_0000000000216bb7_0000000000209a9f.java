
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        int cases = in.nextInt();

        for(int i = 1; i <= cases; i++) {
            solve(i);
        }
    }

    public static void solve(int num) {

        String s = in.next();
        int size = s.length();

        s += "0";

        int counter = 1;
        StringBuilder sb = new StringBuilder();
        int current = Integer.parseInt(String.valueOf(s.charAt(0)));
        sb.append("(".repeat(current));

        for(int i = 0; i < size; i++) {
            int next = Integer.parseInt(String.valueOf(s.charAt(counter++)));
            sb.append(current);

            int diff = next - current;

            if(diff > 0)
                sb.append("(".repeat(diff));
            else if(diff < 0)
                sb.append(")".repeat(Math.abs(diff)));

            current = next;
        }

        System.out.printf("Case #%d: %s", num, sb.toString());
    }
}
