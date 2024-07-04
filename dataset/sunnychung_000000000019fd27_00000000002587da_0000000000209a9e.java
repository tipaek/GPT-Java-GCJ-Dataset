import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        new D().run();
    }
}



/**
 * @author sunny
 */
abstract class Solver {
    public abstract String getDataBaseDir();
    public abstract String getDataFilenamePrefix();

    public void run() throws FileNotFoundException {
        run(false);
    }

    public void run(boolean useFile) throws FileNotFoundException {
        String filenamePrefix = getDataFilenamePrefix();
        String baseDir = getDataBaseDir();
        try (
                Scanner in = new Scanner(new BufferedInputStream(useFile ? new FileInputStream(baseDir + filenamePrefix + ".in") : System.in));
                PrintWriter out = new PrintWriter(new BufferedOutputStream(useFile ? new FileOutputStream(baseDir + filenamePrefix + ".out") : System.out))
        ) {
            run(in, out);
        } catch (CallShutdownException ignored) {}
    }

    public void run(Scanner scanner, PrintWriter writer) {
        int T = scanner.nextInt();
//        scanner.nextLine();
        for (int i = 1; i <= T; ++i) {
            solve(i, scanner, writer);
        }
    }

    public abstract void solve(int caseI, Scanner scanner, PrintWriter writer);

    static class CallShutdownException extends RuntimeException {}
}



/**
 * @author sunny
 *
 * Test:
 * python ../interactive_runner.py python ../data/contest/2020/qual/D/local_testing_tool.py 0 -- java -Xms896m -Xmx896m -Xss64m -XX:+UseSerialGC Solution
 */
class D extends Solver {
    static final boolean IS_DEBUG = false;

    int n;

    @Override
    public String getDataBaseDir() {
        return null;
    }

    @Override
    public String getDataFilenamePrefix() {
        return null;
    }

    @Override
    public void solve(int caseI, Scanner scanner, PrintWriter writer) {
        if (IS_DEBUG) {
            System.err.println(">> case #" + caseI);
        }

        if (caseI == 1) {
            n = scanner.nextInt();
            scanner.nextLine();

            if (IS_DEBUG) {
                System.err.println(">> n = " + n);
            }
        }

        try {
            new CaseSolver(n).solve(caseI, scanner, writer);
        } catch (UnexpectedInteractiveException ignored) {
            throw new CallShutdownException();
        }
    }

    static class CaseSolver {
        int n;

        public CaseSolver(int n) {
            this.n = n;
        }

        public void solve(int caseI, Scanner scanner, PrintWriter writer) {
            if (IS_DEBUG) {
                System.err.printf(">> solve case #%d\n", caseI);
            }

            char[] s = new char[n];
            Arrays.fill(s, '?');

            List<String> remainPossibilties = new ArrayList<>();
            remainPossibilties.add(new String(s));

//            if (caseI == 35) {
//                writer.println("1100011101001010110000000110000010010001101010100011001000111000100100010000010000110101001011100011");
//                writer.flush();
//                throw new CallShutdownException();
//            }

            for (int q = 0; ; ++q) {
                boolean queried = false;

                if (IS_DEBUG) {
                    System.err.printf(">>>> q #%d\n", q + 1);
                }

                //TODO
//                if (q >= 149) {
//                    // the last query, try luck
//
//                    String trySol = findMinQPossibility(remainPossibilties)
//                            .map(p -> p.a.replaceAll("\\?", "0"))
//                            .get();
//
//                    attemptSolution(scanner, writer, trySol);
//                    return;
//                }

                if ((q % 10) == 0 && q >= 10) {
                    Set<String> prevPossibilties = new LinkedHashSet<>();
                    if (s != null) {
                        prevPossibilties.add(new String(s));
                    } else {
                        prevPossibilties.addAll(remainPossibilties);
                    }

                    Set<String> possibilities = new LinkedHashSet<>();

                    for (String prevPossibility : prevPossibilties) {

                        String original = prevPossibility;
                        String complemented = complement(original);
                        String reversed = new StringBuilder(original).reverse().toString();
                        String reversedComplemented = complement(reversed);
                        possibilities.add(complemented);
                        possibilities.add(reversed);
                        possibilities.add(reversedComplemented);
                        possibilities.add(original);

                    }

                    remainPossibilties.clear();
                    remainPossibilties.addAll(possibilities);
                    s = null;


                    if (IS_DEBUG) {
                        System.err.println(">>>> Possibilties:");
                        remainPossibilties.forEach(itS -> {
                            System.err.println(">>>>>> " + itS);
                        });
                    }
                }
                if (remainPossibilties.size() > 1) {
                    // find first different

                    int qIdx = selectQueryIndex(remainPossibilties, SelectQMode.NO_Q);

                    if (qIdx < 0) {
                        /**
                         * all same case
                         * 1111111111 11111????? ?????????? ?????11111
                         * 11111????? ?????????? ?????11111 1111111111
                         *
                         * CANNOT handle like this --> take one
                         *
                         * choose first digit + '?'
                         *
                         */

                        if (IS_DEBUG) {
                            System.err.println(">>>> hit undifferentiable Possibilties case");
                        }

                        qIdx = selectQueryIndex(remainPossibilties, SelectQMode.MOST_Q);
                    }

                    if (qIdx < 0) {
                        throw new RuntimeException("what is this case?");
                    }

                    // query and reduce possibiltiees

                    char resp = query(scanner, writer, qIdx + 1);
                    queried = true;
                    int fQIdx = qIdx;
                    remainPossibilties = filterRemainPossibilties(remainPossibilties, fQIdx, resp);

                    if (IS_DEBUG) {
                        System.err.println(">>>> Reduced Possibilties:");
                        remainPossibilties.forEach(itS -> {
                            System.err.println(">>>>>> " + itS);
                        });
                    }


                }
                if (!queried) {
                    if (s == null) {
                        s = remainPossibilties.get(0).toCharArray();
                    }

                    int queryIndex;

                    if (countQ(s) % 2 == 1) {
                        queryIndex = lastIndexOf(s, '?');
                    } else {
                        queryIndex = indexOf(s, '?', 0);
                    }

                    if (queryIndex >= 0) {
                        s[queryIndex] = query(scanner, writer, queryIndex + 1);
                    }

                    if (indexOf(s, '?', 0) < 0) {
                        // found solution
                        attemptSolution(scanner, writer, new String(s));

                        return;
                    }

                }

            }
        }

        void attemptSolution(Scanner scanner, PrintWriter writer, String s) {
            writer.println(s);
            writer.flush();

            char response = scanner.nextLine().charAt(0);

            if (IS_DEBUG) {
                System.err.printf(">>>> Attempt [%s] -> == %c\n", new String(s), response);
                System.err.flush();
            }

            if (response != 'Y') {
                throw new UnexpectedInteractiveException();
            }
        }

        int[] countQs = new int[200];

        int selectQueryIndex(List<String> remainPossibilties, SelectQMode mode) {
            int n = remainPossibilties.get(0).length();

            Arrays.fill(countQs, 0);

            // NO_Q for identifying cases

            for (int i = 0; i < n; ++i) {
                char c = remainPossibilties.get(0).charAt(i);
                if (c == '?') {
                    ++countQs[i];
                }
                for (int j = 1; j < remainPossibilties.size(); ++j) {
                    char cc = remainPossibilties.get(j).charAt(i);
                    switch (mode) {
                        case NO_Q: {
                            if (c != '?' && cc != '?' && cc != c) {
                                return i;
                            }
                        } break;
                        default: {
                            if (cc == '?') {
                                ++countQs[i];
                            }
                        } break;
                    }
                }
            }

            if (mode == SelectQMode.MOST_Q) {

//                int minQPossibilityIdx = findMinQPossibility(remainPossibilties)
//                        .map(s -> {
//                            return s.a.indexOf('?');
//                        })
//                        .get();
//
//                if (minQPossibilityIdx >= 0) {
//                    return minQPossibilityIdx;
//                }

//                // try remain (max)
//                int maxIdx = -1;
//                int maxVal = 0;
//                for (int i = 0; i < n; ++i) {
//                    if (countQs[i] > maxVal) {
//                        maxVal = countQs[i];
//                        maxIdx = i;
//                    }
//                }
//                return maxIdx;

                // try remain (max)
                int minIdx = -1;
                int minVal = Integer.MAX_VALUE;
                for (int i = 0; i < n; ++i) {
                    if (countQs[i] > 0 && countQs[i] < minVal) {
                        minVal = countQs[i];
                        minIdx = i;
                    }
                }
                return minIdx;
//                    System.err.printf(">>>>> WTF ");
//                    Arrays.stream(countQs)
//                            .forEach(i -> System.err.printf("%d ", i));
//                    System.err.println();
//                    return -1;
//                }
            }
            return -1;
        }

        Optional<Pair<String, Integer>> findMinQPossibility(List<String> remainPossibilties) {
            return remainPossibilties.stream()
                    .map(s -> {
                        return new Pair<String, Integer>(s, countQ(s));
                    })
                    .min((o1, o2) -> Integer.compare(o1.b, o2.b));
        }
    }

    static int countQ(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '?') {
                ++cnt;
            }
        }
        return cnt;
    }

    static int countQ(char[] s) {
        int cnt = 0;
        for (int i = 0; i < s.length; ++i) {
            if (s[i] == '?') {
                ++cnt;
            }
        }
        return cnt;
    }

    static class Pair<X, Y> {
        X a;
        Y b;

        public Pair(X a, Y b) {
            this.a = a;
            this.b = b;
        }
    }

    static List<String> filterRemainPossibilties(List<String> remainPossibilties, int qIdx, char qChar) {
        return remainPossibilties.stream()
                .filter(itS -> {
                    return itS.charAt(qIdx) == qChar || itS.charAt(qIdx) == '?';
                })
                .map(itS -> {
                    if (itS.charAt(qIdx) != '?') {
                        return itS;
                    } else {
                        StringBuilder sb = new StringBuilder(itS);
                        sb.setCharAt(qIdx, qChar);
                        return sb.toString();
                    }
                })
                .distinct()
                .collect(Collectors.toList());
    }

    static enum SelectQMode {
        NO_Q, MOST_Q
    }

    static char query(Scanner scanner, PrintWriter writer, int pos) {
        writer.println(pos);
        writer.flush();

        char response = scanner.nextLine().charAt(0);

        if (IS_DEBUG) {
            System.err.printf(">>>> q %d -> %c\n", pos, response);
            System.err.flush();
        }

        if (response < '0' || response > '1') {
            throw new UnexpectedInteractiveException();
        }
        return response;
    }

    static int indexOf(char[] a, char target, int startIdx) {
        for (int i = Math.max(startIdx, 0); i < a.length; ++i) {
            if (target == a[i]) {
                return i;
            }
        }
        return -1;
    }

    static int lastIndexOf(char[] a, char target) {
        for (int i = a.length - 1; i >= 0; --i) {
            if (target == a[i]) {
                return i;
            }
        }
        return -1;
    }

    static String complement(String a) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < a.length(); ++i) {
            char c;
            switch (a.charAt(i)) {
                case '0': { c = '1'; break; }
                case '1': { c = '0'; break; }
                case '?': { c = '?'; break; }
                default: throw new IllegalStateException("unknown char " + a.charAt(i));
            }
            s.append(c);
        }
        return s.toString();
    }

    static class UnexpectedInteractiveException extends RuntimeException {}

//    static String repeat(char c, int count) {
//        StringBuilder s = new StringBuilder();
//        for (int i = 0; i < count; ++i) {
//            s
//        }
//    }
}
