import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    private static class BitSet {
        private Boolean[] values;

        public BitSet(int size) {
            values = new Boolean[size];
        }

        public BitSet clone() {
            BitSet other = new BitSet(values.length);
            System.arraycopy(values, 0, other.values, 0, values.length);
            return other;
        }

        private void applyOp(String op) {
            switch (op) {
                case "swap":
                    swap();
                    break;
                case "xor":
                    xor();
                    break;
                case "swapxor":
                    swap();
                    xor();
                    break;
            }
        }

        public Integer getDifferentIndex(BitSet other) {
            for (int i = 0; i < values.length; i++) {
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
            for (int i = 0; i < values.length; i++) {
                if (values[i] != null) {
                    values[i] = !values[i];
                }
            }
        }

        public void swap() {
            for (int i = 0; i < values.length / 2; i++) {
                Boolean temp = values[i];
                values[i] = values[values.length - i - 1];
                values[values.length - i - 1] = temp;
            }
        }

        public Integer getSameIdx() {
            for (int i = 0; i < values.length / 2; i++) {
                if (values[i] != null && values[values.length - i - 1] != null && values[i].equals(values[values.length - i - 1])) {
                    return i;
                }
            }
            return null;
        }

        public Integer getDifferentIdx() {
            for (int i = 0; i < values.length / 2; i++) {
                if (values[i] != null && values[values.length - i - 1] != null && !values[i].equals(values[values.length - i - 1])) {
                    return i;
                }
            }
            return null;
        }

        public Integer getIndexToAsk() {
            for (int i = 0; i <= values.length / 2; i++) {
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
        return scanner.nextInt() == 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        int bitCount = scanner.nextInt();

        for (int test = 1; test <= testCount; test++) {
            BitSet bs = new BitSet(bitCount);
            int requestsLeft = 10;
            Integer indexToAsk;

            while ((indexToAsk = bs.getIndexToAsk()) != null) {
                if (requestsLeft == 0) {
                    Set<String> operationsAllowed = new HashSet<>(Arrays.asList("nop", "swap", "xor", "swapxor"));
                    requestsLeft = 10;

                    Integer sameIdx = bs.getSameIdx();
                    if (sameIdx != null) {
                        boolean value = getValueOnIndex(scanner, sameIdx);
                        requestsLeft--;
                        if (bs.isSame(sameIdx, value)) {
                            operationsAllowed.removeAll(Arrays.asList("xor", "swapxor"));
                        } else {
                            operationsAllowed.removeAll(Arrays.asList("nop", "swap"));
                        }
                    }

                    Integer diffIdx = bs.getDifferentIdx();
                    if (diffIdx != null) {
                        boolean value = getValueOnIndex(scanner, diffIdx);
                        requestsLeft--;
                        if (bs.isSame(diffIdx, value)) {
                            operationsAllowed.removeAll(Arrays.asList("swap", "xor"));
                        } else {
                            operationsAllowed.removeAll(Arrays.asList("nop", "swapxor"));
                        }
                    }

                    if (operationsAllowed.size() == 2) {
                        Iterator<String> opIt = operationsAllowed.iterator();
                        BitSet clone = bs.clone();
                        bs.applyOp(opIt.next());
                        clone.applyOp(opIt.next());

                        Integer valuesDifferentIdx = bs.getDifferentIndex(clone);
                        if (valuesDifferentIdx != null) {
                            boolean value = getValueOnIndex(scanner, valuesDifferentIdx);
                            requestsLeft--;
                            if (clone.values[valuesDifferentIdx] == value) {
                                bs = clone;
                            }
                        }
                    }

                    bs.applyOp(operationsAllowed.iterator().next());
                } else {
                    bs.set(indexToAsk, getValueOnIndex(scanner, indexToAsk));
                    requestsLeft--;
                }
            }

            System.out.println(bs.toString());
            System.out.flush();

            if (scanner.next().equalsIgnoreCase("N")) {
                throw new RuntimeException("Oops");
            }
        }
    }
}