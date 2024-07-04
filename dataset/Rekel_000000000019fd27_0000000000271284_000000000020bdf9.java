import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int testen = sc.nextInt();

        for (int test = 1; test <= testen; test++) {
            test(test);
        }
    }

    private static class Act implements Comparable<Act> {
        int b;
        int e;
        public char persoon;

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
        Stack<Act> actStack = new Stack<Act>();
        Act[] acts = new Act[aantal];
        
        for (int a = 0; a < aantal; a++) {
            Act act = new Act(sc.nextInt(), sc.nextInt());
            actStack.push(act);
            acts[a] = act;
        }
        Collections.sort(actStack);

        String S = "";
        int c = 0;
        int j = 0;
        while (!actStack.isEmpty()) {
            Act volgende = actStack.pop();
            if (c <= volgende.b) {
                c = volgende.e;
                volgende.persoon = 'C';
            } else if (j <= volgende.b) {
                j = volgende.e;
                volgende.persoon = 'J';
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", test);
                return;
            }
        }

        for (Act a : acts) {
            S += a.persoon;
        }
        System.out.printf("Case #%d: %s\n", test, S);
    }
}