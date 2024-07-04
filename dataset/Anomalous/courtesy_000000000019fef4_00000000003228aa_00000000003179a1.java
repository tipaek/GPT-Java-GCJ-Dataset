import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);
    public static OutputWriter outputWriter = new OutputWriter();

    public static void main(String[] args) throws Exception {
        int testCases = scanner.nextInt();
        for (int cs = 1; cs <= testCases; cs++) {
            int U = scanner.nextInt();
            Map<Character, Set<Integer>> charDigitMap = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                String M = scanner.next();
                String R = scanner.next();
                processStrings(M, R, charDigitMap);
            }

            String result = findResult(charDigitMap);
            System.out.println("Case #" + cs + ": " + result);
        }
    }

    private static void processStrings(String m, String r, Map<Character, Set<Integer>> charDigitMap) {
        for (int i = 0; i < r.length(); i++) {
            char currentChar = r.charAt(i);
            charDigitMap.putIfAbsent(currentChar, new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
        }

        if (m.length() == r.length()) {
            Set<Integer> digitSet = charDigitMap.get(r.charAt(0));
            int firstDigit = m.charAt(0) - '0';
            digitSet.remove(0);
            for (int i = firstDigit + 1; i <= 9; i++) {
                digitSet.remove(i);
            }
        }
    }

    private static String findResult(Map<Character, Set<Integer>> charDigitMap) throws Exception {
        char[] result = new char[10];
        Set<Integer> usedDigits = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            List<Character> possibleChars = new ArrayList<>();
            for (char currentChar = 'A'; currentChar <= 'Z'; currentChar++) {
                if (charDigitMap.containsKey(currentChar)) {
                    Set<Integer> digitSet = new HashSet<>(charDigitMap.get(currentChar));
                    digitSet.removeAll(usedDigits);

                    if (digitSet.contains(i)) {
                        if (digitSet.size() == 1) {
                            possibleChars.clear();
                            possibleChars.add(currentChar);
                            break;
                        }
                        possibleChars.add(currentChar);
                    }
                }
            }

            if (possibleChars.size() > 1) {
                throw new Exception("Ambiguous character mapping");
            }

            usedDigits.add(i);
            result[i] = possibleChars.get(0);
        }

        return new String(result);
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }
}