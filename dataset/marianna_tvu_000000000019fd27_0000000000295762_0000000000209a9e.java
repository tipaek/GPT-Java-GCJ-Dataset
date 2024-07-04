import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        int len = sc.nextInt();
        for (int i = 0; i < numTests; i++) {
            String answer = guess(sc, len);
            if (answer.equals("N")) {
                sc.close();
                break;
            }
        }
    }

    public static String guess(Scanner sc, int len) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> ll = new LinkedList<>();
        int i = len/2;
        int j = i+1;
        int guesses = 5;

        boolean diffInit = false;
        boolean eqInit = false;
        int[] diff = new int[2];
        int[] eq = new int[2];
        while(ll.size() < len) {
            //find equal
            //find different
            for (int k = 0; k < guesses && i > 0 && j <= len; k++) {
                System.out.println(i);
                int iRes = sc.nextInt();
                ll.addFirst(iRes);

                System.out.println(j);
                int jRes = sc.nextInt();
                ll.addLast(jRes);

                if (iRes == jRes && !eqInit) {
                    eq[0] = iRes;
                    eq[1] = i;
                    eqInit = true;
                }
                if (iRes != jRes && !diffInit) {
                    diff[0] = iRes;
                    diff[1] = i;
                    diffInit = true;
                }
                j++;
                i--;
            }
            // find changes
            // all elems different
            int tempGuesses = 5;
            if (!eqInit) {
                System.out.println(diff[1]);
                int dCh0 = sc.nextInt();
                System.out.println(diff[1]);
                dCh0 = sc.nextInt();
                tempGuesses--;
                if (diff[0] != dCh0) {
                    diff[0] = dCh0;
                    ll = complement(ll);
                }
            }
            // all elems eqal
            else if (!diffInit) {
                System.out.println(eq[1]);
                int eqCh = sc.nextInt();
                System.out.println(eq[1]);
                eqCh = sc.nextInt();
                tempGuesses--;
                if (eqCh != eq[0]) {
                    eq[0] = eqCh;
                    ll = complement(ll);
                }
            } else { //
                // found different and equal
                System.out.println(diff[1]);
                int diffCh = sc.nextInt();
                tempGuesses--;
                System.out.println(eq[1]);
                int eqCh = sc.nextInt();
                if (diff[0] == diffCh) {
                    // c + f || n
                    if (eq[0] != eqCh) {
                        // c + f
                        ll = complement(ll);
                        ll = flip(ll);
                    }
                } else {
                    // f || c
                    if (eq[0] == eqCh) {
                        // f
                        ll = flip(ll);
                    } else {
                        // c
                        ll = complement(ll);
                    }
                }
                eq[0] = eqCh;
                diff[0] = diffCh;
            }
            guesses = tempGuesses;
        }
        for (Integer num : ll) {
            sb.append(num);
        }
        System.out.println(sb);
        return sc.next();
    }

    private static Deque<Integer> flip(Deque<Integer> ll) {
        Deque<Integer> temp = new LinkedList<>();
        while (!ll.isEmpty()) {
            temp.addLast(ll.pollLast());
        }
        return temp;
    }

    private static Deque<Integer> complement(Deque<Integer> ll) {
        return ll.stream().map(f -> f == 0 ? 1 : 0).collect(Collectors.toCollection(LinkedList::new));
    }
}