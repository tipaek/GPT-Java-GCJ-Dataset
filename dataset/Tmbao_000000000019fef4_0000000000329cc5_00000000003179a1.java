import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.LinkedList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Overrandomized solver = new Overrandomized();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static final class Overrandomized {
        private char[] outcome;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            final int U = in.nextInt();
            final int recordSize = 10000;
            List<Overrandomized.Record> records = new ArrayList<>();
            Map<Character, Overrandomized.Possibility> secret = new HashMap<>();
            for (int i = 0; i < recordSize; ++i) {
                records.add(new Overrandomized.Record(in.nextLong(), in.next()));
                syncSecret(secret, records.get(i).r);
                secret.get(records.get(i).r.charAt(0)).removeRange(0, 0);
            }

            for (int rep = 0; rep < 2; ++rep) {
                for (int i = 0; i < recordSize; ++i) {
                    Overrandomized.Record record = records.get(i);
                    if (record.q != -1) {
                        deriveSecret(secret, record.qStr, record.r);
                    }
                }
                tryEliminate(secret);
            }

            out.print(String.format("Case #%d: ", testNumber));
            for (int i = 0; i < 10; ++i) {
                out.print(outcome[i]);
            }
            out.println();
        }

        private void tryEliminate(Map<Character, Overrandomized.Possibility> secret) {
            boolean[] available = new boolean[10];
            Arrays.fill(available, true);
            outcome = null;
            LinkedList<Character> characters = new LinkedList<>();
            LinkedList<Integer> digits = new LinkedList<>();
            Set<Character> charsLeft = new HashSet<>(secret.keySet());
            for (Map.Entry<Character, Overrandomized.Possibility> entry : secret.entrySet()) {
                char chr = entry.getKey();
                charsLeft.remove(chr);
                characters.add(chr);
                Overrandomized.Possibility possibility = entry.getValue();
                for (int d = 0; d < 10; ++d) {
                    if (possibility.ok[d]) {
                        digits.add(d);
                        available[d] = false;
                        if (!eliminate(secret, charsLeft, available, characters, digits)) {
                            possibility.removeRange(d, d);
                        }
                        available[d] = true;
                        digits.removeLast();
                    }
                }
                characters.removeLast();
                charsLeft.add(chr);
            }
        }

        private boolean eliminate(Map<Character, Overrandomized.Possibility> secret, Set<Character> charsLeft, boolean[] available, LinkedList<Character> characters, LinkedList<Integer> digits) {
            if (charsLeft.isEmpty()) {
                outcome = new char[10];
                Iterator<Character> charIter = characters.iterator();
                Iterator<Integer> digIter = digits.iterator();
                while (digIter.hasNext()) {
                    int digit = digIter.next();
                    char chr = charIter.next();
                    outcome[digit] = chr;
                }
                return true;
            }

            char c = charsLeft.iterator().next();
            charsLeft.remove(c);
            characters.add(c);
            Overrandomized.Possibility possibility = secret.get(c);
            boolean solvable = false;
            for (int d = 0; d < 10; ++d) {
                if (possibility.ok[d] && available[d]) {
                    available[d] = false;
                    digits.add(d);
                    if (eliminate(secret, charsLeft, available, characters, digits)) {
                        solvable = true;
                    }
                    digits.removeLast();
                    available[d] = true;

                    if (solvable) {
                        break;
                    }
                }
            }
            characters.removeLast();
            charsLeft.add(c);
            return solvable;
        }

        private static void syncSecret(Map<Character, Overrandomized.Possibility> secret, String result) {
            for (char c : result.toCharArray()) {
                if (!secret.containsKey(c)) {
                    secret.put(c, new Overrandomized.Possibility());
                }
            }
        }

        private static void deriveSecret(Map<Character, Overrandomized.Possibility> secret, String query, String result) {
            if (query.isEmpty() || result.isEmpty()) {
                return;
            }
            query.replaceFirst("^0+(?!$)", "");
            result.replaceFirst("^0+(?!$)", "");
            if (query.length() == result.length()) {
                int firstQueryDigit = Integer.valueOf(query.substring(0, 1));
                Overrandomized.Possibility possibility = secret.get(result.charAt(0));
                possibility.removeRange(firstQueryDigit + 1, 9);
                Integer value = possibility.getValue();
                if (value != null && value == firstQueryDigit) {
                    deriveSecret(secret, query.substring(1), result.substring(1));
                }
            }
        }

        public static final class Record {
            public final long q;
            public final String qStr;
            public final String r;

            private Record(long q, String r) {
                this.q = q;
                this.r = r;

                this.qStr = String.valueOf(q);
            }

        }

        public static final class Possibility {
            public final boolean[] ok;

            private Possibility() {
                ok = new boolean[10];
                Arrays.fill(ok, true);
            }

            public void removeRange(int l, int h) {
                for (int i = l; i <= h; ++i) {
                    ok[i] = false;
                }
            }

            public Integer getValue() {
                Integer value = null;
                for (int i = 0; i < 10; ++i) {
                    if (ok[i]) {
                        if (value == null) {
                            value = i;
                        } else {
                            return null;
                        }
                    }
                }
                return value;
            }

        }

    }
}

