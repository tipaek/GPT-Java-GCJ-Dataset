import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Solution {

    public static boolean debug = false;
    public static boolean fromFile = false;
    public static String inputFile = "testB.in";

    public static PrintWriter writer;
    public static Scanner scanner;

    public static void debugPrintln(String s) {
        if (debug) {
            writer.println(s);
        }
    }

    public static void debugPrint(String s) {
        if (debug) {
            writer.print(s);
        }
    }

    public static long now() {
        return System.nanoTime();
    }

    public static double round(double value, int digits) {
        double factor = Math.pow(10, digits);
        return Math.round(value * factor) / factor;
    }

    public static void printTime(long start, long end) {
        long elapsed = end - start;
        double msPerNs = 1e-6;
        debugPrintln("Ms elapsed: " + round(elapsed * msPerNs, 4) + " (" + round(start * msPerNs, 4) + ", " + round(end * msPerNs, 4) + ")");
    }

    public static class Digit implements Comparable<Digit> {
        char character;
        int count;
        Set<Integer> possibilities;

        public Digit(char character) {
            this.character = character;
            this.count = 1;
            this.possibilities = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        }

        @Override
        public String toString() {
            return String.valueOf(character);
        }

        @Override
        public int compareTo(Digit other) {
            return Integer.compare(this.count, other.count);
        }

        public void cannotBeAbove(int x) {
            possibilities.removeIf(i -> i > x || i == 0);
        }

        public void cannotBe(int x) {
            possibilities.remove(x);
        }

        public void incrementCount() {
            count++;
        }

        public boolean canBe(int x) {
            return possibilities.contains(x);
        }

        public boolean mustBe(int x) {
            return canBe(x) && possibilities.size() == 1;
        }
    }

    public static String solveCase1() {
        Map<Character, Digit> counts = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            if (i > 0) {
                scanner.nextLong();
            }
            String m = scanner.next();

            for (char c : m.toCharArray()) {
                counts.computeIfAbsent(c, Digit::new).incrementCount();
            }
        }

        List<Digit> digits = new ArrayList<>(counts.values());
        Collections.sort(digits);

        StringBuilder answer = new StringBuilder();
        answer.append(digits.get(0));

        for (int i = 9; i >= 1; i--) {
            answer.append(digits.get(i));
        }

        return answer.toString();
    }

    public static int getFirstDigit(long number) {
        return Integer.parseInt(String.valueOf(Long.toString(number).charAt(0)));
    }

    public static int getLength(long number) {
        return Long.toString(number).length();
    }

    public static String solveCase2(long q) {
        Map<Character, Digit> counts = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            if (i > 0) {
                q = scanner.nextLong();
            }
            String m = scanner.next();

            for (int j = 0; j < m.length(); j++) {
                char c = m.charAt(j);
                Digit digit = counts.computeIfAbsent(c, Digit::new);

                if (j == 0) {
                    digit.cannotBe(0);
                    if (m.length() == getLength(q)) {
                        digit.cannotBeAbove(getFirstDigit(q));
                    }
                }
            }
        }

        Set<Integer> unmatched = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        char[] answer = new char[10];

        while (!unmatched.isEmpty()) {
            boolean foundMatch = false;
            int matchedInt = -1;
            char matchedChar = ' ';

            for (int x : unmatched) {
                Set<Character> possibleChars = new HashSet<>();
                for (Digit digit : counts.values()) {
                    if (digit.canBe(x)) {
                        possibleChars.add(digit.character);
                    }
                }

                if (possibleChars.size() == 1) {
                    matchedInt = x;
                    matchedChar = possibleChars.iterator().next();
                    foundMatch = true;
                    break;
                }
            }

            if (!foundMatch) {
                for (Digit digit : counts.values()) {
                    if (digit.possibilities.size() == 1) {
                        matchedChar = digit.character;
                        matchedInt = digit.possibilities.iterator().next();
                        foundMatch = true;
                        break;
                    }
                }
            }

            if (foundMatch) {
                answer[matchedInt] = matchedChar;
                unmatched.remove(matchedInt);
                counts.remove(matchedChar);

                for (Digit digit : counts.values()) {
                    digit.cannotBe(matchedInt);
                }
            }
        }

        return new String(answer);
    }

    public static void processCase(int caseNum) {
        int u = scanner.nextInt();
        long q = scanner.nextLong();
        String answer = (q == -1) ? solveCase1() : solveCase2(q);
        writer.print("Case #" + caseNum + ": " + answer);
    }

    public static void main(String[] args) throws Exception {
        scanner = fromFile ? new Scanner(new File(inputFile)) : new Scanner(System.in);
        writer = new PrintWriter(System.out);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            processCase(i + 1);
            if (i < t - 1) {
                writer.println();
            }
        }

        writer.close();
        scanner.close();
    }
}