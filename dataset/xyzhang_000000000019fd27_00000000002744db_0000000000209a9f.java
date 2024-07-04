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
                for (int j = 0; j < next - counter; j++) {
                    s.append("(");
                }
            } else if (next - counter < 0) {
                for (int j = 0; j <  counter - next; j++) {
                    s.append(")");
                }
            }
            counter = next;
            s.append(next);
        }
        for (int j = 0; j <  counter; j++) {
            s.append(")");
        }
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
