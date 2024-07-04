
import java.io.ByteArrayInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

/**
 * V2020.1
 * <p>
 * Suitable for regular or interactive problems.
 */
public final class Solution {

    /**
     * Your code here!
     *
     * @param r read input from this
     * @param w write output to this
     */
    public static void solve(Scanner r, PrintWriter w) {
        loopCase(r, (c) -> {
            w.print("Case #" + c + ": ");

            w.println(solveCase(r));
        });
    }

    private static String solveCase(Scanner r) {
        StringBuilder sb = new StringBuilder();

        int i = r.nextInt();
        StringBuilder[] P = new StringBuilder[i];
        // StringBuilder[] P2 = new StringBuilder[i];
        for (int j = 0; j < i; j++) {
            P[j] = new StringBuilder(r.next());
            //  P2[j] = new StringBuilder(P[j]);
        }

        //strip identical non-*

        {
            char l = findNonStarLetterR(P);
            while (l != '*') {
                if (missmatchR(P, l)) {
                    return "*";
                } else {
                    char dropped = dropFirstNonStarR(P);
                    if (dropped != '*') {
                        sb.insert(0, dropped);
                    }
                }
                l = findNonStarLetterR(P);
            }
        }

        {
            char l = findNonStarLetter(P);
            while (l != '*') {
                if (missmatch(P, l)) {
                    return "*";
                } else {
                    char dropped = dropFirstNonStar(P);
                    if (dropped != '*') {
                        sb.append(dropped);
                    }
                }
                l = findNonStarLetter(P);
            }
        }


        // Per case code here
        return sb.toString();
    }

    private static char dropFirstNonStar(StringBuilder[] p) {
        char dropped = '*';
        for (int i = 0; i < p.length; i++) {
            char c = p[i].charAt(0);
            if (c != '*') {
                p[i].deleteCharAt(0);
                dropped = c;
            }
        }
        return dropped;
    }

    private static boolean missmatch(StringBuilder[] p, char l) {
        for (int i = 0; i < p.length; i++) {
            char c = p[i].charAt(0);
            if (c != '*' && c != l) {
                return true;
            }
        }
        return false;
    }

    private static char findNonStarLetter(StringBuilder[] p) {
        for (int i = 0; i < p.length; i++) {
            char c = p[i].charAt(0);
            if (c != '*') return c;
        }
        return '*';
    }

    private static char dropFirstNonStarR(StringBuilder[] p) {
        char dropped = '*';
        for (int i = 0; i < p.length; i++) {
            char c = p[i].charAt(p[i].length() - 1);
            if (c != '*') {
                p[i].deleteCharAt(p[i].length() - 1);
                dropped = c;
            }
        }
        return dropped;
    }

    private static boolean missmatchR(StringBuilder[] p, char l) {
        for (int i = 0; i < p.length; i++) {
            char c = p[i].charAt(p[i].length() - 1);
            if (c != '*' && c != l) {
                return true;
            }
        }
        return false;
    }

    private static char findNonStarLetterR(StringBuilder[] p) {
        for (int i = 0; i < p.length; i++) {
            char c = p[i].charAt(p[i].length() - 1);
            if (c != '*') return c;
        }
        return '*';
    }

    /**
     * Pipes {@link System#in} to {@link #solve} and writes output to {@link System#out}
     *
     * @param args Ignored
     */
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            try (PrintWriter output = new PrintWriter(System.out)) {
                solve(input, output);
            }
        }
    }

    /**
     * Use for unit testing.
     * Pipe a string into {@link #solve} and get result as a string.
     *
     * @param input input string
     * @return output string
     */
    public static String run(final String input) {
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()))) {
            StringWriter out = new StringWriter();
            try (PrintWriter writer = new PrintWriter(out)) {
                solve(scanner, writer);
                return out.toString();
            }
        }
    }

    private static void loopCase(Scanner r, Case perCase) {
        final int loops = r.nextInt();
        for (int i = 1; i <= loops; i++)
            perCase.run(i);
    }

    public interface Case {
        void run(final int c);
    }
}
