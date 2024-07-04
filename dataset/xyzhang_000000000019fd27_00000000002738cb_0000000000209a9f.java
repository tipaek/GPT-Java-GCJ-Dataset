import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    static void test(int cases, Scanner sc) {
        String input = sc.next();
        StringBuilder s = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            int next = (int) input.charAt(i) - 48;
            if (next - counter > 0) {
                s.append("(".repeat(next - counter));
            } else if (next - counter < 0) {
                s.append(")".repeat(counter - next));
            }
            counter = next;
            s.append(next);
        }
        s.append(")".repeat(counter));
        System.out.println("Case #" + cases + ": " + s.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        for (int i = 1; i <= cases; i++) {
            test(i, sc);
        }
    }
}
