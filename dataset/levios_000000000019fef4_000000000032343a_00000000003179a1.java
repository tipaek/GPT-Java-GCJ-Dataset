
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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
        Map<Character, Long> occurrence = new HashMap<>(); // response
        char[] solution = new char[10];
        Map<Long, Set<Character>> cannotBe = new HashMap<>();
        Set<Character> chars = new HashSet<>();
        for (long i = 0; i <= 9; i++) {
            cannotBe.put(i, new HashSet<>());
        }
        for (int i = 0; i < 10000; i++) {
            long q = in.nextLong();
            String r = in.next();
            if (chars.size() < 10) {
                for (int j = 0; j < r.length(); j++) {
                    chars.add(r.charAt(j));
                }
            }
            char firstChar = r.charAt(0);
            if (!occurrence.containsKey(firstChar)) {
                occurrence.put(firstChar, 1L);
            } else {
                long l = occurrence.get(firstChar);
                occurrence.put(firstChar, l + 1L);
            }
            cannotBe.get(0L).add(firstChar);
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

        List<Map.Entry<Character, Long>> sorted = occurrence.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());

        for (int i = 0; i < sorted.size(); i++) {
            solution[9-i] = sorted.get(i).getKey();
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
