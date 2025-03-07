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
            BitSet clone = new BitSet(values.length);
            System.arraycopy(values, 0, clone.values, 0, values.length);
            return clone;
        }

        private void applyOperation(String operation) {
            switch (operation) {
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

        private void equalize(BitSet other) {
            for (int i = 0; i < values.length; i++) {
                if ((values[i] == null) != (other.values[i] == null)) {
                    values[i] = null;
                }
            }
        }

        public void set(int index, boolean value) {
            values[index] = value;
        }

        public boolean isSame(int index, boolean value) {
            return values[index].equals(value);
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

        public Integer getSameIndex() {
            for (int i = 0; i < values.length / 2; i++) {
                Boolean first = values[i];
                Boolean second = values[values.length - i - 1];
                if (first != null && second != null && first.equals(second)) {
                    return i;
                }
            }
            return null;
        }

        public Integer getDifferentIndex() {
            for (int i = 0; i < values.length / 2; i++) {
                Boolean first = values[i];
                Boolean second = values[values.length - i - 1];
                if (first != null && second != null && !first.equals(second)) {
                    return i;
                }
            }
            return null;
        }

        public Integer getIndexToAsk() {
            for (int i = 0; i < (values.length / 2 + 1); i++) {
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

    private static boolean getValueAtIndex(Scanner scanner, int index) {
        System.out.println(index + 1);
        System.out.flush();
        return scanner.nextInt() == 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        int bitCount = scanner.nextInt();

        for (int test = 1; test <= testCount; test++) {
            BitSet bitSet = new BitSet(bitCount);
            int requestsLeft = 10;
            Integer indexToAsk;

            while ((indexToAsk = bitSet.getIndexToAsk()) != null) {
                if (requestsLeft == 0) {
                    Set<String> operationsAllowed = new HashSet<>(Arrays.asList("nop", "swap", "xor", "swapxor"));
                    requestsLeft = 10;

                    Integer sameIndex = bitSet.getSameIndex();
                    if (sameIndex != null) {
                        boolean value = getValueAtIndex(scanner, sameIndex);
                        requestsLeft--;
                        if (bitSet.isSame(sameIndex, value)) {
                            operationsAllowed.remove("xor");
                            operationsAllowed.remove("swapxor");
                        } else {
                            operationsAllowed.remove("nop");
                            operationsAllowed.remove("swap");
                        }
                    }

                    Integer differentIndex = bitSet.getDifferentIndex();
                    if (differentIndex != null) {
                        boolean value = getValueAtIndex(scanner, differentIndex);
                        requestsLeft--;
                        if (bitSet.isSame(differentIndex, value)) {
                            operationsAllowed.remove("swap");
                            operationsAllowed.remove("xor");
                        } else {
                            operationsAllowed.remove("nop");
                            operationsAllowed.remove("swapxor");
                        }
                    }

                    if (operationsAllowed.size() == 2) {
                        Iterator<String> iterator = operationsAllowed.iterator();
                        BitSet clone = bitSet.clone();
                        bitSet.applyOperation(iterator.next());
                        clone.applyOperation(iterator.next());

                        Integer differingIndex = bitSet.getDifferentIndex(clone);
                        if (differingIndex != null) {
                            boolean value = getValueAtIndex(scanner, differingIndex);
                            requestsLeft--;
                            if (clone.values[differingIndex] == value) {
                                bitSet = clone;
                            }
                        } else {
                            bitSet.equalize(clone);
                        }
                    } else {
                        bitSet.applyOperation(operationsAllowed.iterator().next());
                    }
                } else {
                    bitSet.set(indexToAsk, getValueAtIndex(scanner, indexToAsk));
                    requestsLeft--;
                }
            }

            System.out.println(bitSet.toString());
            System.out.flush();

            if (scanner.next().equalsIgnoreCase("N")) {
                throw new RuntimeException("Oops");
            }
        }
    }
}