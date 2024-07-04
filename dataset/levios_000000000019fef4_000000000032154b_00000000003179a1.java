
import java.io.*;
import java.util.*;

/**
 * Round 1C - Code Jam 2020
 * B.
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = false; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2020\\r1c\\B\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    static int u;
    private static void solve() {
        u = in.nextInt(); //  10^U - 1 is the incl. upper bound for the range in which we chose the integers Mi to query that server
        List<Long> Qs = new ArrayList<>(); // query: in base 10 using digits 0 through 9, as usual
        List<String> Rs = new ArrayList<>(); // response
        char[] solution = new char[10];
        Map<Long, Set<Character>> cannotBe = new HashMap<>();
        Set<Character> chars = new HashSet<>();
        for (long i = 0; i <= 9; i++) {
//            canBe.put(i, new HashSet<>());
            cannotBe.put(i, new HashSet<>());
        }
        for (int i = 0; i < 10000; i++) {
            long q = in.nextLong();
            Qs.add(q);
            String r = in.next();
            Rs.add(r);
            if (chars.size() < 10) {
                for (int j = 0; j < r.length(); j++) {
                    chars.add(r.charAt(j));
                }
            }
            char firstChar = r.charAt(0);
            int length = String.valueOf(q).length();
            int firstDigit = Integer.parseInt("" + String.valueOf(q).charAt(0));
            if (r.length() == length) {
                for (int j = firstDigit+1; j < 10; j++) {
                    cannotBe.get(j).add(firstChar);
                }
            } else {
                cannotBe.get(0L).add(firstChar);
            }
        }

        // 0
        Set<Character> zero = cannotBe.get(0L);
        for (char c : chars) {
            if (!zero.contains(c)) {
                solution[0] = c;
                chars.remove(c);
                break;
            }
        }

        for (int i = 9; i >=1 ; i--) {
            Set<Character> set = cannotBe.get(i);
            Set<Character> copy = new HashSet<>(chars);
            copy.removeAll(set);
            char c = copy.iterator().next();
            solution[i] = c;
            chars.remove(c);
        }

        String sol = String.valueOf(solution);
        print(sol); // digit string D
    }

    private static void print(String s) {
        out.println(s); out.flush();
        if (debug) System.out.println(s);
    }

    private static Scanner in;
    private static PrintStream out;

    private static void run() throws Exception {
        if (debug) {
            in = new Scanner(new File(IN)); // new Scanner(Quali4.class.getResourceAsStream(IN));
            out = new PrintStream(new FileOutputStream(OUT));
        } else {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            out = System.out;
        }
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            if (debug) System.out.print("Case #" + i + ": ");
            solve();
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        run();
    }
}
