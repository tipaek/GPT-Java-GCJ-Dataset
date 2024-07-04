import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

    private Scanner scanner;
    private PrintStream printStream;

    public static void main(String[] args) {
        new Solution().execute(System.in, System.out);
    }

    Solution() {
        // No-op.
    }

    void execute(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        printStream = out;

        int cases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cases; i++) {
            solveCase(i + 1);
        }
    }

    private void solveCase(int caseNo) {
        int u = Integer.parseInt(scanner.nextLine());

        Mapper mapper = new Mapper();
        for (int i = 0; i < 10000; i++) {
            String parts[] = scanner.nextLine().split(" ");
            String num = parts[0];
            String rand = parts.length > 1 ? parts[1] : null;

            mapper.checkPair(num, rand);
        }

        printStream.printf("Case #%d: %s\n", caseNo, mapper.findChars());
    }

    private static class Mapper {
        private final static int MASK = 0B1111111111;
        private HashMap<Character, Integer> possibleValues = new HashMap<>();

        private void checkPair(String num, String rand) {
            if (!num.equals("-1") && rand != null) {
                if (possibleValues.size() < 10) {
                    for (int i = 0; i < rand.length(); i++) {
                        possibleValues.putIfAbsent(rand.charAt(i), MASK);
                    }
                }

                char r0 = rand.charAt(0);

                if (num.length() == rand.length()) {
                    int d0 = num.charAt(0) - '0';

                    int values = possibleValues.get(r0);
                    values = values & ((1 << (d0 + 1)) - 1);
                    possibleValues.put(r0, values);
                }

                if (rand.length() > 1) {
                    int values = possibleValues.get(r0);
                    if (values % 2 == 1) {
                        possibleValues.put(r0, values - 1);
                    }
                }
            }
        }

        @Override
        public String toString() {
            List<String> values = new ArrayList<>();

            for (Map.Entry<Character, Integer> entry : possibleValues.entrySet()) {
                values.add(entry.getKey() + " = " + BigInteger.valueOf(entry.getValue()).toString(2));
            }

            return values.toString();
        }

        private String findChars() {
            TreeSet<Char> set = new TreeSet<>();

            for (Map.Entry<Character, Integer> entry : possibleValues.entrySet()) {
                Char ch = new Char(entry.getKey(), entry.getValue());

                set.add(ch);
            }

            char[] result = new char[possibleValues.size()];

            if (findChars(result, set)) {
                return String.valueOf(result);
            }

            return null;
        }

        private boolean findChars(char[] result, TreeSet<Char> set) {
            if (set.size() == 0) {
                return true;
            } else {
                Char ch = set.first();

                if (ch.values == 0) {
                    return false;
                } else {
                    for (int i = 0; i < 10; i++) {
                        if (ch.hasPossibleValue(i)) {
                            List<Char> removeList = new ArrayList<>();
                            List<Char> addList = new ArrayList<>();

                            set.remove(ch);

                            for (Char ch2 : set) {
                                if (ch2.hasPossibleValue(i)) {
                                    removeList.add(ch2);
                                    addList.add(ch2.removePossibleValue(i));
                                }
                            }

                            set.removeAll(removeList);
                            set.addAll(addList);

                            result[i] = ch.c;
                            if (findChars(result, set)) {
                                return true;
                            }

                            set.removeAll(addList);
                            set.addAll(removeList);
                            set.add(ch);
                        }
                    }
                }
            }

            return false;
        }
    }

    private static class Char implements Comparable<Char> {
        char c;
        int values;
        int numberOfPossibleValues;

        private Char(char c, int values) {
            this.c = c;
            this.values = values;
            numberOfPossibleValues = 0;

            int temp = values;
            while (temp > 0) {
                numberOfPossibleValues += temp % 2;
                temp /= 2;
            }
        }

        private Char(char c, int values, int numberOfPossibleValues) {
            this.c = c;
            this.values = values;
            this.numberOfPossibleValues = numberOfPossibleValues;
        }

        private boolean hasPossibleValue(int value) {
            return (values & (1 << value)) > 0;
        }

        private Char removePossibleValue(int value) {
            if (hasPossibleValue(value)) {
                return new Char(c, values - (1 << value), numberOfPossibleValues - 1);
            }

            return this;
        }

        private Char addPossibleValue(int value) {
            if (!hasPossibleValue(value)) {
                return new Char(c, values + (1 << value), numberOfPossibleValues + 1);
            }

            return this;
        }

        @Override
        public String toString() {
            return String.format("{c=%s, values=%s}", c, BigInteger.valueOf(values).toString(2));
        }

        @Override
        public int compareTo(Char o) {
            return Integer.compare(this.numberOfPossibleValues, o.numberOfPossibleValues);
        }
    }
}
