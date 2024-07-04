import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    private static class BitSet {
        private Boolean[] values;

        public BitSet(int size) {
            values = new Boolean[size];
        }

        public void set(int idx, boolean value) {
            values[idx] = value;
        }

        public boolean isSame(int idx, boolean value) {
            return values[idx].equals(value);
        }

        public void xor() {
            for (int i = 0; i < values.length; ++i) {
                if (values[i] != null) {
                    values[i] = !values[i];
                }
            }
        }

        public void swap() {
            for (int i = 0; i < values.length / 2; ++i) {
                Boolean tmp = values[i];
                values[i] = values[values.length - i - 1];
                values[values.length - i - 1] = tmp;
            }
        }

        public Integer getSameIdx() {
            for (int i = 0; i < values.length / 2; ++i) {
                Boolean first = values[i];
                Boolean second = values[values.length - i - 1];
                if (first != null && second != null) {
                    if (first.equals(second)) {
                        return i;
                    }
                }
            }
            return null;
        }

        public Integer getDifferentIdx() {
            for (int i = 0; i < values.length / 2; ++i) {
                Boolean first = values[i];
                Boolean second = values[values.length - i - 1];
                if (first != null && second != null) {
                    if (!first.equals(second)) {
                        return i;
                    }
                }
            }
            return null;
        }

        public Integer getIndexToAsk() {
            for (int i = 0; i < values.length / 2 + 1; ++i) {
                if (values[i] == null) {
                    return i;
                }
                if (values[values.length - i - 1] == null) {
                    return values.length - i - 1;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return Stream.of(values).map(v -> v ? "1" : "0").collect(Collectors.joining(""));
        }
    }

    private static boolean getValueOnIndex(final Scanner scanner, int index) {
        System.out.println(index);
        System.out.flush();
        return scanner.nextInt() == 1;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        int bitCount = scanner.nextInt();
        for (int test = 1; test <= testCount; test++) {
            final BitSet bitSet = new BitSet(bitCount);
            int requestsLeft = 10;
            Integer indexToAsk;
            while ((indexToAsk = bitSet.getIndexToAsk()) != null) {
                if (requestsLeft == 0) {
                    requestsLeft = 10;
                    final Set<String> operationsAllowed = new HashSet<>();
                    operationsAllowed.add("nop");
                    operationsAllowed.add("swap");
                    operationsAllowed.add("xor");
                    operationsAllowed.add("swapxor");

                    final Integer sameIdx = bitSet.getSameIdx();
                    if (sameIdx != null) {
                        final boolean value = getValueOnIndex(scanner, sameIdx);
                        requestsLeft--;
                        if (bitSet.isSame(sameIdx, value)) {
                            operationsAllowed.remove("xor");
                            operationsAllowed.remove("swapxor");
                        } else {
                            operationsAllowed.remove("nop");
                            operationsAllowed.remove("swap");
                        }
                    }

                    final Integer diffIdx = bitSet.getDifferentIdx();
                    if (diffIdx != null) {
                        final boolean value = getValueOnIndex(scanner, diffIdx);
                        requestsLeft--;
                        if (bitSet.isSame(diffIdx, value)) {
                            operationsAllowed.remove("swap");
                            operationsAllowed.remove("xor");
                        } else {
                            operationsAllowed.remove("nop");
                            operationsAllowed.remove("swapxor");
                        }
                    }

                    final String operation = operationsAllowed.iterator().next();
                    if ("swap".equals(operation)) {
                        bitSet.swap();
                    } else if ("xor".equals(operation)) {
                        bitSet.xor();
                    } else if ("swapxor".equals(operation)) {
                        bitSet.swap();
                        bitSet.xor();
                    }
                } else {
                    bitSet.set(indexToAsk, getValueOnIndex(scanner, indexToAsk));
                    requestsLeft--;
                }
            }
            System.out.println(bitSet.toString());
        }
    }
}