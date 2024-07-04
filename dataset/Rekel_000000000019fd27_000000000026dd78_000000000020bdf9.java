import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException{
        sc = new Scanner(System.in);
        int testen = sc.nextInt();

        for (int test = 1; test <= testen; test++) {
            test(test);
        }
    }

    private static class Act implements Comparable<Act> {
        int b;
        int e;

        Act(int b, int e) {
            this.b = b;
            this.e = e;
        }

        @Override
        public int compareTo(Act o) {
            return o.b - this.b;
        }
    }

    private static void test(int test) {
        int aantal = sc.nextInt();
        Stack<Act> acts = new Stack<Act>();
        for (int a = 0; a < aantal; a++) {
            acts.push(new Act(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(acts);

        String S = "";
        int c = 0;
        int j = 0;
        while (!acts.isEmpty()) {
            Act volgende = acts.pop();
            if (c <= volgende.b) {
                c = volgende.e;
                S += "C";
            } else if (j <= volgende.b) {
                j = volgende.e;
                S += "J";
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", test);
                return;
            }
        }
        System.out.printf("Case #%d: %s\n", test, S);
    }

}