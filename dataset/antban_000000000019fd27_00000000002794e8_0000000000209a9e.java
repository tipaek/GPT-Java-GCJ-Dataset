import java.util.HashSet;
import java.util.Iterator;
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

        public BitSet clone() {
            final BitSet other = new BitSet(values.length);
            for (int i = 0; i < values.length; ++i) {
                other.values[i] = values[i];
            }
            return other;
        }

        private void applyOp(final String op) {
            if (op.equals("swap")) {
                swap();
            } else if (op.equals("xor")) {
                xor();
            } else if (op.equals("swapxor")) {
                swap();
                xor();
            }
        }

        public Integer getDifferentIndex(BitSet other) {
            for (int i = 0; i < values.length; ++i) {
                if (values[i] != null && other.values[i] != null && !values[i].equals(other.values[i])) {
                    return i;
                }
            }
            return null;
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
            for (int i = 0; i < (values.length / 2 + 1); ++i) {
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
        System.out.println(index + 1);
        System.out.flush();
        final int value = scanner.nextInt();
        return value == 1;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        int bitCount = scanner.nextInt();
        for (int test = 1; test <= testCount; test++) {
            BitSet bs = new BitSet(bitCount);
            int requestsLeft = 10;
            Integer indexToAsk = null;
            while (null != (indexToAsk = bs.getIndexToAsk())) {
                if (requestsLeft == 0) {
                    // now let's figure out rotation, don't forget to reduce requestsLeft
                    final Set<String> operationsAllowed = new HashSet<>();
                    operationsAllowed.add("nop");
                    operationsAllowed.add("swap");
                    operationsAllowed.add("xor");
                    operationsAllowed.add("swapxor");
                    requestsLeft = 10;

                    final Integer sameIdx = bs.getSameIdx();
                    if (null != sameIdx) {
                        final boolean value = getValueOnIndex(scanner, sameIdx);
                        requestsLeft -= 1;
                        if (bs.isSame(sameIdx, value)) {
                            operationsAllowed.remove("xor");
                            operationsAllowed.remove("swapxor");
                        } else {
                            operationsAllowed.remove("nop");
                            operationsAllowed.remove("swap");
                        }
                    }
                    final Integer diffIdx = bs.getDifferentIdx();
                    if (null != diffIdx) {
                        final boolean value = getValueOnIndex(scanner, diffIdx);
                        requestsLeft -= 1;
                        if (bs.isSame(diffIdx, value)) {
                            operationsAllowed.remove("swap");
                            operationsAllowed.remove("xor");
                        } else {
                            operationsAllowed.remove("nop");
                            operationsAllowed.remove("swapxor");
                        }
                    }
                    if (operationsAllowed.size() == 2) {
                        Iterator<String> opit = operationsAllowed.iterator();
                        final BitSet clone = bs.clone();
                        bs.applyOp(opit.next());
                        clone.applyOp(opit.next());
                        final Integer valuesDifferntIdx = bs.getDifferentIndex(clone);
                        if (valuesDifferntIdx != null) {
                            final boolean value = getValueOnIndex(scanner, valuesDifferntIdx);
                            requestsLeft -= 1;
                            if (clone.values[valuesDifferntIdx] == value) {
                                bs = clone;
                            }
                        }
                    } else {
                        bs.applyOp(operationsAllowed.iterator().next());
                    }
                    final String operation = operationsAllowed.iterator().next();
                } else {
                    bs.set(indexToAsk, getValueOnIndex(scanner, indexToAsk));
                    requestsLeft -= 1;
                }
            }
            System.out.println(bs.toString());
            System.out.flush();
            final String v = scanner.next();
            if (v.equalsIgnoreCase("N")) {
                throw new RuntimeException("Oops");
            }
        }
    }

}
